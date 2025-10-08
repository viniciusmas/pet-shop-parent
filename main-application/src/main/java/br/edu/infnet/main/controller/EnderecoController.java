package br.edu.infnet.main.controller;

import br.edu.infnet.common.model.dto.EnderecoRequestDTO;
import br.edu.infnet.main.model.service.ViaCepService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

    private final ViaCepService viaCepService;

    public EnderecoController(ViaCepService viaCepService) {
        this.viaCepService = viaCepService;
    }

    @GetMapping(value = "/{cep}")
    public ResponseEntity<EnderecoRequestDTO> obterEndereco(@PathVariable("cep") String cep) {
        EnderecoRequestDTO enderecoRequestDTO = viaCepService.getEnderecoViaCep(cep);
        return ResponseEntity.ok(enderecoRequestDTO);
    }
}