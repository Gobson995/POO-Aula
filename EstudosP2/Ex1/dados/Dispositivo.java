package dados;

public abstract class Dispositivo implements IConectavel {
    private int id;
    private String marca;
    private boolean statusConexao;

    public Dispositivo(int id, String marca) {
        this.id = id;
        this.marca = marca;
        this.statusConexao = false;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    @Override
    public void conectar() {
        this.statusConexao = true;
    }

    @Override
    public void desconectar() {
        this.statusConexao = false;
    }

    @Override
    public boolean isConectado() {
        return this.statusConexao;
    }

    public abstract void acionar() throws exceptions.DispositivoOfflineException;

    @Override
    public String toString() {
        return "Dispositivo [id=" + id + ", marca=" + marca + "]";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dispositivo other = (Dispositivo) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
