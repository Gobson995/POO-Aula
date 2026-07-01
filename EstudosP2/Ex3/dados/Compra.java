package dados;

import java.util.ArrayList;
import java.util.List;

public class Compra {
    private String data;
    private float valorTotal;
    private int qntProdutos;
    private String formaPagamento;
    private boolean pago;
    private List<Produto> produtos = new ArrayList<>();

    public Compra (String data, String formaPagamento) {
        this.data = data;
        this.valorTotal = 0;
        this.qntProdutos = 0;
        this.formaPagamento = formaPagamento;
        this.pago = false;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    public float getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getQntProdutos() {
        return qntProdutos;
    }
    public void setQntProdutos(int qntProdutos) {
        this.qntProdutos = qntProdutos;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }
    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public boolean isPago() {
        return pago;
    }
    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void adicionarProduto(Produto p) {
        produtos.add(p);
        this.valorTotal += p.getPreco();
        this.qntProdutos++;
    }

    public void removerProduto(Produto p) {
        if (produtos.remove(p)) {
            this.valorTotal -= p.getPreco();
            this.qntProdutos--;
        }
    }

    public void pagar() {
        this.pago = true;
    }

    public boolean estaPago() {
        return pago;
    }

    @Override
    public String toString() {
        return "Compra [data=" + data + ", valorTotal=" + valorTotal + ", qntProdutos=" + qntProdutos
                + ", formaPagamento=" + formaPagamento + "]";
    }
}
