package com.odinkirk.codecserver.controller;

import com.odinkirk.codecserver.model.EncodeRequest;
import com.odinkirk.codecserver.model.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;

/**
 * This class is used to handle requests to the /codec endpoint. The codec endpoint is used to encode and decode text.
 */
@RestController
@RequestMapping("/codec")
public class CodecController {

    /**
     * This method is used to encode a message.
     * @param encodeRequest The request containing the message and codec to use.
     * @return a response containing the encoded message.
     */
    @PostMapping("/encode")
    public Response encode(@RequestBody EncodeRequest encodeRequest) {
        Message message = Message.builder()
                .codec(encodeRequest.getCodec())
                .message(encodeRequest.getMessage())
                .encoded("WIP")
                .build();
        return Response.ok(message).build();
    }
}
