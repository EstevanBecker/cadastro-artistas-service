package br.com.agi.cadastroartistasservice.exception;

public class CampoObrigatorioException  extends ArtistaException {
    public CampoObrigatorioException(String mensagem) {
        super (mensagem);
    }

    public CampoObrigatorioException() {
        super ("Um campo obrigatório não foi preenchido");
    }
}
