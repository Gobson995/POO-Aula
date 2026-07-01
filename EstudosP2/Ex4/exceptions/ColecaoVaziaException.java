package exceptions;

public class ColecaoVaziaException extends Exception {
    public ColecaoVaziaException() {
        super("Erro: A lista está vazia. Não é possível realizar a busca.");
    }
}
