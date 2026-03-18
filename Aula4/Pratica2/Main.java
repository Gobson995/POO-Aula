package Aula4.Pratica2;

public class Main {
   public static void main(String[] args) {
        // Criamos o nosso grupo
        Grupo meuGrupo = new Grupo();

        // 1. Instanciando as pessoas passando nome e idade direto no construtor
        Pessoa p1 = new Pessoa("Gustavo", 20);
        p1.setAltura(1.75);
        p1.setMassa(75.0);

        Pessoa p2 = new Pessoa("Alexia", 20);
        p2.setAltura(1.65);
        p2.setMassa(60.0);

        Pessoa p3 = new Pessoa("João", 19);
        p3.setAltura(1.70);
        p3.setMassa(70.0);

        Pessoa p4 = new Pessoa("Marcos", 21);
        p4.setAltura(1.80);
        p4.setMassa(85.0);

        Pessoa p5 = new Pessoa("Letícia", 20);
        p5.setAltura(1.68);
        p5.setMassa(68.0);

        // 2. Adicionando as pessoas ao grupo
        meuGrupo.setPessoa(p1);
        meuGrupo.setPessoa(p2);
        meuGrupo.setPessoa(p3);
        meuGrupo.setPessoa(p4);
        meuGrupo.setPessoa(p5);

        // 3. Ordenando o grupo do maior para o menor IMC
        meuGrupo.ordena();

        // 4. Exibindo os resultados
        System.out.println("--- Pessoas Ordenadas por IMC (Decrescente) ---");
        Pessoa[] listaOrdenada = meuGrupo.getPessoas();
        
        for (int i = 0; i < 5; i++) {
            System.out.printf("Nome: %s | IMC: %.2f\n", listaOrdenada[i].getNome(), listaOrdenada[i].calculaIMC());
        }
    } 
}
