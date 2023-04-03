package com.odinkirk.codecserver.controller.DTO;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EncodeRequest {
    private String codec;
    private String originalMessage;
}
