package de.mikebudimon.owm_java_api;

/**
 * Holds forecast 5days/3hours OpenWeatherMap data.
 */
public class Forecast5Data {

    public Forecast5Data() {
    }

    /**
     * OpenWeatherMap city data.
     */
    public static class City {
        private int id;
        private String name;
        private String country;

        /**
         * @return Country code (GB, JP etc.).
         */
        public String getCountry() {
            return country;
        }

        /**
         * @return City ID.
         */
        public int getId() {
            return id;
        }

        /**
         * @return City name.
         */
        public String getName() {
            return name;
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
         * OpenWeatherMap coordination data.
         */
        public Coord coord;

    }

    /**
     * OpenWeatherMap list data. Contains main weather, wind and weather info data in a list.
     */
    public static class List {
        private String dt_txt;

        /**
         * @return Data/time of calculation, UTC.
         */
        public String getDatetime() {
            return dt_txt;
        }

        /**
         * OpenWeatherMap main weather data.
         */
        public static class Main {
            private float temp;
            private float temp_min;
            private float temp_max;
            private float pressure;
            private int humidity;

            /**
             * @return Temperature in Kelvin.
             */
            public float getTemp() {
                return temp;
            }

            /**
             * @return Minimum temperature at the moment of calculation in Kelvin.
             */
            public float getTemp_min() {
                return temp_min;
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
             * @return Maximum temperature at the moment of calculation in Kelvin.
             */
            public float getTemp_max() {
                return temp_max;
            }
        }

        /**
         * OpenWeatherMap weather info data(description and icon)
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
         * OpenWeatherMap wind data
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
         * OpenWeatherMap main weather data.
         */
        public Main main;
        /**
         * OpenWeatherMap weather info data(description and icon).
         */
        public java.util.List<Weather> weather;
        /**
         * OpenWeatherMap wind data.
         */
        public Wind wind;
    }

    /**
     * OpenWeatherMap city data.
     */
    public City city;
    /**
     * OpenWeatherMap list data. Contains main weather, wind and weather info data in a list.
     */
    public java.util.List<List> list;
}
