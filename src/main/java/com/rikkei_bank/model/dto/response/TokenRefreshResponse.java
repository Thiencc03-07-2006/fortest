package com.rikkei_bank.model.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TokenRefreshResponse {
    private String accessToken;
    private String refreshToken;
}
