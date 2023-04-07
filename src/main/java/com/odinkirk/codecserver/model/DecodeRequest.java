package com.odinkirk.codecserver.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DecodeRequest {
    private String codec;
    private String encodedMessage;
}
