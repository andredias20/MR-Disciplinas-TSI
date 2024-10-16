package br.edu.utfpr.endemiasapi.application.mapper;


import br.edu.utfpr.endemiasapi.domain.entity.atendimento.Atendimento;
import br.edu.utfpr.endemiasapi.application.dto.atendimento.AtendimentoDTO;
import org.mapstruct.Mapper;

@Mapper
public interface AtendimentoMapper {
    AtendimentoDTO atendimentoToAtendimentoDTO(Atendimento atendimento);
    Atendimento atendimentoDTOToAtendimento(AtendimentoDTO atendimentoDTO);
}
