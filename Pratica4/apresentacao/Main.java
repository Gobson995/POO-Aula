package apresentacao;

import dados.*;
import negocio.Zoologico;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US); // tinha dado erro no float
        Zoologico zoo = new Zoologico();

        Animal animalAtual = null;

        while (true) {
            System.out.println("\nMENU DO ZOOLÓGICO");
            System.out.println("1 - Criar Viveiro");
            System.out.println("2 - Criar Aquario");
            System.out.println("3 - Criar Animal");
            System.out.println("4 - Criar Peixe");
            System.out.println("5 - Alocar Animal no Viveiro");
            System.out.println("6 - Alocar Peixe no Aquario");
            System.out.println("7 - Mostrar Relatorio Completo");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");
            
            int opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 0) break;

            switch (opcao) {
                case 1:
                    Viveiro v = new Viveiro();
                    System.out.print("Nome: "); 
                    v.setNome(sc.nextLine());
                    System.out.print("Comprimento: "); 
                    v.setComprimento(sc.nextFloat());
                    System.out.print("Largura: "); 
                    v.setLargura(sc.nextFloat());
                    zoo.cadastrarViveiro(v);
                    System.out.println("Viveiro criado.");
                    break;

                case 2:
                    Aquario aq = new Aquario();
                    System.out.print("Nome: "); 
                    aq.setNome(sc.nextLine());
                    System.out.print("Comprimento: "); 
                    aq.setComprimento(sc.nextFloat());
                    System.out.print("Largura: "); 
                    aq.setLargura(sc.nextFloat());
                    System.out.print("Altura: "); 
                    aq.setAltura(sc.nextFloat());
                    System.out.print("Temperatura da agua: "); 
                    aq.setTemperatura(sc.nextFloat());
                    zoo.cadastrarViveiro(aq);
                    System.out.println("Aquario criado.");
                    break;

                case 3:
                    Animal a = new Animal();
                    System.out.print("Nome: "); 
                    a.setNome(sc.nextLine());
                    System.out.print("Especie: "); 
                    a.setEspecie(sc.nextLine());
                    System.out.print("Cor: "); 
                    a.setCor(sc.nextLine());
                    System.out.print("Comprimento: "); 
                    a.setComprimento(sc.nextFloat());
                    System.out.print("Largura: "); 
                    a.setLargura(sc.nextFloat());
                    zoo.cadastrarAnimais(a);
                    animalAtual = a;
                    System.out.println("Animal criado.");
                    break;

                case 4:
                    Peixe p = new Peixe();
                    System.out.print("Nome: "); 
                    p.setNome(sc.nextLine());
                    System.out.print("Especie: "); 
                    p.setEspecie(sc.nextLine());
                    System.out.print("Cor: "); 
                    p.setCor(sc.nextLine());
                    System.out.print("Comprimento: "); 
                    p.setComprimento(sc.nextFloat());
                    System.out.print("Largura: "); 
                    p.setLargura(sc.nextFloat());
                    System.out.print("Altura: "); 
                    p.setAltura(sc.nextFloat());
                    System.out.print("Temperatura Ideal: "); 
                    p.setTemperaturaIdeal(sc.nextFloat());
                    zoo.cadastrarAnimais(p);
                    animalAtual = p;
                    System.out.println("Peixe criado.");
                    break;

                case 5:
                    if (animalAtual == null) { 
                        System.out.println("Crie um animal primeiro."); 
                        break; 
                    }
                    Viveiro[] listaV = zoo.getSoViveiros();
                    if (listaV.length == 0) { 
                        System.out.println("Sem viveiros terrestres."); 
                        break; 
                    }
                    
                    for (int i = 0; i < listaV.length; i++) {
                        System.out.println(i + " - " + listaV[i].getNome());
                    }

                    System.out.print("Numero do viveiro: ");
                    int numV = sc.nextInt(); sc.nextLine();
                    if (numV >= 0 && numV < listaV.length) {
                        if (zoo.alocarAnimal(animalAtual, listaV[numV])) {
                            System.out.println("Alocado com sucesso!");
                            animalAtual = null;
                        } else {
                            System.out.println("Falhou! Espaço livre nao e maior que 70% da area do animal.");
                        }
                    }
                    break;

                case 6:
                    if (animalAtual == null) { 
                        System.out.println("Crie um peixe primeiro."); 
                        break; 
                    }
                    Aquario[] listaAq = zoo.getSoAquarios();
                    if (listaAq.length == 0) { 
                        System.out.println("Sem aquarios."); 
                        break; 
                    }
                    
                    for (int i = 0; i < listaAq.length; i++) {
                        System.out.println(i + " - " + listaAq[i].getNome() + " (Temp: " + listaAq[i].getTemperatura() + "C)");
                    }
                    System.out.print("Numero do aquario: ");

                    int numAq = sc.nextInt(); sc.nextLine();
                    if (numAq >= 0 && numAq < listaAq.length) {
                        if (zoo.alocarAnimal(animalAtual, listaAq[numAq])) {
                            System.out.println("Alocado com sucesso! (Temp e Espaco aprovados)");
                            animalAtual = null;
                        } else {
                            System.out.println("Falhou! Pode nao ser peixe, sem espaco(70%) ou diferenca de temp. > 3 graus.");
                        }
                    }
                    break;

                case 7:
                    System.out.println("\nRELATORIO DE VIVEIROS");
                    List<Viveiro> todos = zoo.getTodosViveiros();
                    if (todos.isEmpty()) {
                        System.out.println("Nenhum viveiro ou aquario cadastrado no Zoologico.");
                    } else {
                        for (Viveiro viv : todos) {
                            System.out.println("\n[" + (viv instanceof Aquario ? "Aquario" : "Viveiro") + "] " + viv.getNome());
                            
                            if (viv.getAnimais().isEmpty()) {
                                System.out.println("   -> viveiro vazio");
                            } else {
                                for (Animal anim : viv.getAnimais()) {
                                    System.out.print("   -> Nome: " + anim.getNome() + " | Cor: " + anim.getCor() + " | Especie: " + anim.getEspecie());
                                    if (anim instanceof Peixe) {
                                        System.out.print(" | Temp. Ideal: " + ((Peixe) anim).getTemperaturaIdeal() + "C");
                                    }
                                    System.out.println();
                                }
                            }
                        }
                    }
                    break;

                default:
                    System.out.println("Opcao invalida.");
            }
        }
        sc.close();
    }
}