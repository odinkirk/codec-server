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

/**
 * This class is used to make HTTP requests to the application.
 */
@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class PackHttpClient {

    private final String SERVER_URL = "http://localhost";
    private final String THINGS_ENDPOINT = "/codec";

    @LocalServerPort
    private int port;
    private final RestTemplate restTemplate = new RestTemplate();


    /**
     * This method is used to build the endpoint for the application.
     * @return the endpoint for the application.
     */
    private String thingsEndpoint() {
        return serverLocation() + THINGS_ENDPOINT;
    }

    /**
     * This method is used to build the server location for the application.
     * @return the server location for the application.
     */
    private String serverLocation() {
        return SERVER_URL + ":" + port;
    }

    /**
     * This method is used to make a POST request to the application.
     * @param payload The payload to send to the application.
     * @param endpoint  The endpoint to send the request to.
     * @return the status code of the response.
     * @param <T> The type of the payload.
     */
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

    /**
     * This method is used to make a GET request to the application.
     * @return the response from the application.
     */
    public ResponseEntity<Pack<String>> getContents() {
        return restTemplate.exchange(thingsEndpoint(), HttpMethod.GET, null,
                new ParameterizedTypeReference<Pack<String>>() {});
    }

    public void clean() {
        restTemplate.delete(thingsEndpoint());
    }


}