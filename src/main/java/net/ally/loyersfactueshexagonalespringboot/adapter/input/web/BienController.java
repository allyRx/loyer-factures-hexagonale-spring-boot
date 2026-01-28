package net.ally.loyersfactueshexagonalespringboot.adapter.input.web;

import net.ally.loyersfactueshexagonalespringboot.adapter.input.dto.bien.RequestDto;
import net.ally.loyersfactueshexagonalespringboot.adapter.input.dto.bien.ResponseDto;
import net.ally.loyersfactueshexagonalespringboot.domain.model.bien.Bien;
import net.ally.loyersfactueshexagonalespringboot.domain.port.input.BienUsecase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/bien")
public class BienController {
    private final  BienUsecase bienUsecase;


    public BienController(BienUsecase bienUsecase) {
        this.bienUsecase = bienUsecase;
    }


    @PostMapping
    public ResponseEntity<ResponseDto> saveBien(@RequestBody RequestDto requestDto){
        Bien bien = bienUsecase.sauvegarderDeBien(requestDto.getReference(), requestDto.getAdresse(), requestDto.getLoyerMensuelle(), requestDto.isEstDisbonible());

        return new ResponseEntity<>(toResponse(bien),HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseDto> findBienById(@PathVariable  UUID id){
        return bienUsecase.recupererBienParId(id).map(bien -> new ResponseEntity<>(toResponse(bien), HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<ResponseDto>> getAllBien(){
        List<ResponseDto> biens =  bienUsecase.tousLesBien().stream().map(this::toResponse).toList();
        return new ResponseEntity<>(biens, HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public void deleteBien(@PathVariable UUID id){
        bienUsecase.supprimerDeBien(id);
    }

    ResponseDto toResponse(Bien bien){
        return new ResponseDto(
                bien.getId().toString(),
                bien.getReference(),
                bien.getAdresse(),
                bien.getLoyerMensuelle(),
                bien.estDisponible()
        );
    }
}
