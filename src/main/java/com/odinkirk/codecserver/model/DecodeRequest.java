package com.odinkirk.codecserver.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class is used to represent a request to decode a message.
 */
@Data
@NoArgsConstructor
public class DecodeRequest {
    private String codec;
    private String encodedMessage;
}
