package co.unicauca.restaurant.server.access;

public class Factory {
	
	private static Factory instance;
	
	private Factory() {
	}
	
	/**
	 * Clase singleton
	 *
	 * @return
	 */
	public static Factory getInstance() {
		
		if (instance == null) {
			instance = new Factory();
		}
		return instance;
		
	}
	
	/**
	 * Método que crea una instancia concreta de la jerarquia
	 * ICustomerRepository
	 *
	 * @return una clase hija de la abstracción IRepositorioClientes
	 */
	public IClienteRepository getRepository() {
		String type = "default";
		
		if (type.isEmpty()) {
			type = "default";
		}
		
		IClienteRepository result = null;
		
		result = new ClienteRepositoryImplMySql();
		
		return result;
		
	}
}
