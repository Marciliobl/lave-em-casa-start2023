package laveemcasa.api_lave_em_casa.services;

import laveemcasa.api_lave_em_casa.models.Anuncios;
import laveemcasa.api_lave_em_casa.models.UsuariosProprietarios;
import laveemcasa.api_lave_em_casa.repository.AnuncioRepository;
import laveemcasa.api_lave_em_casa.repository.ProprietariosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnuncioService {

    private final AnuncioRepository anuncioRepository;
    private final ProprietariosRepository proprietariosRepository;

    public AnuncioService(AnuncioRepository anuncioRepository, ProprietariosRepository proprietariosRepository) {
        this.anuncioRepository = anuncioRepository;
        this.proprietariosRepository = proprietariosRepository;
    }

    public Anuncios criarAnuncio(Integer proprietarioId, Anuncios anuncio) {
        UsuariosProprietarios proprietario = proprietariosRepository.findById(proprietarioId)
                .orElseThrow(() -> new RuntimeException("Usuário proprietário não encontrado"));
        anuncio.setProprietario(proprietario);


        Anuncios novoAnuncio = anuncioRepository.save(anuncio);

        return novoAnuncio;
    }

    public List<Anuncios> getAnuncios() {
        return anuncioRepository.findAll();
    }

}
