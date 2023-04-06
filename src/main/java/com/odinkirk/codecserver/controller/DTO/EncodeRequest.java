package com.odinkirk.codecserver.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EncodeRequest {
    private String codec;
    private String originalMessage;
}
