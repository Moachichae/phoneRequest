package phoneRequest.webclient;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.springframework.web.reactive.function.client.WebClient.*;

@Service
public class PhoneWebClientService {

    private final String url = "http://localhost:8081";
    WebClient webclient = create(url);

    public String getPhoneString() {
        RequestHeadersSpec<?> headersSpec = webclient.method(HttpMethod.GET) // method
                .uri("/phoneString") // uri
                .bodyValue("data");
        defineHeadersOfGet(headersSpec); //헤더 정의

        return Objects.requireNonNull(headersSpec.retrieve()
                .bodyToMono(String[].class)
                .block())[0];
    }

    public Mono<List> getPhoneList(){
        RequestHeadersSpec<?> headersSpec = webclient.method(HttpMethod.GET) // method
                .uri("/phoneList") // uri
                .bodyValue("data");
        defineHeadersOfGet(headersSpec); //헤더 정의

        return headersSpec.retrieve()
                .bodyToMono(List.class);
    }


    public Mono<Map> getPhoneMap(){
        RequestHeadersSpec<?> headersSpec = webclient.method(HttpMethod.GET) // method
                .uri("/phoneMap") // uri
                .bodyValue("data");
        defineHeadersOfGet(headersSpec); //헤더 정의

        return headersSpec.retrieve()
                .bodyToMono(Map.class);
    }






    //헤더 정의메서드(get 방식)
    private void defineHeadersOfGet(RequestHeadersSpec<?> headersSpec) {
        headersSpec.header(
                        HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .acceptCharset(StandardCharsets.UTF_8)
                .ifNoneMatch("*")
                .ifModifiedSince(ZonedDateTime.now())
                .retrieve(); //헤더 정의
    }

}
