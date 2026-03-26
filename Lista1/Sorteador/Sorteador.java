import java.util.*;

public class Sorteador {
    private Pessoa[] pessoas = new Pessoa[10];
    private int nPessoas = 0;

    public Sorteador(){
    }

    public void adicionarPessoa(Pessoa p) {
        if (this.nPessoas < 10) {
            this.pessoas[this.nPessoas] = p;
            this.nPessoas++;
        }
    }

    public Pessoa sortear() {
        if (this.nPessoas == 0) {
            System.out.println("Não tem pessoas para sortear.\n");
            return null;
        }

        Random sorte = new Random();

        int indiceSorteado = sorte.nextInt(this.nPessoas);
        
        Pessoa vencedor = this.pessoas[indiceSorteado];

        for (int i = indiceSorteado; i < this.nPessoas - 1; i++) {
            this.pessoas[i] = this.pessoas[i + 1];
        }

        this.pessoas[this.nPessoas - 1] = null;
        this.nPessoas--;

        return vencedor;
    }

    public String toString() {
        String info = "Sorteio (Participantes: " + this.nPessoas + ")\n";
        
        if (this.nPessoas == 0) {
            info += "Não tem pessoas\n";
        } else {
            for (int i = 0; i < this.nPessoas; i++) {
                info += (i + 1) + ". " + this.pessoas[i].getNome() + " " + this.pessoas[i].getSobrenome() + "\n";
            }
        }
        return info;
    }

}
