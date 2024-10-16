package br.edu.utfpr.endemiasapi.application.dto.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResDTO {
    private String token;
}
