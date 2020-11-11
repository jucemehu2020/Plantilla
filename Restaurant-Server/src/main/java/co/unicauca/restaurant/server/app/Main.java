package co.unicauca.restaurant.server.app;

import co.unicauca.restaurant.server.infra.DomiciliosServer;

public class Main {

    public static void main(String[] args) {
        DomiciliosServer domiciliosServer = new DomiciliosServer();
        domiciliosServer.startServer();
    }

}
