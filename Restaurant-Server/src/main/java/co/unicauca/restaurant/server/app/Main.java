package co.unicauca.restaurant.server.app;

import co.unicauca.restaurant.server.infra.DomiciliosServerSocket;
/**
 * Aplicacion principal que lanza el servidor en un hilo
 * @author Cristian Pinto, Julio Mellizo
 */
public class Main {

    public static void main(String[] args) {
        DomiciliosServerSocket domiciliosServer = new DomiciliosServerSocket();
        domiciliosServer.startServer();
    }

}
