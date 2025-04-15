package br.com.alura.screenmatch.excecao;

public class ExceptionAnoLancamento extends RuntimeException {
    private String messagem;
    public ExceptionAnoLancamento(String messagem) {
        this.messagem = messagem;
    }

    @Override
    public String getMessage() {
        return this.messagem;
    }
}
