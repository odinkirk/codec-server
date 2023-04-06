package com.odinkirk.codecserver.controller.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DecodeRequest {
    private String codec;
    private String encodedMessage;
}
