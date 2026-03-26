public class Imobiliaria {
    private String nome;
    private Imovel[] imoveis = new Imovel[50];
    private int quantidadeImoveis = 0;

    public Imobiliaria() {
    }

    public Imobiliaria(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Imovel[] getImoveis() {
        return imoveis;
    }

    public int getQuantidadeImoveis() {
        return quantidadeImoveis;
    }

    public void adicionarImovel(Imovel imovel) {
        if (this.quantidadeImoveis < 50) {
            this.imoveis[this.quantidadeImoveis] = imovel;
            this.quantidadeImoveis++;
        }
    }

    public String toString() {
        String info = "Nome imobiliaria: " + this.nome + "\n";

        if (this.quantidadeImoveis == 0) {
            info += "Não tem nenhum imovel cadastrado.\n";
        }
        else {
            for (int i = 0; i < quantidadeImoveis; i++) {
                info += "Imovel " + (i+1) + "\n";
                info += this.imoveis[i].toString() + "\n\n";
            }
        }

        return info;
    }

    public Imovel[] filtrarPorArea (float x) {
        int contador = 0;
        for (int i = 0; i < getQuantidadeImoveis(); i++) {
            if (this.imoveis[i].area() >= x) {
                contador++;
            }
        }

        Imovel[] imoveisFiltrados = new Imovel[contador];
        int pos = 0;
        for (int i = 0; i < getQuantidadeImoveis(); i++) {
            if (this.imoveis[i].area() >= x) {
                imoveisFiltrados[pos] = this.imoveis[i];
                pos++;
            }
        }

        for (int i = 0; i < contador - 1; i++) {
            for (int j = 0; j < contador - i - 1; j++) {
                if (imoveisFiltrados[j].getPreco() > imoveisFiltrados[j+1].getPreco()) {
                    Imovel temp = imoveisFiltrados[j];
                    imoveisFiltrados[j] = imoveisFiltrados[j+1];
                    imoveisFiltrados[j+1] = temp;
                }
            }
        }

        return imoveisFiltrados;
    }
}
