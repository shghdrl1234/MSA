package com.example.userservice.vo;

import jakarta.annotation.Nullable;
import lombok.Data;

@Data
public class RequestUser {

    private String email;
    private String name;
    private String password;
}
