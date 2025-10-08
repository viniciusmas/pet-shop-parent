package br.edu.infnet.main.controller;

import br.edu.infnet.common.model.domain.Cliente;
import br.edu.infnet.common.model.dto.ClienteRequestDTO;
import br.edu.infnet.common.model.dto.ClienteResponseDTO;
import br.edu.infnet.main.model.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> incluir(@Valid @RequestBody ClienteRequestDTO clienteRequestDTO) {
        ClienteResponseDTO clienteNovo = clienteService.incluir(new Cliente(clienteRequestDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteNovo);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteResponseDTO> alterar(@Valid @PathVariable("id") Integer id, @Valid @RequestBody ClienteRequestDTO clienteRequestDTO) {
        ClienteResponseDTO clienteAlterado = clienteService.alterar(id, new Cliente(clienteRequestDTO));
        return ResponseEntity.ok(clienteAlterado);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Integer id) {
        clienteService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> obterLista() {
        List<ClienteResponseDTO> clientes = clienteService.obterLista();
        if (clientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clientes);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteResponseDTO> obterPorId(@PathVariable("id") Integer id) {
        ClienteResponseDTO cliente = clienteService.obterPorId(id);
        return ResponseEntity.ok(cliente);
    }

    @PatchMapping(value = "/{id}/inativar")
    public ResponseEntity<ClienteResponseDTO> inativar(@PathVariable("id") Integer id) {
        ClienteResponseDTO cliente = clienteService.inativar(id);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<ClienteResponseDTO> obterPorCpf(@PathVariable("cpf") String cpf) {
        ClienteResponseDTO cliente = clienteService.obterPorCpf(cpf);
        return ResponseEntity.ok(cliente);
    }

}