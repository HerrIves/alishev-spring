package meteo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

public class MeteoGetter {
    public static void main(String[] args) throws JsonProcessingException {
        String meteoURL = "http://www.7timer.info/bin/api.pl?lon=113.17&lat=23.09&product=civillight&output=json";
        RestTemplate restTemplate = new RestTemplate();

        String meteoResponse = restTemplate.getForObject(meteoURL, String.class);

        ObjectMapper mapper = new ObjectMapper();
        MeteoJSON meteoJSON = mapper.readValue(meteoResponse, MeteoJSON.class);

        System.out.println(meteoJSON);

    }
}
