package br.com.agi.cadastroartistasservice.exception;

public class ArtistaSemPremiosException extends ArtistaException {

    public ArtistaSemPremiosException(String mensagem) {
        super (mensagem);
    }

    public ArtistaSemPremiosException() {
        super ("O Artista não possui nenhum prêmio na carreira");
    }
}
