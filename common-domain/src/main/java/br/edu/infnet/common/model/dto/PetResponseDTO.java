package br.edu.infnet.common.model.dto;

import br.edu.infnet.common.model.domain.Cliente;
import br.edu.infnet.common.model.domain.Pet;
import br.edu.infnet.common.model.domain.TipoEspecie;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetResponseDTO {

    private Integer id;

    private String nome;

    private TipoEspecie tipoEspecie;

    private String raca;

    private Integer idade;

    private Double peso;

    private Cliente tutor;

    public PetResponseDTO(Pet pet) {
        this.setId(pet.getId());
        this.setNome(pet.getNome());
        this.setTipoEspecie(pet.getTipoEspecie());
        this.setRaca(pet.getRaca());
        this.setIdade(pet.getIdade());
        this.setPeso(pet.getPeso());
        this.setTutor(pet.getTutor());
    }

    @Override
    public String toString() {
        return "PetResponseDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipoEspecie=" + tipoEspecie +
                ", raca='" + raca + '\'' +
                ", idade=" + idade +
                ", peso=" + peso +
                ", tutor=" + tutor +
                '}';
    }
}
