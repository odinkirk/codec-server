package com.odinkirk.codecserver.controller.DTO;

import lombok.Data;

@Data
public class DecodeRequest {
    private String codec;
    private String encodedMessage;
}
