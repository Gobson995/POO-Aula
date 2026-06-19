package pkg;

public class Main {
    public static void main(String[] args) {
        SistemaProcessos sistema = new SistemaProcessos();

        Juiz j1 = new Juiz(5, "Juiz 1");
        Juiz j2 = new Juiz(5, "Juiz 2");
        Juiz j3 = new Juiz(5, "Juiz 3");

        sistema.cadastrarJuiz(j1);
        sistema.cadastrarJuiz(j2);
        sistema.cadastrarJuiz(j3);

        for (int i = 1; i <= 18; i++) {
            sistema.cadastrarProcesso(new Processo(i, "Processo " + i));
        }

        try {
            sistema.distribuirProcessos();
        } catch (ProcessoSemJuizException e) {
            System.out.println(e.getMessage());
        }
    }
}