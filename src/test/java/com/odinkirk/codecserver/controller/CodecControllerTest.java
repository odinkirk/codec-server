package com.odinkirk.codecserver.controller;

import com.odinkirk.codecserver.model.EncodeRequest;
import com.odinkirk.codecserver.model.Message;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class is used to test the CodecController class.
 */
public class CodecControllerTest {

    private final CodecController codecController = new CodecController();

    /**
     * This method is used to test the encode method.
     */
    @Test
    public void testEncode() {
        String originalMessage = "Hello World";
        EncodeRequest encodeRequest = EncodeRequest.builder()
                .codec("ROT13")
                .message(originalMessage)
                .build();
        Response response = codecController.encode(encodeRequest);
        Message responseMessage = (Message) response.getEntity();
        assertEquals(response.getStatus(), HttpStatus.OK.value());
        assertEquals(originalMessage, responseMessage.getMessage());
    }
}
