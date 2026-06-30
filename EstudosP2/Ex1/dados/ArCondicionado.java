package dados;

import exceptions.DispositivoOfflineException;

public class ArCondicionado extends Dispositivo {
    private float temperaturaAlvo;

    public ArCondicionado(int id, String marca, float temperaturaAlvo) {
        super(id, marca);
        this.temperaturaAlvo = temperaturaAlvo;
    }

    public float getTemperaturaAlvo() {
        return temperaturaAlvo;
    }
    public void setTemperaturaAlvo(float temperaturaAlvo) {
        this.temperaturaAlvo = temperaturaAlvo;
    }

    public void acionar() throws DispositivoOfflineException {
        if (!isConectado()) {
            throw new DispositivoOfflineException();
        }
        System.out.println("Ar condiciona na temperatura " + temperaturaAlvo + ".");
    }
}
