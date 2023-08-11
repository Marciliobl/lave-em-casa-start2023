package laveemcasa.api_lave_em_casa.controllers;

import laveemcasa.api_lave_em_casa.models.Anuncios;
import laveemcasa.api_lave_em_casa.services.AnuncioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/anuncios")
public class AnuncioController {

    private final AnuncioService anuncioService;

    @Autowired
    public AnuncioController(AnuncioService anuncioService) {
        this.anuncioService = anuncioService;
    }

    @PostMapping("/{proprietarioId}")
    public ResponseEntity<Anuncios> criarAnuncio(@PathVariable Integer proprietarioId, @RequestBody Anuncios anuncio) {
        Anuncios novoAnuncio = anuncioService.criarAnuncio(proprietarioId, anuncio);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAnuncio);
    }

    @GetMapping
    public ResponseEntity<List<Anuncios>> getAnuncios() {
        List<Anuncios> anuncios = anuncioService.getAnuncios();
        return ResponseEntity.ok(anuncios);
    }
}
