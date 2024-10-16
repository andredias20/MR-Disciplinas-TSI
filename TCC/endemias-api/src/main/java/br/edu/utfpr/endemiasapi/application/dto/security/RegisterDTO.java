package br.edu.utfpr.endemiasapi.application.dto.security;

import lombok.Data;

@Data
public class RegisterDTO {

    private String username;
    private String password;
    private String role;

}
