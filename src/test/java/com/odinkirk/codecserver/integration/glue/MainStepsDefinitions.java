package com.odinkirk.codecserver.integration.glue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.odinkirk.codecserver.config.PackHttpClient;
import com.odinkirk.codecserver.model.EncodeRequest;
import com.odinkirk.codecserver.model.Message;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DefaultDataTableCellTransformer;
import io.cucumber.java.DefaultDataTableEntryTransformer;
import io.cucumber.java.DefaultParameterTransformer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static com.odinkirk.codecserver.DataTableConverter.fromDatatableToList;
import static org.junit.Assert.assertEquals;


public class MainStepsDefinitions {

    private final String baseUrl = "http://localhost";
    private final String codecEndpoint = "/codec";
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final List<ResponseEntity<Message>> result = new ArrayList<>();
    @LocalServerPort
    protected int port;
    Logger log = LoggerFactory.getLogger(MainStepsDefinitions.class);
    @Autowired
    private PackHttpClient packHttpClient;
    private final List<EncodeRequest> originalMessages = new ArrayList<>();
    private List<Integer> responseCodes;

    public MainStepsDefinitions() {
        super();
    }


    @Given("a text message")
    public void GivenATextMessage(final DataTable table) {
        log.debug("Running givenATextMessage");
        originalMessages.clear();
        originalMessages.addAll(fromDatatableToList(table, EncodeRequest.class));

    }

    @When("the user encodes the message")
    public void whenEncode() {
        log.debug("Running whenEncode");
        encode(originalMessages);
    }

    @Then("the response is 200 OK")
    public void is200() {
        log.debug("Running is200");
        responseCodes.forEach(r -> assertEquals(200, r.intValue()));
    }

    @Then("the encoded message is:")
    public void thenEncodedMessage(DataTable table) {
        // TODO: Update with live assertions
        List<Message> messageList = fromDatatableToList(table, Message.class);
        assertEquals(3, messageList.size());
        // assert that the encoded message matches the expected message
        assertEquals("Khoor Zruog", messageList.get(0).getEncoded());
        assertEquals("vdph", messageList.get(1).getEncoded());
        assertEquals("jhwv", messageList.get(2).getEncoded());
    }

    @DefaultParameterTransformer
    @DefaultDataTableEntryTransformer
    @DefaultDataTableCellTransformer
    public Object transformer(Object fromValue, Type toValueType) {
        return objectMapper.convertValue(fromValue, objectMapper.constructType(toValueType));
    }

    private String getCodecEndpoint() {
        return baseUrl + ":" + port + codecEndpoint;
    }

    private void encode(List<EncodeRequest> message) {
//        packHttpClient.clean(); Once persistence is set up, this will be needed
        responseCodes = new ArrayList<>();
        message.forEach(m -> {
            responseCodes.add(packHttpClient.put(m, "/codec/encode"));
        });
    }

}
