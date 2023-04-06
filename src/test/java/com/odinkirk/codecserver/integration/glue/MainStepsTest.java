package com.odinkirk.codecserver.integration.glue;

import com.odinkirk.codecserver.controller.DTO.Message;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;


public class MainStepsTest {

    private final String baseUrl = "http://localhost";
    private final String codecEndpoint = "/codec";
    private final RestTemplate restTemplate = new RestTemplate();
    @LocalServerPort
    protected int port;
    Logger log = Logger.getLogger(MainStepsTest.class.getName());
    private List<String> originalMessages;
    private List<ResponseEntity<Message>> result;

    public MainStepsTest() {
        super();
    }


    @Given("a text message:")
    public void a_message_of(List<String> message) {
        log.warning("Running givenMessage");
        originalMessages = message;

    }

    @When("the user encodes the message")
    public void whenEncode() {
        log.warning("Running whenEncode");
        encode(originalMessages);
    }

    @Then("the response is 200 OK")
    public void is200() {
        log.warning("Running is200");
        result.forEach(r -> assertEquals(200, r.getStatusCodeValue()));
    }

    @Then("the encoded message is:")
    public void encodedMessage(List<String> encodedMessages) {
        // TODO: Update with live assertions
        assertEquals(encodedMessages.get(0), "foo");
        assertEquals(encodedMessages.get(1), "bar");
        assertEquals(encodedMessages.get(2), "foobar");


    }

    private String getCodecEndpoint() {
        return baseUrl + ":" + port + codecEndpoint;
    }

    private void encode(List<String> message) {
        clean();
        // stream the list of messages and run this expression on them. The ResponseEntity<Message> should be added to result.
        message.forEach(m -> {
            ResponseEntity<Message> response = restTemplate.postForEntity(getCodecEndpoint() + "/encode", m, Message.class);
            result.add(response);
        });
    }

    private void clean() {
        restTemplate.delete(getCodecEndpoint());
    }
}
