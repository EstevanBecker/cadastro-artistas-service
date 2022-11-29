package br.com.agi.cadastroartistasservice.service;

import br.com.agi.cadastroartistasservice.entidade.Artista;
import br.com.agi.cadastroartistasservice.exception.ArtistaNovoComIdException;
import br.com.agi.cadastroartistasservice.exception.ArtistaSemMusicaException;
import br.com.agi.cadastroartistasservice.exception.ArtistaSemPremiosException;
import br.com.agi.cadastroartistasservice.exception.CampoObrigatorioException;
import br.com.agi.cadastroartistasservice.repository.ArtistaRepository;
import br.com.agi.cadastroartistasservice.repository.ArtistaRepositoryImpl;
import br.com.agi.cadastroartistasservice.stub.ArtistaStub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

public class ArtistaServiceImplTeste {

    ArtistaRepository artistaRepositoryMock;
    ArtistaServiceImpl artistaServiceImpl;

    @BeforeEach
    void inicializar(){
        artistaRepositoryMock = Mockito.mock(ArtistaRepository.class);
        artistaServiceImpl = new ArtistaServiceImpl(artistaRepositoryMock);
    }

    @Test
    public void cenarioCadastradoComSucesso() {
        Artista artista = ArtistaStub.obterArtistaComPremiosEhNull();
        Artista artistaRetornadoPeloRepository = ArtistaStub.obterArtistaKanyeWest();

        Mockito.when(artistaRepositoryMock.cadastrar(any(Artista.class))).thenReturn(artistaRetornadoPeloRepository);
        Artista artistaRetornado = this.artistaServiceImpl.cadastrarArtista(artista);

        Assertions.assertAll("Deveria retornar cliente esperado",
                () -> assertEquals(artistaRetornadoPeloRepository.getNome(), artistaRetornado.getNome(), "O nome não corresponde ao esperado."),
                () -> assertEquals(artistaRetornadoPeloRepository.getEstiloMusical(), artistaRetornado.getEstiloMusical(), "O estilo musical não corresponde ao esperado."),
                () -> assertEquals(artistaRetornadoPeloRepository.getNomeAlbum(), artistaRetornado.getNomeAlbum(), "O nome do album não corresponde ao esperado."),
                () -> assertEquals(artistaRetornadoPeloRepository.getId(), artistaRetornado.getId(), "O id não corresponde ao esperado."),
                () -> assertEquals(artistaRetornadoPeloRepository.getArtistaPossuiPremios(), artistaRetornado.getArtistaPossuiPremios(), "A flag possui premios não corresponde com o esperado."),
                () -> assertEquals(artistaRetornadoPeloRepository.getDataNascimento(), artistaRetornado.getDataNascimento(), "A data de nascimento não corresponde com o esperado."),
                () -> assertEquals(artistaRetornadoPeloRepository.getNomeMusica(), artistaRetornado.getNomeMusica(), "A Musica não corresponde ao esperado")
        );

        Mockito.verify(artistaRepositoryMock, Mockito.times(1)).cadastrar(any(Artista.class));

    }

    @Test
    public void cenarioArtistaSendoCadastradoComIdExistente() {
        Artista artista = new Artista();
        artista.setId("0001");

        ArtistaNovoComIdException excecao = Assertions.assertThrows(ArtistaNovoComIdException.class,
                () -> this.artistaServiceImpl.cadastrarArtista(artista)
        );

        assertEquals("Artista não pode ser cadastrado com ID, pois o próprio sistema as gera automaticamente", excecao.getMessage());
    }

    @Test
    public void cenarioComCampoObrigatorioNaoPreenchido() {
        Artista artista = new Artista();

        CampoObrigatorioException excecao = Assertions.assertThrows(CampoObrigatorioException.class,
                () -> this.artistaServiceImpl.cadastrarArtista(artista)
        );
        assertEquals("O Campo nome é obrigatório", excecao.getMessage());
    }

    @Test
    public void cenarioArtistaSemMusica() {
        Artista artista = new Artista();
        artista.setNome("Kanye West");
        artista.setNomeMusica(null);

        ArtistaSemMusicaException excecao = Assertions.assertThrows(ArtistaSemMusicaException.class,
                () -> this.artistaServiceImpl.cadastrarArtista(artista)
        );
        assertEquals("O Artista ainda não possui músicas cadastradas", excecao.getMessage());
    }
    @Test
    public void cenarioArtistaPossuiPremiosFalse() {
        Artista artista = new Artista();
        artista.setNome("Lana del rey");
        artista.setNomeMusica("Ultraviolence");
        artista.setArtistaPossuiPremios(false);

        ArtistaSemPremiosException excecao = Assertions.assertThrows(ArtistaSemPremiosException.class,
                () -> this.artistaServiceImpl.cadastrarArtista(artista)
        );
        assertEquals("O Artista não possui premios em sua carreira", excecao.getMessage());
    }

    @Test
    public void cenarioArtistaComAlbumNomeDiferente() {

    }
}
