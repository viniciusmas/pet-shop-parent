package br.edu.infnet.main.controller;

import br.edu.infnet.common.model.domain.Pet;
import br.edu.infnet.common.model.dto.IdadeDTO;
import br.edu.infnet.common.model.dto.PetRequestDTO;
import br.edu.infnet.common.model.dto.PetResponseDTO;
import br.edu.infnet.main.model.service.PetService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PetResponseDTO> incluir(@Valid @RequestBody PetRequestDTO petRequestDTO) {
        PetResponseDTO petNovo = petService.incluir(new Pet(petRequestDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(petNovo);
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PetResponseDTO> alterar(@PathVariable("id") Integer id, @Valid @RequestBody PetRequestDTO petRequestDTO) {
        PetResponseDTO petAlterado = petService.alterar(id, new Pet(petRequestDTO));
        return ResponseEntity.ok(petAlterado);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> excluir(@PathVariable("id") Integer id) {
        petService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<PetResponseDTO>> obterLista() {
        List<PetResponseDTO> pets = petService.obterLista();
        if (pets.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pets);
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<PetResponseDTO> obterPorId(@PathVariable("id") Integer id) {
        PetResponseDTO pet = petService.obterPorId(id);
        return ResponseEntity.ok(pet);
    }

    @GetMapping(value = "/idades")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<PetResponseDTO>> obterPorIdades(@RequestBody IdadeDTO idadeDTO) {
        List<PetResponseDTO> pets = petService.obterPorIdades(idadeDTO.getIdadeMin(), idadeDTO.getIdadeMax());
        return ResponseEntity.ok(pets);
    }

    @GetMapping(value = "/contem/{nome}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<PetResponseDTO>> obterPorNomeContem(@PathVariable("nome") String nome) {
        List<PetResponseDTO> pet = petService.obterPorNomeContem(nome);
        return ResponseEntity.ok(pet);
    }
}