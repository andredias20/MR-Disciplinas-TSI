package br.edu.utfpr.endemiasapi.domain.entity.security;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document("user")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AppUser {

    @MongoId
    private String id;
    private String username;
    private String password;
    private String role;

}
