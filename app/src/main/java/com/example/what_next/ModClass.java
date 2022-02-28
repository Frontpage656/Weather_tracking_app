package com.example.what_next;

public class ModClass {

    String weather_state_name;
    int id;
    String weather_state_abbr;
    String wind_direction_compass;
    String created;
    String applicable_date;
    float min_temp;
    float max_temp;
    float wind_speed;
    float wind_direction;
    float air_pressure;
    int humidity;
    int visibility;
    int predictability;

    public ModClass() {
    }

    @Override
    public String toString() {
        return
                "id " + id +"\n"+
                "weather name '" + weather_state_name + '\'' +"\n"+
                "wind direction '" + wind_direction_compass + '\'' +"\n"+
                "min temp=" + min_temp +"\n"+
                "max temp " + max_temp +"\n"+
                "wind speed " + wind_speed +"\n"+
                "wind direction " + wind_direction +"\n"+
                "air pressure " + air_pressure +"\n"+
                "humidity " + humidity +"\n"+
                "visibility " + visibility;
    }

    public ModClass(int id, String weather_state_name, String weather_state_abbr, String wind_direction_compass, String created, String applicable_date, float min_temp, float max_temp, float wind_speed, float wind_direction, float air_pressure, int humidity, int visibility, int predictability) {
        this.weather_state_name = weather_state_name;
        this.id = id;
        this.weather_state_abbr = weather_state_abbr;
        this.wind_direction_compass = wind_direction_compass;
        this.created = created;
        this.applicable_date = applicable_date;
        this.min_temp = min_temp;
        this.max_temp = max_temp;
        this.wind_speed = wind_speed;
        this.wind_direction = wind_direction;
        this.air_pressure = air_pressure;
        this.humidity = humidity;
        this.visibility = visibility;
        this.predictability = predictability;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWeather_state_name() {
        return weather_state_name;
    }

    public void setWeather_state_name(String weather_state_name) {
        this.weather_state_name = weather_state_name;
    }

    public String getWeather_state_abbr() {
        return weather_state_abbr;
    }

    public void setWeather_state_abbr(String weather_state_abbr) {
        this.weather_state_abbr = weather_state_abbr;
    }

    public String getWind_direction_compass() {
        return wind_direction_compass;
    }

    public void setWind_direction_compass(String wind_direction_compass) {
        this.wind_direction_compass = wind_direction_compass;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getApplicable_date() {
        return applicable_date;
    }

    public void setApplicable_date(String applicable_date) {
        this.applicable_date = applicable_date;
    }

    public float getMin_temp() {
        return min_temp;
    }

    public void setMin_temp(float min_temp) {
        this.min_temp = min_temp;
    }

    public float getMax_temp() {
        return max_temp;
    }

    public void setMax_temp(float max_temp) {
        this.max_temp = max_temp;
    }

    public float getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(float wind_speed) {
        this.wind_speed = wind_speed;
    }

    public float getWind_direction() {
        return wind_direction;
    }

    public void setWind_direction(float wind_direction) {
        this.wind_direction = wind_direction;
    }

    public float getAir_pressure() {
        return air_pressure;
    }

    public void setAir_pressure(float air_pressure) {
        this.air_pressure = air_pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public int getPredictability() {
        return predictability;
    }

    public void setPredictability(int predictability) {
        this.predictability = predictability;
    }
}
