package exceptions;

public class VeiculoIndisponivelException extends Exception{
    public VeiculoIndisponivelException() {
        super("Erro: O veiculo nao esta disponivel");
    }
}
