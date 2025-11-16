package br.edu.infnet.common.model.dto;

import br.edu.infnet.common.model.domain.Cliente;
import br.edu.infnet.common.model.domain.Endereco;
import br.edu.infnet.common.model.domain.Pet;
import br.edu.infnet.common.util.Util;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Setter
@Getter
public class ClienteResponseDTO {

    private Integer id;

    private String nome;

    private String cpf;

    private String rg;

    private String dataNascimento;

    private String sexo;

    private String estadoCivil;

    private String telefone;

    private String email;

    private LocalDateTime clienteDeste;

    private Boolean status;

    private Endereco endereco;

    private String cepConsulta;

    private List<Pet> pets;

    public ClienteResponseDTO() {}

    public ClienteResponseDTO(Cliente cliente) {
        this.setId(cliente.getId());
        this.setNome(cliente.getNome());
        this.setCpf(cliente.getCpf());
        this.setRg(cliente.getRg());
        this.setDataNascimento(Util.convertlocalDateTimeToString(cliente.getDataNascimento()));
        this.setSexo(cliente.getSexo());
        this.setEstadoCivil(cliente.getEstadoCivil());
        this.setTelefone(cliente.getTelefone());
        this.setEmail(cliente.getEmail());
        this.setEndereco(cliente.getEndereco());
        this.setClienteDeste(cliente.getClienteDeste());
        this.setStatus(cliente.getStatus());
        this.setCepConsulta(cliente.getCepConsulta());
        this.setPets(cliente.getPets());
    }

    @Override
    public String toString() {
        return "ClienteResponseDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", sexo='" + sexo + '\'' +
                ", estadoCivil='" + estadoCivil + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", clienteDeste=" + clienteDeste +
                ", status=" + status +
                ", endereco=" + endereco +
                ", cepConsulta='" + cepConsulta + '}';
    }
}