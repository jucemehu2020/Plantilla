package co.unicauca.restaurant.server.access;

import co.unicauca.domicilios.domain.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de IClienteRepository. Utilliza arreglos en memoria
 *
 * @author Camilo Otaya, Maria Teresa Trujillo
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
        clientes.add(new Cliente("Andrea", "Sanchez", "Calle 14 No 11-12 Popayan", "andrea@hotmail.com", "Femenino"));
        clientes.add(new Cliente( "Libardo", "Pantoja", "Santa Barbar Popayan",  "libardo@gmail.com", "Masculino"));
        clientes.add(new Cliente("Carlos", "Pantoja", "Santa Barbar Popayan",  "carlos@gmail.com", "Masculino"));
        clientes.add(new Cliente("Fernanda", "Arevalo", "Calle 16 No 12-12 Popayan",  "fercha@hotmail.com", "Femenino"));
        clientes.add(new Cliente("Manuel", "Perez", "Calle 12 No 12-12 Popayan",  "fer@hotmail.com", "Masculino"));        
    }

    /**
     * Busca u Cliente en el arreglo
     *
     * @param id cedula del cliente
     * @return objeto Cliente
     */

    @Override
    public String addCliente(Cliente cliente) {
        clientes.add(cliente);
        return cliente.getCorreoCliente();
    }

}
