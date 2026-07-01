package dados;

public class UsuarioPremium extends Usuario {
    private float desconto;

    public UsuarioPremium(String nome, String cpf, String endereco, float desconto) {
        super(nome, cpf, endereco);
        this.desconto = desconto;
    }

    @Override
    public void adicionarCompra(Compra c) {
        float valorDescontoTotal = 0;

        for (Produto p : c.getProdutos()) {
            if (p.getTipo() == TipoProduto.TENIS ||
                p.getTipo() == TipoProduto.BONE ||
                p.getTipo() == TipoProduto.MEIA) {
                
                valorDescontoTotal += p.getPreco() * (this.desconto / 100.0f);
            }
        }

        c.setValorTotal(c.getValorTotal() - valorDescontoTotal);

        super.adicionarCompra(c);
    }
}
