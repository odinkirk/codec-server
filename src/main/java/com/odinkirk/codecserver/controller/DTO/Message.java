package com.odinkirk.codecserver.controller.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message {

    private String originalMessage;
    private String encodedMessage;
    private String codec;
}
