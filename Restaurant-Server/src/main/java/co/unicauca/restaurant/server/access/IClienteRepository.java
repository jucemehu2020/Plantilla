package co.unicauca.restaurant.server.access;
import co.unicauca.domicilios.domain.Cliente;

/**
 * Interface del repositorio de Clientes
 * @author Cristian Pinto, Julio Mellizo
 */
public interface IClienteRepository {
    public String addCliente(Cliente cliente);
    /**
     * Busca un cliente por su correo
     * @param correo correo del cliente
     * @return objeto de tipo cliente
     */
    public Cliente findCliente(String correo);
    
}
