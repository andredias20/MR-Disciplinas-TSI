package br.edu.utfpr.endemiasapi.domain.entity.atendimento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document("register")
@Getter
@AllArgsConstructor
public class Atendimento {

    @MongoId
    private String id;
    private String rua;
    private String numero;
    private String cidade;
    private boolean foiAtendido;
    private boolean houveAlteracoes;

}
