package br.edu.utfpr.endemiasapi.infrastructure.repositories;

import br.edu.utfpr.endemiasapi.domain.entity.atendimento.Atendimento;
import org.springframework.data.repository.CrudRepository;

public interface AtendimentoRepository extends CrudRepository<Atendimento, String> {
}
