package br.com.agi.cadastroartistasservice.resource;

import br.com.agi.cadastroartistasservice.entidade.Artista;
import br.com.agi.cadastroartistasservice.resource.dtos.ArtistaDto;
import br.com.agi.cadastroartistasservice.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/artistas")
public class ArtistaResource {

    @Autowired
    private ArtistaService artistaService;

    @PostMapping
    public ResponseEntity<ArtistaDto> cadastrar(@RequestBody ArtistaDto artistaDto) throws ParseException {
        Artista artistaEntidade = this.converterArtistaDtoParaArtistaEntidade(artistaDto);
        Artista artistaCadastradoRetornado = artistaService.cadastrarArtista(artistaEntidade);
        ArtistaDto artistaDtoCadastrado = this.converterArtistaEntidadeParaArtistaDto(artistaCadastradoRetornado);
        return new ResponseEntity<>(artistaDtoCadastrado, HttpStatus.CREATED);
    }

    private ArtistaDto converterArtistaEntidadeParaArtistaDto (Artista artista) {
        ArtistaDto artistaDto = new ArtistaDto();
        artistaDto.setId(artista.getId());
        artistaDto.setNome(artista.getNome());
        artistaDto.setEstiloMusical(artista.getEstiloMusical());
        artistaDto.setNomeAlbum(artista.getNomeAlbum());
        artistaDto.setNomeMusica(artista.getNomeMusica());
        artistaDto.setArtistaPossuiPremios(artista.getArtistaPossuiPremios());


        DateTimeFormatter dataTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataNascimentoEmString = artista.getDataNascimento().format(dataTimeFormatter);

        artistaDto.setDataNascimento(dataNascimentoEmString);

        return artistaDto;
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
