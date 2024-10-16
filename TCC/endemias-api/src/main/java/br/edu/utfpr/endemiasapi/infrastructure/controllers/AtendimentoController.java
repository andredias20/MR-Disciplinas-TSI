package br.edu.utfpr.endemiasapi.infrastructure.controllers;

import br.edu.utfpr.endemiasapi.entity.atendimento.dto.AtendimentoResponse;
import br.edu.utfpr.endemiasapi.application.facade.AtendimentoFacade;
import br.edu.utfpr.endemiasapi.application.dto.atendimento.AtendimentoDTO;
import br.edu.utfpr.endemiasapi.facade.dto.AtendimentoServiceDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/atendimento")
public class AtendimentoController {

    private final AtendimentoFacade atendimentoFacade;

    public AtendimentoController(AtendimentoFacade atendimentoFacade) {
        this.atendimentoFacade = atendimentoFacade;
    }


    @GetMapping(params = "id")
    public ResponseEntity<AtendimentoDTO> getAtendimento(String id) {
        Optional<AtendimentoDTO> atendimento = atendimentoFacade.buscarPorId(id);

        atendimento.orElseThrow();
        return ResponseEntity.accepted().body(atendimento);
    }

    @GetMapping
    public List<AtendimentoResponse> getAtendimentos(String id) {
        return atendimentoService.findAll();
    }

}
