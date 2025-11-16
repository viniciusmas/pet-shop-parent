package br.edu.infnet.common.model.domain;

import br.edu.infnet.common.model.dto.FuncionarioRequestDTO;
import br.edu.infnet.common.model.dto.FuncionarioResponseDTO;
import br.edu.infnet.common.util.Util;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
public class Funcionario extends Pessoa {

    private String cargo;

    private BigDecimal salario;

    private BigDecimal bonus;

    public Funcionario() {}

    public Funcionario(FuncionarioRequestDTO funcionarioRequestDTO) {
        this.setNome(funcionarioRequestDTO.getNome());
        this.setCpf(funcionarioRequestDTO.getCpf());
        this.setRg(funcionarioRequestDTO.getRg());
        this.setDataNascimento(Util.convertStingTolocalDateTime(funcionarioRequestDTO.getDataNascimento()));
        this.setSexo(funcionarioRequestDTO.getSexo());
        this.setEstadoCivil(funcionarioRequestDTO.getEstadoCivil());
        this.setTelefone(funcionarioRequestDTO.getTelefone());
        this.setEmail(funcionarioRequestDTO.getEmail());
        this.setCargo(funcionarioRequestDTO.getCargo());
        this.setSalario(funcionarioRequestDTO.getSalario());
        this.setBonus(funcionarioRequestDTO.getBonus());
        this.setCepConsulta(funcionarioRequestDTO.getCepConsulta());
    }

    public Funcionario(FuncionarioResponseDTO funcionarioResponseDTO) {
        this.setId(funcionarioResponseDTO.getId());
        this.setNome(funcionarioResponseDTO.getNome());
        this.setCpf(funcionarioResponseDTO.getCpf());
        this.setRg(funcionarioResponseDTO.getRg());
        this.setDataNascimento(Util.convertStingTolocalDateTime(funcionarioResponseDTO.getDataNascimento()));
        this.setSexo(funcionarioResponseDTO.getSexo());
        this.setEstadoCivil(funcionarioResponseDTO.getEstadoCivil());
        this.setTelefone(funcionarioResponseDTO.getTelefone());
        this.setEmail(funcionarioResponseDTO.getEmail());
        this.setEndereco(funcionarioResponseDTO.getEndereco());
        this.setCargo(funcionarioResponseDTO.getCargo());
        this.setSalario(funcionarioResponseDTO.getSalario());
        this.setBonus(funcionarioResponseDTO.getBonus());
        this.setCepConsulta(funcionarioResponseDTO.getCepConsulta());
    }
    

    @JsonIgnore
    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Agendamento> agendamentos;

    @Override
    public String toString() {
        return String.format("Funcionario { %s Cargo = %s, Salário = %.2f, Bônus = %.2f }", super.toString(), cargo, salario, bonus);
    }

    @Override
    public String obterTipo() {
        return "Funcionario";
    }
}