package com.rikkei_bank.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenRefreshRequest {
    @NotBlank(message = "Refresh Token không được để trống")
    private String refreshToken;
}
