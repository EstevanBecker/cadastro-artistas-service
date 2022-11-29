package br.com.agi.cadastroartistasservice.entidade;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class ArtistaTest {
    @Test
    void verificarDadosInseridosArtista() {
        Artista artista = new Artista();
        artista.setNome("Kanye West");
        artista.setEstiloMusical("Rap/Hip-Hop");
        Album album = new Album();
        String nomeAlbum = album.setNome("My Beautiful Dark Twisted Fantasy");
        artista.setNomeAlbum(nomeAlbum);
        Musica musica = new Musica();
        musica.setNomeMusica("Runaway");
        artista.setNomeMusica(musica.getNomeMusica());
        musica.setTempoMusica("9:08");

        assertEquals("Kanye West",
                artista.getNome(),
                "O nome não corresponde ao esperado Kanye West");
    }
}
