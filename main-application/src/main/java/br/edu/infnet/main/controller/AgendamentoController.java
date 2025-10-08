package br.edu.infnet.main.controller;

import br.edu.infnet.common.model.domain.Agendamento;
import br.edu.infnet.common.model.dto.AgendamentoRequestDTO;
import br.edu.infnet.common.model.dto.AgendamentoResponseDTO;
import br.edu.infnet.main.model.service.AgendamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @PostMapping
    public ResponseEntity<AgendamentoResponseDTO> criarAgendamento(@RequestBody AgendamentoRequestDTO agendamentoRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(agendamentoService.criarAgendamento(new Agendamento(agendamentoRequestDTO)));
    }
}