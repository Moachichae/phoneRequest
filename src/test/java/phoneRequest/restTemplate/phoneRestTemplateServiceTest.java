package phoneRequest.restTemplate;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import phoneRequest.PhoneDTO;

import java.util.List;
import java.util.Map;

@Slf4j
class phoneRestTemplateServiceTest {

    @Autowired
    PhoneRestTemplateService phoneRestTemplateService;

    @Test
    void getPhoneString() {
        System.out.print("getString :  \n" + phoneRestTemplateService.getPhoneString()[0]);
    }


    @Test
    void getPhoneList() {
        List<PhoneDTO> phoneList = phoneRestTemplateService.getPhoneList();
        phoneList.forEach(phone -> System.out.print("getPhoneList :  \n" + phone.toString()));
    }

    @Test
    void getPhoneMap() {
        Map<String, Object> phoneMap = phoneRestTemplateService.getPhoneMap();
        System.out.println("getMap");
        System.out.println(phoneMap.get("채승호2"));
        for (String key : phoneMap.keySet()) {
            System.out.print("getPhoneMap :  \n" + phoneMap.get(key));
        }
    }

    @Test
    void postPhoneString() {
        System.out.print("postString :  \n" + phoneRestTemplateService.postPhoneString("rhdiddl4432", "123")[0]);
    }
}