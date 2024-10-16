package br.edu.utfpr.endemiasapi.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResDTO {

    HttpStatus status;
    String message;

}
