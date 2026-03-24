package apresentacao;

import java.util.*;

import dados.Animal;
import dados.Dono;
import dados.Endereco;
import dados.Veterinario;

public class SistemaPetShop {
    private static Veterinario[] veterinarios = new Veterinario[50];
    private static int numeroVeterinarios = 0;
    
    private static Scanner leitor = new Scanner(System.in);

    public static void imprimeMenu() {
        System.out.println("\n--- SISTEMA PET SHOP ---");
        System.out.println("Escolha uma opção :");
        System.out.println("0-Sair");
        System.out.println("1-Cadastrar Veterinario");
        System.out.println("2-Exibir Veterinarios");
        System.out.println("3-Cadastrar Endereco do Veterinario");
        System.out.println("4-Cadastrar Animal");
        System.out.println("5-Exibir Animais");
        System.out.println("6-Cadastrar Dono");
        System.out.println("7-Cadastrar Endereco do Dono");
    }

    public static void main (String[] args) {
        int opcao = -1;

        while(opcao != 0) {
            imprimeMenu();
            opcao = leitor.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                case 1:
                    cadastrarVeterinario();
                    break;
                case 2:
                    mostrarVeterinarios();
                    break;
                case 3:
                    cadastrarEnderecoVeterinario();
                    break;
                case 4:
                    cadastrarAnimal();
                    break;
                case 5:
                    mostrarAnimais();
                    break;
                case 6:
                    cadastrarDono();
                    break;
                case 7:
                    cadastrarEnderecoDono();
                    break;
                default:
                    System.out.println("Valor incorreto!");
                    break;
            }
        }
    }

    public static void cadastrarVeterinario() {
        if (numeroVeterinarios < 50) {
            Veterinario v = new Veterinario();

            System.out.println("Escreva o nome do veterinario: ");
            String nome = leitor.nextLine();
            nome = leitor.nextLine();
            v.setNome(nome);

            System.out.println("Escreva o salario do veterinario: ");
            float salario = leitor.nextFloat();
            v.setSalario(salario);

            veterinarios[numeroVeterinarios] = v;
            numeroVeterinarios++;
            System.out.println("Veterinario cadastrado com sucesso!");
        } else {
            System.out.println("Limite de veterinarios atingido.");
        }
    }

    public static void mostrarVeterinarios() {
        if (numeroVeterinarios == 0) {
            System.out.println("Nenhum veterinario cadastrado.");
            return;
        }
        for (int i = 0; i < numeroVeterinarios; i++) {
            System.out.println("Codigo: " + i);
            System.out.println(veterinarios[i].toString());
        }
    }

    public static void cadastrarEnderecoVeterinario() {
        if (numeroVeterinarios == 0) {
            System.out.println("Voce nao tem nenhum veterinario cadastrado.");
        } else {
            System.out.println("Escolha o veterinario que voce quer cadastrar endereco: ");
            mostrarVeterinarios();

            int posicao = leitor.nextInt();
            if(posicao > (numeroVeterinarios - 1) || posicao < 0) {
                System.out.println("Voce escolheu uma posicao invalida.");
            } else {
               Veterinario vet = veterinarios[posicao];
               vet.setEndereco(cadastrarEndereco()); 
               System.out.println("Endereco do veterinario cadastrado com sucesso!");
            }
        }
    }

    public static Endereco cadastrarEndereco() {
        Endereco e = new Endereco();

        System.out.println("Digite o nome da rua:");
        String rua = leitor.nextLine();
        rua = leitor.nextLine();
        e.setRua(rua);

        System.out.println("Digite o numero da casa:");
        e.setNumero(leitor.nextInt());

        System.out.println("Digite o nome do bairro:");
        String bairro = leitor.nextLine();
        bairro = leitor.nextLine();
        e.setBairro(bairro);
        
        System.out.println("Digite o nome da cidade:");
        String cidade = leitor.nextLine();
        e.setCidade(cidade);

        System.out.println("Digite o nome do estado:");
        String estado = leitor.nextLine();
        e.setEstado(estado);

        System.out.println("Digite o numero do cep:");
        String cep = leitor.nextLine();
        e.setCep(cep);
        
        return e;
    }

    public static void cadastrarAnimal() {
        if (numeroVeterinarios == 0) {
            System.out.println("Voce nao tem nenhum veterinario cadastrado.");
        } else {
            System.out.println("Escolha o veterinario que voce quer cadastrar um animal: ");
            mostrarVeterinarios();

            int posicao = leitor.nextInt();
            if(posicao > (numeroVeterinarios - 1) || posicao < 0) {
                System.out.println("Voce escolheu uma posicao invalida.");
            } else {
               Veterinario vet = veterinarios[posicao];
               vet.setAnimais(cadastrandoAnimal());
               System.out.println("Animal cadastrado com sucesso!");
            }
        }
    }

    public static Animal cadastrandoAnimal() {
        Animal a = new Animal();
    
        System.out.println("Digite o nome do animal :");
        String nome = leitor.nextLine();
        nome = leitor.nextLine();
        a.setNome(nome);

        System.out.println("Digite a especie do animal :");
        String especie = leitor.nextLine();
        a.setEspecie(especie);

        System.out.println("Digite a descricao do animal :");
        String descricao = leitor.nextLine();
        a.setDescricao(descricao);

        return a;
    }

    public static void mostrarAnimais() {
        if (numeroVeterinarios == 0) {
            System.out.println("Voce nao tem nenhum veterinario cadastrado.");
        } else {
            System.out.println("Escolha o veterinario que voce quer mostrar seus animais: ");
            mostrarVeterinarios();

            int posicao = leitor.nextInt();
            if(posicao > (numeroVeterinarios - 1) || posicao < 0) {
                System.out.println("Voce escolheu uma posicao invalida.");
            } else {
                Veterinario vet = veterinarios[posicao];

                if (vet.getQuantidadeAnimais() == 0) {
                    System.out.println("Esse veterinario nao tem nenhum animal cadastrado.");
                } else {
                    for (int i = 0; i < vet.getQuantidadeAnimais(); i++) {
                        System.out.println("Animal Atendido " + i);
                        System.out.println(vet.getAnimais()[i].toString());
                    }
                }   
            }
        }
    }

    public static void cadastrarDono() {
        if (numeroVeterinarios == 0) {
            System.out.println("Voce nao tem nenhum veterinario cadastrado.");
            return;
        }

        System.out.println("Escolha o veterinario para listar os animais: ");
        mostrarVeterinarios();
        int posicaoVet = leitor.nextInt();

        if(posicaoVet > (numeroVeterinarios - 1) || posicaoVet < 0) {
            System.out.println("Voce escolheu uma posicao invalida.");
            return;
        }

        Veterinario vet = veterinarios[posicaoVet];

        if (vet.getQuantidadeAnimais() == 0) {
            System.out.println("Esse veterinario nao tem nenhum animal cadastrado para receber um dono.");
            return;
        }

        System.out.println("Escolha o animal que recebera um dono:");
        for (int i = 0; i < vet.getQuantidadeAnimais(); i++) {
            System.out.println(i + " - " + vet.getAnimais()[i].getNome());
        }

        int posicaoAnimal = leitor.nextInt();
        if(posicaoAnimal > (vet.getQuantidadeAnimais() - 1) || posicaoAnimal < 0) {
            System.out.println("Voce escolheu uma posicao de animal invalida.");
            return;
        }

        Animal animalEscolhido = vet.getAnimais()[posicaoAnimal];
        animalEscolhido.setDono(cadastrandoDono());
        System.out.println("Dono cadastrado com sucesso!");
    }

    public static Dono cadastrandoDono() {
        Dono d = new Dono();
    
        System.out.println("Digite o nome do dono :");
        String nome = leitor.nextLine();
        nome = leitor.nextLine();
        d.setNome(nome);

        System.out.println("Digite o CPF do dono :");
        String cpf = leitor.nextLine();
        d.setCpf(cpf);

        return d;
    }

    public static void cadastrarEnderecoDono() {
        if (numeroVeterinarios == 0) {
            System.out.println("Voce nao tem nenhum veterinario cadastrado.");
            return;
        }

        System.out.println("Escolha o veterinario para buscar o animal: ");
        mostrarVeterinarios();
        int posicaoVet = leitor.nextInt();

        if(posicaoVet > (numeroVeterinarios - 1) || posicaoVet < 0) {
            System.out.println("Voce escolheu uma posicao invalida.");
            return;
        }

        Veterinario vet = veterinarios[posicaoVet];

        if (vet.getQuantidadeAnimais() == 0) {
            System.out.println("Esse veterinario nao tem nenhum animal cadastrado.");
            return;
        }

        System.out.println("Escolha o animal para cadastrar o endereco do dono:");
        for (int i = 0; i < vet.getQuantidadeAnimais(); i++) {
            System.out.println(i + " - " + vet.getAnimais()[i].getNome());
        }

        int posicaoAnimal = leitor.nextInt();
        if(posicaoAnimal > (vet.getQuantidadeAnimais() - 1) || posicaoAnimal < 0) {
            System.out.println("Voce escolheu uma posicao de animal invalida.");
            return;
        }

        Animal animalEscolhido = vet.getAnimais()[posicaoAnimal];
        Dono donoDoAnimal = animalEscolhido.getDono();

        if (donoDoAnimal == null) {
            System.out.println("Este animal ainda nao possui um dono! Cadastre o dono primeiro (Opcao 6).");
            return;
        }

        System.out.println("\nDono Encontrado");
        System.out.println("Nome: " + donoDoAnimal.getNome());
        System.out.println("CPF: " + donoDoAnimal.getCpf());
        
        System.out.println("\nCadastrando Novo Endereco");
        donoDoAnimal.setEndereco(cadastrarEndereco());
        System.out.println("Endereco do dono cadastrado com sucesso!");
    }
}