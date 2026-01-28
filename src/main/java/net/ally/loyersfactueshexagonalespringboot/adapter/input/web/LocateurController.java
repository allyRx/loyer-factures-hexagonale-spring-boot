package net.ally.loyersfactueshexagonalespringboot.adapter.input.web;

import net.ally.loyersfactueshexagonalespringboot.adapter.input.dto.locateur.RequestLocateur;
import net.ally.loyersfactueshexagonalespringboot.adapter.input.dto.locateur.ResponseLocateur;
import net.ally.loyersfactueshexagonalespringboot.domain.model.bien.Bien;
import net.ally.loyersfactueshexagonalespringboot.domain.model.locateur.Locateur;
import net.ally.loyersfactueshexagonalespringboot.domain.port.input.BienUsecase;
import net.ally.loyersfactueshexagonalespringboot.domain.port.input.LocateurUsecase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/locuteur")
public class LocateurController {

    private final  LocateurUsecase locateurUsecase;
    private final BienUsecase bienUsecase;
    public LocateurController(LocateurUsecase locateurUsecase, BienUsecase bienUsecase){
        this.locateurUsecase = locateurUsecase;
        this.bienUsecase = bienUsecase;
    }

    @PostMapping
    public ResponseEntity<ResponseLocateur> enrgistrerLocateur(@RequestBody RequestLocateur requestLocateur){
        // 1. Récupérer les UUIDs des biens
        List<UUID> bienIds = requestLocateur.getBiens();

        // 2. Convertir les UUIDs en objets Bien (si des biens sont spécifiés)
        List<Bien> biens = new ArrayList<>();
        if (bienIds != null && !bienIds.isEmpty()) {
            for (UUID bienId : bienIds) {
                // Récupérer le bien depuis le service
                Bien bien = bienUsecase.recupererBienParId(bienId).orElseThrow();
                biens.add(bien);
            }
        }

        Locateur locateur = locateurUsecase.sauvegarderLocateur(requestLocateur.getName(), requestLocateur.getEmail(), requestLocateur.getTelephone(),biens);

       return new ResponseEntity<>(toResponse(locateur), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<ResponseLocateur>> toutLesLocuteur(){
        List<ResponseLocateur> locateur = locateurUsecase.recupererToutLocateur().stream().map(this::toResponse).collect(Collectors.toList());
        return new ResponseEntity<>(locateur,HttpStatus.OK);
    }


    @GetMapping("{id}")
    public ResponseEntity<ResponseLocateur>  recupererLocateurParId(@PathVariable UUID id){
        return  locateurUsecase.recupererLocateurParId(id).map(locateur -> new ResponseEntity<>(toResponse(locateur) , HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @DeleteMapping("{id}")
    public void supprimetLocateur(@PathVariable UUID id){
        locateurUsecase.supprimerLocateur(id);
    }

        ResponseLocateur toResponse(Locateur locateur){
            return new ResponseLocateur(
                    locateur.getId().toString(),
                    locateur.getName(),
                    locateur.getEmail(),
                    locateur.getTelephone(),
                    locateur.getBiens()
            );
        }

}
