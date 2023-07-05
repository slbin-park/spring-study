package com.example.securitystudy.dto;

import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TokenResponse {
    private String accessToken;
    private long time;
    public static TokenResponse of(String accessToken, long time) {
        return new TokenResponse(accessToken,time);
    }
}
