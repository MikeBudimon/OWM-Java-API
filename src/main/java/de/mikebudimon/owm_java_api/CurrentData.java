package de.mikebudimon.owm_java_api;

import java.util.List;

/**
 * Holds current OpenWeatherMap data.
 */
public class CurrentData {

    private String name;
    private String dt;
    private int id;

    public CurrentData() {
    }

    /**
     * @return City name.
     */
    public String getName() {
        return name;
    }

    /**
     * @return Time of data calculation, unix, UTC.
     */
    public String getDatetime() {
        return dt;
    }

    /**
     * @return City ID.
     */
    public int getId() {
        return id;
    }


    /**
     * OpenWeatherMap coordination data.
     */
    public static class Coord {
        private float lon;
        private float lat;

        /**
         * @return City geo location, latitude.
         */
        public float getLongitude() {
            return lon;
        }

        /**
         * @return City geo location, longitude.
         */
        public float getLatitude() {
            return lat;
        }
    }

    /**
     * OpenWeatherMap weather data(description and icon).
     */
    public static class Weather {
        private String description;
        private String icon;


        /**
         * @return Weather condition within the group.
         */
        public String getDescription() {
            return description;
        }

        /**
         * @return Weather icon id.
         */
        public String getIcon() {
            return icon;
        }
    }

    /**
     * OpenWeatherMap main weather data.
     */
    public static class Main {
        private float temp;
        private float pressure;
        private int humidity;
        private float temp_min;
        private float temp_max;

        /**
         * @return Temperature in Kelvin.
         */
        public float getTemp() {
            return temp;
        }

        /**
         * @return Atmospheric pressure on the sea level by default in hPa.
         */
        public float getPressure() {
            return pressure;
        }

        /**
         * @return Humidity in %.
         */
        public int getHumidity() {
            return humidity;
        }

        /**
         * @return Minimum temperature at the moment of calculation in Kelvin.
         */
        public float getTemp_min() {
            return temp_min;
        }

        /**
         * @return Maximum temperature at the moment of calculation in Kelvin.
         */
        public float getTemp_max() {
            return temp_max;
        }
    }

    /**
     * OpenWeatherMap wind data.
     */
    public static class Wind {
        private float speed;
        private float deg;

        /**
         * @return Wind speed in meter/sec.
         */
        public float getSpeed() {
            return speed;
        }

        /**
         * @return Wind direction in degrees(meteorological).
         */
        public float getDirection() {
            return deg;
        }
    }

    /**
     * OpenWeatherMap system data.
     */
    public static class Sys {
        private String country;
        private String sunrise;
        private String sunset;

        /**
         * @return Country code (GB, JP etc.).
         */
        public String getCountry() {
            return country;
        }

        /**
         * @return Sunrise time, unix, UTC.
         */
        public String getSunrise() {
            return sunrise;
        }

        /**
         * @return Sunset time, unix, UTC.
         */
        public String getSunset() {
            return sunset;
        }
    }

    /**
     * OpenWeatherMap coordination data.
     */
    public Coord coord;
    /**
     * OpenWeatherMap weather info data(description and icon).
     */
    public List<Weather> weather;
    /**
     * OpenWeatherMap main weather data.
     */
    public Main main;
    /**
     * OpenWeatherMap wind data.
     */
    public Wind wind;

    /**
     * OpenWeatherMap system data.
     */
    public Sys sys;
}
