package de.mikebudimon.owm_java_api;

import com.google.gson.Gson;

import java.io.IOException;

/**
 * Automatically requests, receives and saves current weather data,
 * Get current weather through currentWeather object.
 */
public class OpenWeatherMap {

    private String appId;
    private String city;
    private CurrentWeather currentWeather;
    private ForecastWeather forecastWeather;

    /**
     * Constructor
     *
     * @param appId AppId from OpenWeatherMap.
     * @param city  City name.
     */
    public OpenWeatherMap(String appId, String city) {
        this.appId = appId;
        this.city = city;
    }

    /**
     * @return CurrentWeather object for receiving requested OpenWeatherMap data.
     */
    public CurrentWeather getCurrentWeather() {
        return currentWeather;
    }

    /**
     * @return ForecastWeather object for receiving requested OpenWeatherMap data.
     */
    public ForecastWeather getForecastWeather() {
        return forecastWeather;
    }

    /**
     * Executes a HttpClient request and the response is saved into the CurrentWeather.class with the help of the Gson library.
     *
     * @param option Api-call option
     */
    public void executeRequest(Option option) {

        String apiCall = null;

        switch (option) {
            case CURRENT:
                apiCall = "http://api.openweathermap.org/data/2.5/weather?q=";
                break;
            case FORECAST:
                apiCall = "http://api.openweathermap.org/data/2.5/forecast?q=";
                break;
        }

        HttpClient httpClient = new HttpClient(apiCall + city + "&" + "appid=" + appId);

        Gson gson = new Gson();
        try {
            switch (option) {
                case CURRENT:
                    this.currentWeather = gson.fromJson(httpClient.getResponse(), CurrentWeather.class);
                    break;
                case FORECAST:
                    this.forecastWeather = gson.fromJson(httpClient.getResponse(), ForecastWeather.class);
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Contains OpenWeatherMap Api-call options.
     */
    public enum Option {
        CURRENT, FORECAST
    }


}
