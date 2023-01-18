import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class FirstGetReq {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        String getUrl = "https://reqres.in/api/users/2";

        String getResp = restTemplate.getForObject(getUrl, String.class);
        System.out.println();
        System.out.println(getResp);

        String postURL = "https://reqres.in/api/users";
        Map<String, String> json2Send = new HashMap<>();
        json2Send.put("name", "Evgeny");
        json2Send.put("job", "Java Dev");
        HttpEntity<Map<String,String>>postRequest = new HttpEntity<>(json2Send);

        String PostResp = restTemplate.postForObject(postURL, postRequest, String.class);
        System.out.println(postRequest);
        System.out.println(PostResp);
    }
}
