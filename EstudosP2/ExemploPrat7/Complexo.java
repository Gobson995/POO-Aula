import java.util.Random;

public class Complexo {
    private int real;
    private int imaginaria;

    public Complexo(int real, int imaginaria) {
        this.real = real;
        this.imaginaria = imaginaria;
    }

    public Complexo() {
        Random r = new Random();
        real = r.nextInt(100);
        imaginaria = r.nextInt(100);
    }

    public int getReal() {
        return real;
    }
    public void setReal(int real) {
        this.real = real;
    }

    public int getImaginaria() {
        return imaginaria;
    }
    public void setImaginaria(int imaginaria) {
        this.imaginaria = imaginaria;
    }

    @Override
    public String toString() {
        return "Complexo [real=" + real + ", imaginaria=" + imaginaria + "]";
    }
}
