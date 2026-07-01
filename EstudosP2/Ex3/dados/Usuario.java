package dados;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String cpf;
    private String endereco;
    private List<Compra> compras = new ArrayList<>();

    public Usuario (String nome, String cpf, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void adicionarCompra(Compra c) {
        compras.add(c);
    }

    public List<Compra> getComprasNaoPagas() {
        List<Compra> naoPagas = new ArrayList<>();
        for (Compra c : compras) {
            if (!c.estaPago()) {
                naoPagas.add(c);
            }
        }
        return naoPagas;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    @Override
    public String toString() {
        return "Usuario [nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco + "]";
    }
}
