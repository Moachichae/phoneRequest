package phoneRequest.restTemplate;

import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneRestTemplateService {

    private final RestTemplate restTemplate;

    public PhoneRestTemplateService() {
        restTemplate = new RestTemplate();
    }

    public String[] getPhoneString() {
        String url = "http://localhost:8081/phoneString";
        return restTemplate.getForObject(url, String[].class); //인코딩 문제로인해 값을 크기가 1인 배열로 받았음.
    }

    public List<PhoneDTO> getPhoneList() {
        String url = "http://localhost:8081/phoneList";
        return Arrays.asList(restTemplate.getForObject(url, PhoneDTO[].class));
        //list로 값을 받아올시 list값 안에 Phone 객체가 아닌 LinkedHashMap 객체를 가지고 있는 문제가 발생하여
        //배열로 받아온 후 값을 list로 변경하였음.
    }

    public Map<String, Object> getPhoneMap() {
        String url = "http://localhost:8081/phoneMap";
        return restTemplate.getForObject(url, HashMap.class);
    }

    public String[] postPhoneString(String id, String password) {
        String url = "http://localhost:8081/phoneString";
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        params.put("password", password); //로그인 성공시 값을 반환해줌
        return restTemplate.postForObject(url, params, String[].class); //인코딩 문제로인해 값을 크기가 1인 배열로 받았음.
    }

    public List<PhoneDTO> postPhoneList(String id, String password) {
        String url = "http://localhost:8081/phoneList";
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        params.put("password", password); //로그인 성공시 값을 반환해줌
        return Arrays.asList(restTemplate.postForObject(url, params, PhoneDTO[].class));
        //list로 값을 받아올시 list값 안에 Phone 객체가 아닌 LinkedHashMap 객체를 가지고 있는 문제가 발생하여
        //배열로 받아온 후 값을 list로 변경하였음.
    }

    public Map<String, Object> postPhoneMap(String id, String password) {
        String url = "http://localhost:8081/phoneMap";
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        params.put("password", password); //로그인 성공시 값을 반환해줌
        return restTemplate.postForObject(url, params, Map.class);
    }


}
