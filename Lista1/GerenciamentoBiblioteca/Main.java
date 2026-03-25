public class Main {
    public static void main (String[] args) {

        System.out.println("=== TESTANDO A CLASSE LIVRO ===");

        Livro livro1 = new Livro(8383, "Nexus", 405, "Historia");
        Livro livro2 = new Livro();

        livro2.setId(6000);
        livro2.setTitulo("Três Porquinhos");
        livro2.setPaginas(34);
        livro2.setGenero("Infantil");

        livro1.setGenero("Computação");

        System.out.println(livro1);
        System.out.println(livro2);
        System.out.println("O livro mais lido entre os dois foi: " + livro2.getTitulo() + ". E ele tem " + livro2.getPaginas() + " paginas.\n");


        System.out.println("=== TESTANDO A CLASSE SECAO ===");

        Secao s1 = new Secao("Infantil", 1);
        Secao s2 = new Secao();

        s1.adicionarLivro(livro2);

        s2.setCorredor(18);
        s2.setCategoria("Internacional");
        s2.adicionarLivro(livro1);

        System.out.println(s1);
        System.out.println(s2 + "\n");


        System.out.println("=== TESTANDO A CLASSE BIBLIOTECARIO ===");
        

        Bibliotecario b1 = new Bibliotecario("Roberto", "Almeida", 3500.50f);
        Bibliotecario b2 = new Bibliotecario();

        b2.setNome("Carla");
        b2.setSobrenome("Mendes");
        b2.setSalario(4200.00f);

        s1.setResponsavel(b1);
        s2.setResponsavel(b2);

        System.out.println(b1);
        System.out.println(b2);
        System.out.println("O salario da " + b2.getNome() + " e de R$" + b2.getSalario() + "\n");


        System.out.println("=== TESTANDO A CLASSE LEITOR ===");
        
        Leitor leitor1 = new Leitor("Lucas", "Ferreira");
    
        Leitor leitor2 = new Leitor();
        leitor2.setNome("Mariana");
        leitor2.setSobrenome("Costa");

        System.out.println(leitor1);
        System.out.println(leitor2);
        System.out.println("A leitora cadastrada chama-se " + leitor2.getNome() + " " + leitor2.getSobrenome() + ".\n");


        System.out.println("=== TESTANDO A CLASSE EMPRESTIMO ===");
        
        Emprestimo emp1 = new Emprestimo("25/03/2026", "10/04/2026", livro1, leitor1);
        
        Emprestimo emp2 = new Emprestimo();
        emp2.setDataInicio("26/03/2026");
        emp2.setDataTermino("11/04/2026");
        emp2.setLivroAlugado(livro2);
        emp2.setLeitor(leitor2);
        emp2.setDevolvido(true);

        leitor1.adicionarEmprestimo(emp1);
        leitor2.adicionarEmprestimo(emp2);

        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println("O livro do primeiro emprestimo e o: " + emp1.getLivroAlugado().getTitulo());
    }
}