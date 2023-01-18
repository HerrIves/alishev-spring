package meteo;

import java.util.ArrayList;

public class MeteoJSON {
    // import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */

        public String product;
        public String init;
        public ArrayList<Dataseries> dataseries;

        public String getProduct() {
                return product;
        }

        public void setProduct(String product) {
                this.product = product;
        }

        public String getInit() {
                return init;
        }

        public void setInit(String init) {
                this.init = init;
        }

        public ArrayList<Dataseries> getDataseries() {
                return dataseries;
        }

        public void setDataseries(ArrayList<Dataseries> dataseries) {
                this.dataseries = dataseries;
        }

        @Override
        public String toString() {
                return "MeteoJSON{" +
                        "product='" + product + '\'' +
                        ", init='" + init + '\'' +
                        ", \n dataseries=" + dataseries +
                        '}';
        }
}

class Dataseries {
        public int date;
        public String weather;
        public Temp2m temp2m;
        public int wind10m_max;

        public int getDate() {
                return date;
        }

        public void setDate(int date) {
                this.date = date;
        }

        public String getWeather() {
                return weather;
        }

        public void setWeather(String weather) {
                this.weather = weather;
        }

        public Temp2m getTemp2m() {
                return temp2m;
        }

        public void setTemp2m(Temp2m temp2m) {
                this.temp2m = temp2m;
        }

        public int getWind10m_max() {
                return wind10m_max;
        }

        public void setWind10m_max(int wind10m_max) {
                this.wind10m_max = wind10m_max;
        }

        @Override
        public String toString() {
                return "date=" + date +
                        "\n";
        }
}
class Temp2m {
        public int max;
        public int min;

        public int getMax() {
                return max;
        }

        public void setMax(int max) {
                this.max = max;
        }

        public int getMin() {
                return min;
        }

        public void setMin(int min) {
                this.min = min;
        }
}


