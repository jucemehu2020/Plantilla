
package co.unicauca.domicilios.access;

import co.unicauca.domicilios.domain.Cliente;

/**
 * Interfaz que define los servicios de clientes para el programa Deliverya
 * 
 * @author Cristian Pinto, Julio Mellizo
 */

public interface ICliente {
    /**
     * Agrega un cliente utilizando un socket
     * 
     * @param cliente Cliente del restaurante
     * @return objeto cliente, en caso contrario, retorna null
     * @throws Exception 
     */
    public String addCliente(Cliente cliente) throws Exception;
    /**
     * Busca un cliente mediante su correo
     * @param correo recibe correo por medio del cual buscara el cliente 
     * @return Si lo encuentra retorna el objeto cliente, de lo contrario retorna null
     * @throws Exception Error al encontrar al ciente
     */
    public Cliente findCliente(String correo) throws Exception;
}
