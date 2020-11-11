package co.unicauca.domicilios.access;

import co.unicauca.domicilios.domain.Cliente;
import co.unicauca.domicilios.infra.DomiciliosSocket;
import co.unicauca.domicilios.infra.JsonError;
import co.unicauca.domicilios.infra.Protocol;
import com.google.gson.Gson;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julio Cesar
 */
public class ClienteAccessImplSockets implements ICliente{
     
    private DomiciliosSocket mySocket;
    
    public ClienteAccessImplSockets() {		
		mySocket = new DomiciliosSocket();
	}
     
        @Override
	public String addCliente(Cliente cliente) throws Exception {
		String jsonResponse = null;
		String requestJson = addClienteRequestJson(cliente);
		try {
			mySocket.connect();
			jsonResponse = mySocket.sendStream(requestJson);
			mySocket.closeStream();
			mySocket.disconnect();
			
		} catch (IOException exception) {
			Logger.getLogger(ClienteAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexion con el servidor", exception);
		}
		
		if (jsonResponse == null) {
			throw new Exception("No se pudo conectar con el servidor");
		} else {			
			if (jsonResponse.contains("error")) {
				//Devolvió algún error
				Logger.getLogger(ClienteAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
				throw new Exception(extractMessages(jsonResponse));
			} else {
				return cliente.getNombreCliente();
			}
			
		}		
	}

        private String addClienteRequestJson(Cliente cliente) {
		Protocol protocol = new Protocol();
		protocol.setResource("cliente");
		protocol.setAction("post");
		protocol.addParameter("nombreCliente", cliente.getNombreCliente());
		protocol.addParameter("apellidoCliente", cliente.getApellidoCliente ());
		protocol.addParameter("fechaNacCliente", cliente.getFechaNacCliente());
		protocol.addParameter("correoCliente", cliente.getCorreoCliente());
                protocol.addParameter("claveCliente", cliente.getClaveCliente());

		Gson gson = new Gson();
		String requestJson = gson.toJson(protocol);
		System.out.println("json" + requestJson);
		
		return requestJson;
	}

        
            private void parseToCliente(Cliente cliente,String Json){
        Gson gson = new Gson();
        Properties prop = gson.fromJson(Json, Properties.class);
        
        cliente.setNombreCliente(prop.getProperty("clienteNombre"));
        cliente.setApellidoCliente(prop.getProperty("clienteApellido"));
        cliente.setFechaNacCliente(prop.getProperty("clienteFecha"));
        cliente.setCorreoCliente(prop.getProperty("clienteCorreo"));
        cliente.setClaveCliente(prop.getProperty("clienteClave"));              
    }
        private String consultarClienteRequestJson(String id,String contrasena) {
		Protocol protocol = new Protocol();
		protocol.setResource("cliente");
		protocol.setAction("get");    
                protocol.addParameter("idCliente", id);
		protocol.addParameter("contrasenaCliente", contrasena);
		Gson gson = new Gson();
		String requestJson = gson.toJson(protocol);
		System.out.println("json" + requestJson);
		
		return requestJson;
	}
    
        private String extractMessages(String jsonResponse) {
		JsonError[] errors = jsonToErrors(jsonResponse);
		String msjs = "";
		for (JsonError error : errors) {
			msjs += error.getMessage();
		}
		return msjs;
	}
        
        	private JsonError[] jsonToErrors(String jsonError) {
		Gson gson = new Gson();
		JsonError[] error = gson.fromJson(jsonError, JsonError[].class);
		return error;
    
                }
}
