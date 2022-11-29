package br.com.agi.cadastroartistasservice.exception;

public class ArtistaNovoComIdException extends ArtistaException {

    public ArtistaNovoComIdException(String mensagem) {
        super(mensagem);
    }

    public ArtistaNovoComIdException() {
        super ("Artista não pode ser cadastrado com ID, pois o próprio sistema as gera automaticamente");
    }
}
