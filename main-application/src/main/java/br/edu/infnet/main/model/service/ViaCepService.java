package br.edu.infnet.main.model.service;

import br.edu.infnet.api.clients.ViaCepFeignClient;
import br.edu.infnet.common.model.dto.EnderecoRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ViaCepService {

    private final ViaCepFeignClient viaCepFeignClient;

    public ViaCepService(ViaCepFeignClient viaCepFeignClient) {
        this.viaCepFeignClient = viaCepFeignClient;
    }

    public EnderecoRequestDTO getEnderecoViaCep(String cep) {

        EnderecoRequestDTO enderecoRequestDTO = viaCepFeignClient.findByCep(cep.replace("-", ""));

        if (enderecoRequestDTO == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CEP inválido ou não encontrado.");
        }
        return enderecoRequestDTO;
    }
}