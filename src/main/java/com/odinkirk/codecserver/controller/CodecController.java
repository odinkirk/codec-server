package com.odinkirk.codecserver.controller;

import com.odinkirk.codecserver.model.EncodeRequest;
import com.odinkirk.codecserver.model.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;

@RestController
@RequestMapping("/codec")
public class CodecController {

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
