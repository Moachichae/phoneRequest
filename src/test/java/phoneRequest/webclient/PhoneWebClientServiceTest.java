package phoneRequest.webclient;

import org.junit.jupiter.api.Test;
import phoneRequest.PhoneDTO;

import java.util.Arrays;
import java.util.List;


class PhoneWebClientServiceTest {

    PhoneWebClientService phoneWebClientService = new PhoneWebClientService();

    @Test
    public void webClientTest() throws Exception {
       //List
         PhoneDTO phoneDTO = (PhoneDTO) phoneWebClientService.getPhoneList().block().get(0);



    }

}