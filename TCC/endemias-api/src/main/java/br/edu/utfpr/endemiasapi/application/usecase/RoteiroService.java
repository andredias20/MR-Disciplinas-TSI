package br.edu.utfpr.endemiasapi.application.usecase;

import br.edu.utfpr.endemiasapi.domain.entity.roteiro.Roteiro;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoteiroService {

    public final List<String> enderecos;

    public RoteiroService(){
        this.enderecos = List.of(
                "Rua Presidente Costa e Silva, 104",
                "Rua Presidente Costa e Silva, 106",
                "Rua Presidente Costa e Silva, 100",
                "Rua Presidente Costa e Silva, 102",
                "Rua Presidente Costa e Silva, 108",
                "Rua Presidente Costa e Silva, 110",
                "Rua Presidente Costa e Silva, 112",
                "Rua Presidente Costa e Silva, 114",
                "Rua Presidente Costa e Silva, 116",
                "Rua Presidente Costa e Silva, 118",
                "Rua Presidente Costa e Silva, 120",
                "Rua Presidente Costa e Silva, 122",
                "Rua Presidente Costa e Silva, 124",
                "Rua Presidente Costa e Silva, 126",
                "Rua Presidente Costa e Silva, 128"
        );
    }

    public Roteiro getRoteirosDoDia(){
        Roteiro roteiro = Roteiro.builder()
                .dataDoRoteiro(new Date())
                .enderecos(enderecos)
                .build();
        return roteiro;
    }
}
