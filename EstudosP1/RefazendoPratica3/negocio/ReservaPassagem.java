package negocio;

import dados.*;

import java.util.List;
import java.util.ArrayList;

public class ReservaPassagem {
    private List<Cidade> listaDeCidades = new ArrayList<>();
    private List<Cliente> listaDeClientes = new ArrayList<>();

    public ReservaPassagem() {
    }

    public void cadastrarCidade(Cidade cidade) {
        listaDeCidades.add(cidade);
    }

    public void cadastrarCliente(Cliente cliente) {
        listaDeClientes.add(cliente);
    }

    public void reservarIda(Cliente cliente, Reserva reserva) {
       cliente.reservarIda(reserva); 
    }

    public void reservarVolta(Cliente cliente, Reserva ida, Reserva volta) {
        cliente.reservarVolta(ida, volta);
    }

    public Reserva[] mostrarReservas(String cpfCliente) {
        for (Cliente c : listaDeClientes) {
            if (c.getCpf().equals(cpfCliente)) {
                return c.getReservas().toArray(new Reserva[0]);
            }
        }
        return null;
    }

    public Cliente[] mostrarClientes() {
        return listaDeClientes.toArray(new Cliente[0]);
    }

    public Cidade[] mostrarCidades() {
        return listaDeCidades.toArray(new Cidade[0]);
    }
}
