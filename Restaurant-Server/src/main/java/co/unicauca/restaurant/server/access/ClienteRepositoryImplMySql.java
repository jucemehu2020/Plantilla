package co.unicauca.restaurant.server.access;

import co.unicauca.domicilios.domain.Cliente;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteRepositoryImplMySql implements IClienteRepository{
	
	private Connection con;
        private ResultSet rs;
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String user = "root";
	private static final String pass = "system";
	private static final String url = "jdbc:mysql://localhost:3306/basededatos";
	
	
	public ClienteRepositoryImplMySql() {
	}
	
        public ResultSet getResultado(){
            return rs;
        }
        
        @Override
	public String addCliente(Cliente cliente) {
		try {
			this.connect();
			String sql = "INSERT INTO cliente(nombreCliente, apellidoCliente, fechaNacCliente, correoCliente, claveCliente) VALUES (?,?,?,?,?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, cliente.getNombreCliente());
			statement.setString(2, cliente.getApellidoCliente());
			statement.setString(3, cliente.getFechaNacCliente());
			statement.setString(4, cliente.getCorreoCliente());
                        statement.setString(5, cliente.getClaveCliente());
			statement.executeUpdate();
			statement.close();
			this.disconnect();
			
		} catch (SQLException exception) {
			Logger.getLogger(ClienteRepositoryImplMySql.class.getName()).log(Level.SEVERE, "Error al insertar el registro");
		}
		
		return cliente.getCorreoCliente();
	}              
	
	public void connect() {
		// Reseteamos a null la conexion a la bd
		con = null;
		try {
			Class.forName(driver);
			
			// Nos conectamos a la bd
			con = (Connection) DriverManager.getConnection(url, user, pass);
			
			// Si la conexion fue exitosa mostramos un mensaje de conexion exitosa
			if (con != null) {
				System.out.println("Conexion establecida");
			}
		}
		// Si la conexion NO fue exitosa mostramos un mensaje de error
		catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error de conexion" + e);
		}
	}
	
	public void disconnect() {
		try {
			con.close();
		} catch (SQLException exception) {
			Logger.getLogger(ClienteRepositoryImplMySql.class.getName()).log(Level.FINER, "Error al cerrar Connection", exception);
		}
	}
}
