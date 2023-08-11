package laveemcasa.api_lave_em_casa.controllers;

import laveemcasa.api_lave_em_casa.models.UsuariosProprietarios;
import laveemcasa.api_lave_em_casa.services.ProprietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("*")
@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {

    private final ProprietarioService proprietarioService;

    @Autowired
    public ProprietarioController(ProprietarioService proprietarioService) {
        this.proprietarioService = proprietarioService;
    }

    @PostMapping
    public ResponseEntity<UsuariosProprietarios> criarProprietario(@RequestBody UsuariosProprietarios proprietario) {
        UsuariosProprietarios novoProprietario = proprietarioService.criarProprietario(proprietario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProprietario);
    }
}
