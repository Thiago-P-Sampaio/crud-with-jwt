package com.example.login_auth_rest_api_test2.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductDTO (
        @NotBlank
        String nameProduct,
        @NotNull
        float priceProduct) {
}
