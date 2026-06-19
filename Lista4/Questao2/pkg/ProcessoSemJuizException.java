package pkg;

public class ProcessoSemJuizException extends Exception {
    public ProcessoSemJuizException() {
        super("ProcessoSemJuizException: Nao ha mais juizes com espaco disponivel para os processos restantes.");
    }
}