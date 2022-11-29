package br.com.agi.cadastroartistasservice.entidade;

public class Musica {
    String nomeMusica;
    String tempoMusica;

    public Musica() {

    }
    public String getNomeMusica() {
        return nomeMusica;
    }

    public void setNomeMusica(String nomeMusica) {
        this.nomeMusica = nomeMusica;
    }

    public String getTempoMusica() {
        return tempoMusica;
    }

    public void setTempoMusica(String tempoMusica) {
        this.tempoMusica = tempoMusica;
    }
}
