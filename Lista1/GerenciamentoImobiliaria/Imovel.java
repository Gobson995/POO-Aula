public class Imovel {
    private float largura;
    private float comprimento;
    private float preco;

    public Imovel() {
    }

    public Imovel (float largura, float comprimento, float preco) {
        this.largura = largura;
        this.comprimento = comprimento;
        this.preco = preco;
    }

    public float getLargura() {
        return largura;
    }
    public void setLargura(float largura) {
        this.largura = largura;
    }

    public float getComprimento() {
        return comprimento;
    }
    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float area() {
        return this.comprimento * this.largura;
    }

    public String toString() {
        return "Largura: " + this.largura + "m" +
               "\nComprimento: " + this.comprimento + "m" +
               "\nArea Total:" + this.area() + "m2" +
               "\npreco: R$" + this.preco + "\n";
    }
}
