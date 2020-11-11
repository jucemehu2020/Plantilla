package co.unicauca.domicilios.domain.services;

import co.unicauca.domicilios.domain.Cliente;
import co.unicauca.domicilios.access.ICliente;


public class DomiciliosService {
    
    private final ICliente service;

    /**
     * Constructor privado que evita que otros objetos instancien
     *
     * @param service implementacion de tipo ISaladService
     */
    public DomiciliosService(ICliente service) {
        this.service = service;
    }

    public String createCliente(Cliente cliente) throws Exception {
        return service.addCliente(cliente);

    }

}
