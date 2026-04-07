package negocio;
import dados.*;

public class ReservaPassagem {

    private Cidade[] cidades = new Cidade[100];
    private Cliente[] clientes = new Cliente[100];
    private int quantCidades = 0;
    private int quantClientes = 0;

    public int getQuantCidades() {
        return quantCidades;
    }

    public int getQuantClientes() {
        return quantClientes;
    }

    public void cadastrarCidade (Cidade cidade) {
        if (this.quantCidades < 100) {
            this.cidades[this.quantCidades] = cidade;
            this.quantCidades++;
        }
    }

    public void cadastrarCliente (Cliente cliente) {
        if (this.quantClientes < 100) {
            this.clientes[this.quantClientes] = cliente;
            this.quantClientes++;
        }
    }
    
    public void reservarIda (Cliente cliente, Reserva reserva) {
        cliente.reservarIda(reserva);
    }

    public void reservarVolta (Cliente cliente, Reserva ida, Reserva volta) {
        cliente.reservarVolta(ida, volta);
    }

    public Reserva[] mostrarReservas(String cpfCliente) {
        for (int i = 0; i < this.quantClientes; i++) {
            if (this.clientes[i].getCpf().equals(cpfCliente)) {
                return this.clientes[i].getReservas();
            }
        }

        return null;
    }

    public Cliente[] mostrarClientes() {
        return this.clientes;
    }

    public Cidade[] mostrarCidades() {
        return this.cidades;
    }
}
