package br.com.agi.cadastroartistasservice.entidade;

import java.util.List;

public class Album {
    String nome;
    String estiloMusicalAlbum;
    String duracaoAlbum;
    List<Musica> musicasAlbum;


    public Album() {

    }

    public String getNome() {
        return nome;
    }

    public String setNome(String nome) {
        this.nome = nome;
        return nome;
    }

    public String getEstiloMusicalAlbum() {
        return estiloMusicalAlbum;
    }

    public void setEstiloMusicalAlbum(String estiloMusicalAlbum) {
        this.estiloMusicalAlbum = estiloMusicalAlbum;
    }

    public String getDuracaoAlbum() {
        return duracaoAlbum;
    }

    public void setDuracaoAlbum(String duracaoAlbum) {
        this.duracaoAlbum = duracaoAlbum;
    }

    public List<Musica> getMusicasAlbum() {
        return musicasAlbum;
    }

    public void setMusicasAlbum(List<Musica> musicasAlbum) {
        this.musicasAlbum = musicasAlbum;
    }

    @Override
    public String toString() {
        return "Album{" +
                "nome='" + nome + '\'' +
                ", musicasAlbum=" + musicasAlbum +
                '}';
    }
}
