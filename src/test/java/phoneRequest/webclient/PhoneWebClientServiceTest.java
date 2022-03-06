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
        System.out.println("getPhoneList = ");
         PhoneDTO phoneDTO = (PhoneDTO) phoneWebClientService.getPhoneList().block().get(0);
        System.out.println("이걸 어떻게 해야하지"+phoneDTO.toString());



    }

}