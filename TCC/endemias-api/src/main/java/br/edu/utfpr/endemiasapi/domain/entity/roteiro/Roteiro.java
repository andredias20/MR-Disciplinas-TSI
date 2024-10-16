package br.edu.utfpr.endemiasapi.domain.entity.roteiro;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Roteiro {
    private Date dataDoRoteiro;
    private List<String> enderecos;
}
