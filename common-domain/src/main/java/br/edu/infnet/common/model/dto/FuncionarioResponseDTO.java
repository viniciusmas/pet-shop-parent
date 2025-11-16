package br.edu.infnet.common.model.dto;

import br.edu.infnet.common.model.domain.Endereco;
import br.edu.infnet.common.model.domain.Funcionario;
import br.edu.infnet.common.util.Util;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class FuncionarioResponseDTO {

    private Integer id;

    private String nome;

    private String cpf;

    private String rg;

    private String dataNascimento;

    private String sexo;

    private String estadoCivil;

    private String telefone;

    private String email;

    private Endereco endereco;

    private String cargo;

    private BigDecimal salario;

    private BigDecimal bonus;

    private String cepConsulta;

    public FuncionarioResponseDTO() {}

    public FuncionarioResponseDTO(Funcionario funcionario) {
        this.setId(funcionario.getId());
        this.setNome(funcionario.getNome());
        this.setCpf(funcionario.getCpf());
        this.setRg(funcionario.getRg());
        this.setDataNascimento(Util.convertlocalDateTimeToString(funcionario.getDataNascimento()));
        this.setSexo(funcionario.getSexo());
        this.setEstadoCivil(funcionario.getEstadoCivil());
        this.setTelefone(funcionario.getTelefone());
        this.setEmail(funcionario.getEmail());
        this.setEndereco(funcionario.getEndereco());
        this.setCargo(funcionario.getCargo());
        this.setSalario(funcionario.getSalario());
        this.setBonus(funcionario.getBonus());
        this.setCepConsulta(funcionario.getCepConsulta());
    }

    @Override
    public String toString() {
        return "FuncionarioResponseDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", sexo='" + sexo + '\'' +
                ", estadoCivil='" + estadoCivil + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", endereco=" + endereco +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                ", bonus=" + bonus +
                ", cepConsulta='" + cepConsulta + '\'' +
                '}';
    }
}