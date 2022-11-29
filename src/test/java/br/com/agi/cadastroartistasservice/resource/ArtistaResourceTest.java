package br.com.agi.cadastroartistasservice.resource;
import br.com.agi.cadastroartistasservice.entidade.Artista;
import br.com.agi.cadastroartistasservice.resource.dtos.ArtistaDto;
import br.com.agi.cadastroartistasservice.service.ArtistaService;
import br.com.agi.cadastroartistasservice.stub.ArtistaStub;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@DisplayName("Dado um recurso de artista que")
public class ArtistaResourceTest {

@Autowired
private MockMvc mockMvc;

@MockBean
    private ArtistaService artistaService;

@Test
@DisplayName("aoCadastrarNovoArtistaDeveRetornarSucesso")
    void cenarioArtistaCadastradoComSucesso() throws Exception{
    ArtistaDto artista = new ArtistaDto();
    artista.setNome("Kanye West");
    artista.setEstiloMusical("Rap/Hip-Hop");
    artista.setDataNascimento("08/06/1977");
    artista.setNomeAlbum("My Beautiful Dark Twisted Fantasy");
    artista.setNomeMusica("Runaway");
    artista.setArtistaPossuiPremios(true);

    ObjectMapper objectMapper = new ObjectMapper();
    String stringJson = objectMapper.writeValueAsString(artista);

    Artista artistaEsperado = ArtistaStub.obterArtistaKanyeWest();

    Mockito.when(artistaService.cadastrarArtista(any(Artista.class))).thenReturn(artistaEsperado);

    this.mockMvc.perform(post("/artistas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(stringJson))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.nome").value("Kanye West"))
            .andExpect(jsonPath("$.estiloMusical").value("Rap/Hip-Hop"))
            .andExpect(jsonPath("$.dataNascimento").value("08/06/1977"))
            .andExpect(jsonPath("$.dataNascimento").value("08/06/1977"))
            .andExpect(jsonPath("$.nomeAlbum").value("My Beautiful Dark Twisted Fantasy"))
            .andExpect(jsonPath("$.nomeMusica").value("Runaway"))
            .andExpect(jsonPath("$.artistaPossuiPremios").value(true));

    Mockito.verify(artistaService, Mockito.times(1)).cadastrarArtista(any(Artista.class));
}

    private Artista converterArtistaDtoParaArtistaEntidade (ArtistaDto artistaDto) throws ParseException {
        Artista artista = new Artista();

        artista.setId(artistaDto.getId());
        artista.setNome(artistaDto.getNome());
        artista.setEstiloMusical(artistaDto.getEstiloMusical());
        artista.setNomeAlbum(artistaDto.getNomeAlbum());
        artista.setNomeMusica(artistaDto.getNomeMusica());
        artista.setArtistaPossuiPremios(artistaDto.getArtistaPossuiPremios());


        DateTimeFormatter dataTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse(artistaDto.getDataNascimento(), dataTimeFormatter);

        artista.setDataNascimento(dataNascimento);
        return artista;
    }


}
