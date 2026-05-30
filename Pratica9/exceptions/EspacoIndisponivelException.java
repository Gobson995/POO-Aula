package exceptions;

public class EspacoIndisponivelException extends Exception {
    public EspacoIndisponivelException() {
        super("Erro: Espaço indisponível ou condições inadequadas para alocar este animal no viveiro!");
    }
}