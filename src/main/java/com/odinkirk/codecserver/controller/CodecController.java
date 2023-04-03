package com.odinkirk.codecserver.controller;

import com.odinkirk.codecserver.controller.DTO.EncodeRequest;
import com.odinkirk.codecserver.controller.DTO.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;

@RestController("/codec")
public class CodecController {

    @PostMapping("/encode")
    public Response encode(@RequestBody EncodeRequest encodeRequest) {
        Message message = Message.builder()
                .codec(encodeRequest.getCodec())
                .originalMessage(encodeRequest.getOriginalMessage())
                .encodedMessage("WIP")
                .build();
        return Response.ok(message).build();
    }
}
