package pkg;

public class Main {
    public static void main(String[] args) {
        SistemaArquivos sistema = new SistemaArquivos();

        try {
            sistema.criarMusica("Imagine Dragons Radioactive", "Downloads", 276);
            sistema.criarVideo("HIMYM S01E01", "Downloads", Qualidade.Q1024p);
            sistema.criarDocumento("Lista de compras", "Downloads", "Pao, leite, ovos");
            sistema.criarDocumento("resumo.txt", "Area de Trabalho", "Resumo de POO");
            sistema.criarDocumento("notas POO.txt", "Area de Trabalho", "10, 10, 10");

            sistema.criarDocumento("curto", "Downloads", "Vai dar erro");
        } catch (NomeInvalidoException e) {
            System.out.println("ERRO DETECTADO: " + e.getMessage() + "\n");
        }

        System.out.println(sistema.toString());
    }
}