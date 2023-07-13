package com.dtaem.sadvet.model.bean;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginRequestBean {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
