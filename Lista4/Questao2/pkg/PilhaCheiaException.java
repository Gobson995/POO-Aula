package pkg;

public class PilhaCheiaException extends Exception {
    public PilhaCheiaException() {
        super("PilhaCheiaException: O limite da pilha foi atingido.");
    }
}