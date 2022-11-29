package br.com.agi.cadastroartistasservice.stub;

import br.com.agi.cadastroartistasservice.entidade.Artista;

import java.time.LocalDate;

public class ArtistaStub {

    public static Artista obterArtistaComPremiosEhNull() {
        Artista artista = new Artista();
        artista.setNome("Kanye West");
        artista.setEstiloMusical("Rap/Hip-Hop");
        artista.setNomeAlbum("My Beautiful Dark Twisted Fantasy");
        artista.setNomeMusica("Runaway");
        artista.setArtistaPossuiPremios(null);

        LocalDate dataNascimento = LocalDate.of(1977,6,8);
        artista.setDataNascimento(dataNascimento);

        return artista;
    }

    public static Artista obterArtistaKanyeWest() {
        Artista artista = new Artista();
        artista.setNome("Kanye West");
        artista.setEstiloMusical("Rap/Hip-Hop");
        artista.setNomeAlbum("My Beautiful Dark Twisted Fantasy");
        artista.setNomeMusica("Runaway");
        artista.setArtistaPossuiPremios(true);

        LocalDate dataNascimento = LocalDate.of(1977, 6, 8);
        artista.setDataNascimento(dataNascimento);


        return artista;
    }
}
