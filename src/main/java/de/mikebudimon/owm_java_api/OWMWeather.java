package de.mikebudimon.owm_java_api;

import com.google.gson.Gson;

import java.io.IOException;

/**
 * Automatically requests, receives and saves current weather data,
 * Get current weather through currentData object.
 */
public class OWMWeather {

    /**
     * Contains OpenWeatherMap Api-call options.
     */
    public enum Option {
        CURRENT, FORECAST5
    }

    private String appId;
    private String city;
    private CurrentData currentData;
    private Forecast5Data forecast5Data;

    /**
     * Constructor
     *
     * @param appId AppId from OpenWeatherMap.
     * @param city  City name.
     */
    public OWMWeather(String appId, String city) {
        this.appId = appId;
        this.city = city;
    }

    /**
     * @return CurrentData object for receiving requested OpenWeatherMap data.
     */
    public CurrentData getCurrentData() {
        return currentData;
    }

    /**
     * @return Forecast5Data object for receiving requested OpenWeatherMap data.
     */
    public Forecast5Data getForecast5Data() {
        return forecast5Data;
    }


    /**
     * Executes a HttpClient request and the response is saved into the CurrentData.class with the help of the Gson library.
     *  @param option Api-call option
     */
    public void executeRequest(Option option) {

        String apiCall = null;

        switch (option) {
            case CURRENT:
                apiCall = "http://api.openweathermap.org/data/2.5/weather?q=";
                break;
            case FORECAST5:
                apiCall = "http://api.openweathermap.org/data/2.5/forecast?q=";
                break;
        }

        HttpClient httpClient = new HttpClient(apiCall + city + "&" + "appid=" + appId);

        Gson gson = new Gson();
        try {
            switch (option) {
                case CURRENT:
                    this.currentData = gson.fromJson(httpClient.getResponse(), CurrentData.class);
                    break;
                case FORECAST5:
                    this.forecast5Data = gson.fromJson(httpClient.getResponse(), Forecast5Data.class);
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
