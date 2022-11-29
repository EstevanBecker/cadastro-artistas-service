package br.com.agi.cadastroartistasservice.exception;

public class ArtistaSemMusicaException extends ArtistaException{
    public ArtistaSemMusicaException (String mensagem) {
        super (mensagem);
    }

    public ArtistaSemMusicaException() {
        super ("O Artista não possui músicas cadastradas");
    }
}
