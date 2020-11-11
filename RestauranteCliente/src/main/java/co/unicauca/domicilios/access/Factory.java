package co.unicauca.domicilios.access;

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
	
}
