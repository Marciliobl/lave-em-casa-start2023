package laveemcasa.api_lave_em_casa.services;

import laveemcasa.api_lave_em_casa.models.UsuariosProprietarios;
import laveemcasa.api_lave_em_casa.repository.ProprietariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProprietarioService {

    private final ProprietariosRepository proprietariosRepository;

    @Autowired
    public ProprietarioService(ProprietariosRepository proprietariosRepository) {
        this.proprietariosRepository = proprietariosRepository;
    }

    public UsuariosProprietarios criarProprietario(UsuariosProprietarios proprietario) {
        return proprietariosRepository.save(proprietario);
    }
}

