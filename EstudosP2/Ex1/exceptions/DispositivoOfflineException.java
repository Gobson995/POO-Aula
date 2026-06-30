package exceptions;

public class DispositivoOfflineException extends Exception{
    public DispositivoOfflineException() {
        super("Erro: O dispositivo está offline e não pode ser acionado!");
    }
}
