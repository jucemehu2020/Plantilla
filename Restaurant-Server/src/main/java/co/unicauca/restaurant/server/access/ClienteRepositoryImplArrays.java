package co.unicauca.restaurant.server.access;

import co.unicauca.domicilios.domain.Cliente;
import java.util.ArrayList;
import java.util.List;


/**
 * Implementacion de IClienteRepository. Utiliza arreglos en memoria
 * 
 * @author Cristian Pinto, Julio Mellizo
 */
public final class ClienteRepositoryImplArrays implements IClienteRepository {

    /**
     * Array List de clientes
     */
    private static List<Cliente> clientes;

    public ClienteRepositoryImplArrays() {
        if (clientes == null){
            clientes = new ArrayList();
        }
        
        if (clientes.size() == 0){
            inicializar();
        }
    }

    public void inicializar() {
        clientes.add(new Cliente("Andrea", "Sanchez", "24/09/1999", "andrea@hotmail.com", "12345"));
        clientes.add(new Cliente( "Libardo", "Pantoja", "24/09/1998",  "libardo@gmail.com", "12345"));
        clientes.add(new Cliente("Carlos", "Pantoja", "24/09/1987",  "carlos@gmail.com", "12345"));
    }

    @Override
    public String addCliente(Cliente cliente) {
        clientes.add(cliente);
        return cliente.getCorreoCliente();
    }
    
    /**
     * Busca un cliente en el arreglo
     * @param correo correo del cliente
     * @return objeto cliente
     */
    @Override
    public Cliente findCliente(String correo) {
        for (Cliente cliente : clientes) {
            if (cliente.getCorreoCliente().equals(correo)) {
                return cliente;
            }
        }
        return null;
    }

}
