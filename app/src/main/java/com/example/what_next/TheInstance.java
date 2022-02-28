package com.example.what_next;

import android.content.Context;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class TheInstance {

    public static final String API_FOR_ID = "https://www.metaweather.com/api/location/search/?query=";
    public static final String API_FOR_WEATHER = "https://www.metaweather.com/api/location/";

    Context context;
    String text="";
    String info ="";

    public TheInstance(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener{
         void onResponse(String cty_info);
         void onError(String message);
    }
    public void cty_id(String text_input,VolleyResponseListener volleyResponseListener){

        text = API_FOR_ID+text_input;

//        RequestQueue requestQueue = Volley.newRequestQueue(context);

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, text, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {
                    JSONObject cty_info = response.getJSONObject(0);
                    info = cty_info.getString("woeid");

                    volleyResponseListener.onResponse(info);
                    Toast.makeText(context, info, Toast.LENGTH_SHORT).show();

                }catch (Exception e){

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show();
                volleyResponseListener.onError("something was wrong");
            }
        });

       SingletonClass.getInstance(context).addToRequestQueue(request);

    }



    public interface ForeCastBy_id{
        void onResponse(List<ModClass> modClasses);
        void onError(String message);
    }
    public void weather_id(String user_id, ForeCastBy_id foreCastById){

        String url = API_FOR_WEATHER+user_id;

        List<ModClass> report = new LinkedList<>();

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    JSONArray consolidate_report = response.getJSONArray("consolidated_weather");



                    for (int i=0; i <consolidate_report.length(); i++) {


                        ModClass one_day = new ModClass();
                        //Do casting here..
                        JSONObject first_day_from_api = (JSONObject) consolidate_report.get(i);

                        one_day.setId(first_day_from_api.getInt("id"));
                        one_day.setWeather_state_name(first_day_from_api.getString("weather_state_name"));
                        one_day.setWeather_state_abbr(first_day_from_api.getString("weather_state_abbr"));
                        one_day.setWind_direction_compass(first_day_from_api.getString("wind_direction_compass"));
                        one_day.setApplicable_date(first_day_from_api.getString("applicable_date"));
                        one_day.setMin_temp(first_day_from_api.getLong("min_temp"));
                        one_day.setMax_temp(first_day_from_api.getLong("max_temp"));
                        one_day.setWind_speed(first_day_from_api.getLong("wind_speed"));
                        one_day.setWind_direction(first_day_from_api.getLong("wind_direction"));
                        one_day.setAir_pressure(first_day_from_api.getLong("air_pressure"));
                        one_day.setHumidity(first_day_from_api.getInt("humidity"));
                        one_day.setPredictability(first_day_from_api.getInt("predictability"));

                        report.add(one_day);

                    }

                    //Add to response your list
                    foreCastById.onResponse(report);

                }catch (Exception e){

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                foreCastById.onError("Error");
            }
        });

        SingletonClass.getInstance(context).addToRequestQueue(request);
    }


    public interface ForeCastBy_name{
        void onResponse(List<ModClass> modClasses);
        void onError(String message);
    }
    public void cty_by_name(String cty_name, ForeCastBy_name foreCastBy_name){
       cty_id(cty_name, new VolleyResponseListener() {
           @Override
           public void onResponse(String cty_info) {
               weather_id(cty_info, new ForeCastBy_id() {
                   @Override
                   public void onResponse(List<ModClass> modClasses) {
                       //here call it
                       foreCastBy_name.onResponse(modClasses);
                   }

                   @Override
                   public void onError(String message) {

                   }
               });
           }

           @Override
           public void onError(String message) {

           }
       });
    }
}
