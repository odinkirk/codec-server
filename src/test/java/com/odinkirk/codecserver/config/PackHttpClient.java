package com.odinkirk.codecserver.config;


import com.odinkirk.codecserver.model.EncodeRequest;
import com.odinkirk.codecserver.util.Pack;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Scope;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class PackHttpClient {

    private final String SERVER_URL = "http://localhost";
    private final String THINGS_ENDPOINT = "/codec";

    @LocalServerPort
    private int port;
    private final RestTemplate restTemplate = new RestTemplate();


    private String thingsEndpoint() {
        return SERVER_URL + ":" + port + THINGS_ENDPOINT;
    }

    private String serverLocation() {
        return SERVER_URL + ":" + port;
    }

    public <T> int put(final T payload, final String endpoint) {
        int result = 0;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<T> entity = new HttpEntity<>(payload, headers);

        ResponseEntity<Void> response = restTemplate.postForEntity(serverLocation() + endpoint, entity, Void.class);
//        ResponseEntity<Void> response = restTemplate.postForEntity(serverLocation() + endpoint, payload, Void.class);
        result = response.getStatusCodeValue();
        return result;
    }

    public int put(final String something) {
        return restTemplate.postForEntity(thingsEndpoint(), something, Void.class).getStatusCodeValue();
    }

    public ResponseEntity<Pack<String>> getContents() {
        return restTemplate.exchange(thingsEndpoint(), HttpMethod.GET, null,
                new ParameterizedTypeReference<Pack<String>>() {});
    }

    public void clean() {
        restTemplate.delete(thingsEndpoint());
    }


}