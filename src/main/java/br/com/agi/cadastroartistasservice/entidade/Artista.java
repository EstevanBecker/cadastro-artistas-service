package br.com.agi.cadastroartistasservice.entidade;

import java.time.LocalDate;
import java.util.Objects;

public class Artista {

    private String id;
    private String nome;
    private String estiloMusical;
    private String nomeAlbum;
    private String nomeMusica;

    private LocalDate dataNascimento;
    private Boolean artistaPossuiPremios;

    public Artista() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstiloMusical() {
        return estiloMusical;
    }

    public void setEstiloMusical(String estiloMusical) {
        this.estiloMusical = estiloMusical;
    }

    public String getNomeAlbum() {
        return nomeAlbum;
    }

    public void setNomeAlbum(String nomeAlbum) {
        this.nomeAlbum = nomeAlbum;
    }

    public String getNomeMusica() {
        return nomeMusica;
    }

    public void setNomeMusica(String nomeMusica) {
        this.nomeMusica = nomeMusica;
    }


    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Boolean getArtistaPossuiPremios() {
        return artistaPossuiPremios;
    }

    public void setArtistaPossuiPremios(Boolean artistaPossuiPremios) {
        this.artistaPossuiPremios = artistaPossuiPremios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artista artista = (Artista) o;
        return Objects.equals(id, artista.id) && Objects.equals(nome, artista.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    @Override
    public String toString() {
        return "Artista{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", estiloMusical='" + estiloMusical + '\'' +
                ", nomeAlbum='" + nomeAlbum + '\'' +
                ", nomeMusica='" + nomeMusica + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", artistaPossuiPremios=" + artistaPossuiPremios +
                '}';
    }
}
