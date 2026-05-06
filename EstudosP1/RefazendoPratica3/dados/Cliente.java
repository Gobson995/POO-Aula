package dados;

import java.util.List;
import java.util.ArrayList;

public class Cliente {
    private String cpf;
    private String nome;
    private String endereco;
    private String telefone;

    private List<Reserva> reservas = new ArrayList<>();

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

    public List<Reserva> getReservas() {
        return reservas;
    }
    public void setReservas(List<Reserva> reserva) {
        this.reservas = reserva;
    }

    public String toString() {
        String resp = "Nome: " + nome + " | CPF: " + cpf +
                      "\nEndereco/Telefone: " + endereco + " - " + telefone;
                      
        return resp;
    }

    public void reservarIda(Reserva reserva) {
        reservas.add(reserva);
    }

    public void reservarVolta(Reserva ida, Reserva volta) {
        ida.setVolta(volta);
        ida.setIdaEVolta(true);
        reservas.add(ida);
    }
}
