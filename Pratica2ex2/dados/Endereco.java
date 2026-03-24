package dados;

public class Endereco {
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private int numero;  

    public Endereco() {
    }

    public String getRua() {
        return this.rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public String toString() {
        String endereco = "";

        endereco += "Rua: " + this.rua;
        endereco += ", ";
        endereco += this.numero;
        endereco += " - Bairro: ";
        endereco += this.bairro;
        endereco += " - ";
        endereco += this.cidade;
        endereco += " - ";
        endereco += this.estado;
        endereco += " - CEP: ";
        endereco += this.cep;

        return endereco;
    }
}
