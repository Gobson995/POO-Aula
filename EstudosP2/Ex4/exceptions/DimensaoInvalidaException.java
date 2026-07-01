package exceptions;

public class DimensaoInvalidaException extends Exception{
    public DimensaoInvalidaException() {
        super("Erro: As dimensões (raio, base, altura) devem ser maiores que zero.");
    }
}
