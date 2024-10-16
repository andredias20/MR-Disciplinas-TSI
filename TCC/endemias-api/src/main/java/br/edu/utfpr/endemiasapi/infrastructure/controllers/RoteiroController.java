package br.edu.utfpr.endemiasapi.infrastructure.controllers;

import br.edu.utfpr.endemiasapi.domain.entity.roteiro.Roteiro;
import br.edu.utfpr.endemiasapi.application.usecase.RoteiroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roteiro")
public class RoteiroController {

    private final RoteiroService roteiroService;

    public RoteiroController(RoteiroService roteiroService) {
        this.roteiroService = roteiroService;
    }

    @GetMapping
    public ResponseEntity<Roteiro> buscarRoteiroDoDia() {
        return ResponseEntity.ok(roteiroService.getRoteirosDoDia());
    }
}
