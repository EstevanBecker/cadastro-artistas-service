package br.com.agi.cadastroartistasservice.resource.dtos;

import java.util.Objects;

public class ArtistaDto {

    private String id;
    private String nome;
    private String estiloMusical;
    private String nomeAlbum;
    private String nomeMusica;

    private String dataNascimento;

    private Boolean artistaPossuiPremios;

    public ArtistaDto() {
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


    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
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
        ArtistaDto that = (ArtistaDto) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    @Override
    public String toString() {
        return "ArtistaDto{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", estiloMusical='" + estiloMusical + '\'' +
                ", nomeAlbum='" + nomeAlbum + '\'' +
                ", musicas='" + nomeMusica + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", artistaPossuiPremios=" + artistaPossuiPremios +
                '}';
    }
}
