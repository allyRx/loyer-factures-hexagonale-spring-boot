package net.ally.loyersfactueshexagonalespringboot.adapter.input.web;


import net.ally.loyersfactueshexagonalespringboot.adapter.input.dto.locataire.RequestDto;
import net.ally.loyersfactueshexagonalespringboot.adapter.input.dto.locataire.ResponseDto;
import net.ally.loyersfactueshexagonalespringboot.domain.model.bien.Bien;
import net.ally.loyersfactueshexagonalespringboot.domain.model.locataire.Locataire;
import net.ally.loyersfactueshexagonalespringboot.domain.port.input.BienUsecase;
import net.ally.loyersfactueshexagonalespringboot.domain.port.input.LocataireUsecase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/locataire")
public class LocataireController {
    private final LocataireUsecase locataireUsecase;
    private final  BienUsecase bienUsecase;

    public LocataireController( BienUsecase bienUsecase,LocataireUsecase locataireUsecase) {
        this.bienUsecase = bienUsecase;
        this.locataireUsecase=locataireUsecase;
    }

    @PostMapping
    public ResponseEntity<ResponseDto> save(@RequestBody RequestDto requestDto) {
       List<UUID> biensIds = requestDto.getBiens();

       List<Bien> biens = new ArrayList<>();
       if (biensIds != null && !biensIds.isEmpty()) {
           for (UUID bienId : biensIds) {
              Bien bien = bienUsecase.recupererBienParId(bienId).orElseThrow();
               biens.add(bien);
           }

       }

       Locataire locataire = locataireUsecase.ajouterLocataire(requestDto.getName(), requestDto.getEmail(), requestDto.getTelephone(),requestDto.getDate_entree(),biens);

       return new ResponseEntity<>(toResponse(locataire),HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<ResponseDto>> getAllLocataires() {
        List<ResponseDto> locataires = locataireUsecase.recupererLocateurs().stream().map(this::toResponse).toList();
        return ResponseEntity.ok(locataires);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseDto> getLocataireById(@PathVariable  UUID id) {
        return locataireUsecase.recupererLocateurParId(id).map(locataire -> new ResponseEntity<>(toResponse(locataire), HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @DeleteMapping("{id}")
    public void deleteLocataireById(@PathVariable  UUID id) {
        locataireUsecase.supprimerLocateur(id);
    }

    public ResponseDto toResponse(Locataire locateur) {

        return new ResponseDto(
                locateur.getId().toString(),
                locateur.getName(),
                locateur.getEmail(),
                locateur.getTelephone(),
                locateur.getDate_entree(),
                locateur.getBiens()
        );
    }
}
