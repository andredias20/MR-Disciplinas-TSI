package br.edu.utfpr.endemiasapi.application.usecase;

import br.edu.utfpr.endemiasapi.domain.entity.atendimento.Atendimento;
import br.edu.utfpr.endemiasapi.infrastructure.repositories.AtendimentoRepository;
import br.edu.utfpr.endemiasapi.application.utils.Conversions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtendimentoService {

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    public Atendimento save(Atendimento atendimento) {
        //TODO: Regra de negocio aqui
        return atendimentoRepository.save(atendimento);
    }

    public Atendimento update(Atendimento atendimento, String id) {
        //TODO: Regra de negocio aqui
        return atendimentoRepository.save(atendimento);
    }

    public Optional<Atendimento> findById(String id) {
        Optional<Atendimento> atendimento = atendimentoRepository
                .findById(id);
        return atendimento;
    }

    public List<Atendimento> findAll() {
        List<Atendimento> atendimentos = Conversions.interableToList(atendimentoRepository.findAll());
        return atendimentos;
    }

}
