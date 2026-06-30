package dados;

import exceptions.DispositivoOfflineException;

public class Lampada extends Dispositivo {
    private String cor;

    public Lampada(int id, String marca, String cor) {
        super(id, marca);
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public void acionar() throws DispositivoOfflineException {
        if  (!isConectado()) {{
            throw new DispositivoOfflineException();
        }}
        System.out.println("Lâmpada ACESA na cor " + cor + ".");
    }

    




}
