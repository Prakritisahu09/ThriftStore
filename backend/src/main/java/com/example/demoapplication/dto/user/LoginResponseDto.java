package com.example.demoapplication.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto {
    private String status;
    private String message;

    private String firstName;

    public LoginResponseDto(String status, String message, String firstName) {
        this.status = status;
        this.message = message;
        this.firstName = firstName;
    }

    public LoginResponseDto() {
    }
}
