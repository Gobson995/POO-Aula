package exceptions;

public class ComodoNaoEncontradoException extends Exception {
    public ComodoNaoEncontradoException() {
        super("Erro: O comodo digitado nao existe!");
    }
}
