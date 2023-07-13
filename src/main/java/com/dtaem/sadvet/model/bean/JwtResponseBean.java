package com.dtaem.sadvet.model.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class JwtResponseBean {
    private String token;
    private String type = "Bearer";
    private String username;
    private String email;
    private List<String> roles;
}
