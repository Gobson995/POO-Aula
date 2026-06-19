package pkg;

public class PilhaVaziaException extends Exception {
    public PilhaVaziaException() {
        super("PilhaVaziaException: A pilha nao possui elementos.");
    }
}