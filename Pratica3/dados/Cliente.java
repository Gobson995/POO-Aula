package dados;

public class Cliente {
    private String cpf;
    private String nome;
    private String endereco;
    private String telefone;
    private Reserva[] reservas = new Reserva[100];
    private int quantReservas = 0; 

    public Cliente() {
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Reserva[] getReservas() {
        return reservas;
    }
    public int getQuantReservas() {
        return quantReservas;
    }

    public void reservarIda(Reserva reserva) {
        if (this.quantReservas < 100) {
            this.reservas[this.quantReservas] = reserva;
            this.quantReservas++;
        }
    }

    public void reservarVolta(Reserva ida, Reserva volta) {
        ida.cadastrarVolta(volta);

        if (this.quantReservas < 100) {
            this.reservas[this.quantReservas] = ida;
            this.quantReservas++;
        }
    }

    public String toString() {
        return "Cliente: " + nome + " | CPF: " + cpf + " | Telefone: " + telefone;
    }
}
