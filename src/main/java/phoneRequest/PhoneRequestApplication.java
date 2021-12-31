package phoneRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import phoneRequest.restTemplate.PhoneDTO;
import phoneRequest.restTemplate.PhoneRestTemplateService;

import java.util.List;
import java.util.Map;

@SpringBootApplication

public class PhoneRequestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhoneRequestApplication.class, args);

	}

	// restTemplate
	public static void phoneRestTemplateRequest(){
		PhoneRestTemplateService phoneRestTemplateService = new PhoneRestTemplateService();

		//getString
		String getPhoneString = phoneRestTemplateService.getPhoneString()[0];
		// 인코딩 문제로 길이가 0인 배열로 값을 받아옴
		System.out.println("getString");
		System.out.print(getPhoneString);

		//getList
		List<PhoneDTO> getPhoneList = phoneRestTemplateService.getPhoneList();
		System.out.println("getList");
		getPhoneList.forEach(x -> System.out.print(x.toString()));

		//getMap
		Map<String,Object> getPhoneMap = phoneRestTemplateService.getPhoneMap();
		System.out.println("getMap");
		for(String key : getPhoneMap.keySet()){
			System.out.print(key);
			System.out.println(getPhoneMap.get(key));
		}

		String id = "rhdiddl4432";
		String pw = "123";

		//postString
		String postPhoneString = phoneRestTemplateService.postPhoneString(id,pw)[0];
		// 인코딩 문제로 길이가 0인 배열로 값을 받아옴
		System.out.println("postString");
		System.out.print(postPhoneString);

		//postList
		List<PhoneDTO> postPhoneList = phoneRestTemplateService.postPhoneList(id,pw);
		System.out.println("postList");
		postPhoneList.forEach(x -> System.out.print(x.toString()));

		//postMap
		Map<String,Object> postPhoneMap = phoneRestTemplateService.postPhoneMap(id,pw);
		System.out.println("postMap");
		for(String key : postPhoneMap.keySet()){
			System.out.print(key);
			System.out.println(postPhoneMap.get(key));
		}

	}

}
