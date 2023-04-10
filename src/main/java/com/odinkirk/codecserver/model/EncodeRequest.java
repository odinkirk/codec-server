package com.odinkirk.codecserver.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class is used to represent a request to encode a message.
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EncodeRequest {
    private String codec;
    private String message;
}
