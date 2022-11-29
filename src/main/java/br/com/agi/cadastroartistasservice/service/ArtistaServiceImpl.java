package br.com.agi.cadastroartistasservice.service;

import br.com.agi.cadastroartistasservice.entidade.Artista;
import br.com.agi.cadastroartistasservice.exception.ArtistaNovoComIdException;
import br.com.agi.cadastroartistasservice.exception.ArtistaSemMusicaException;
import br.com.agi.cadastroartistasservice.exception.ArtistaSemPremiosException;
import br.com.agi.cadastroartistasservice.exception.CampoObrigatorioException;
import br.com.agi.cadastroartistasservice.repository.ArtistaRepository;
import org.springframework.stereotype.Service;

@Service
public class ArtistaServiceImpl implements ArtistaService {

    public final ArtistaRepository artistaRepository;

    public ArtistaServiceImpl(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }

    @Override
    public Artista cadastrarArtista(Artista artista) {
        this.validarSeIdExiste(artista.getId());
        this.validarCamposObrigatorios(artista);
        this.validarSeArtistaPossuiMusica(artista);
        this.validarSeArtistaPossuiPremios(artista);
        return artistaRepository.cadastrar(artista);

    }

    private void validarCamposObrigatorios(Artista artista) {
        if (artista.getNome() == null) {
            throw new CampoObrigatorioException("O Campo nome é obrigatório");
        }
    }

    private void validarSeIdExiste(String id) {
        if (id !=null) throw new ArtistaNovoComIdException();
    }

    private void validarSeArtistaPossuiMusica (Artista artista) {
        if (artista.getNomeMusica() == null) {
            throw new ArtistaSemMusicaException("O Artista ainda não possui músicas cadastradas");
        }

    }

    private void validarSeArtistaPossuiPremios (Artista artista) {
        if (!artista.getArtistaPossuiPremios()) {
            throw new ArtistaSemPremiosException("O Artista não possui premios em sua carreira");
        }
    }
}
