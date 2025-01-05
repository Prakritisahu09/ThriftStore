package com.example.demoapplication.dto.user;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserDto {
    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String address;

    private String phNumber;

    private String pincode;
}
