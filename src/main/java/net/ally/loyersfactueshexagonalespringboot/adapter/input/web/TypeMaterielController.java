package net.ally.loyersfactueshexagonalespringboot.adapter.input.web;

import jakarta.validation.Valid;
import net.ally.loyersfactueshexagonalespringboot.adapter.input.dto.typemateriel.TypeMaterielRequestDto;
import net.ally.loyersfactueshexagonalespringboot.adapter.input.dto.typemateriel.TypeMaterielResponseDto;
import net.ally.loyersfactueshexagonalespringboot.domain.model.typemateriel.TypeMateriel;
import net.ally.loyersfactueshexagonalespringboot.domain.port.input.TypeMaterielUsecase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/materiels/types")
public class TypeMaterielController {

    private final TypeMaterielUsecase usecase;

    public TypeMaterielController(TypeMaterielUsecase usecase) {
        this.usecase = usecase;
    }

    @PostMapping
    public ResponseEntity<TypeMaterielResponseDto> create(@Valid @RequestBody TypeMaterielRequestDto dto) {
        try {
            TypeMateriel t = usecase.sauvegarderTypeMateriel(dto.getNom(), dto.getPrixUnitaire());
            return new ResponseEntity<>(toResponse(t), HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<TypeMaterielResponseDto> findById(@PathVariable UUID id) {
        return usecase.recupererParId(id)
                .map(t -> new ResponseEntity<>(toResponse(t), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<TypeMaterielResponseDto>> findAll() {
        List<TypeMaterielResponseDto> dtos = usecase.tousLesTypeMateriels()
                .stream()
                .map(this::toResponse)
                .toList();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<TypeMaterielResponseDto> update(@PathVariable UUID id, @Valid @RequestBody TypeMaterielRequestDto dto) {
        try {
            TypeMateriel t = usecase.updateTypeMateriel(id, dto.getNom(), dto.getPrixUnitaire());
            return new ResponseEntity<>(toResponse(t), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        usecase.supprimerTypeMateriel(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private TypeMaterielResponseDto toResponse(TypeMateriel t) {
        return new TypeMaterielResponseDto(
                t.getId().toString(),
                t.getNom(),
                t.getPrixUnitaire()
        );
    }
}
