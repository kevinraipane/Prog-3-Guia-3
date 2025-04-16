package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    //Datos base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/banco";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "admin";

    //Instancias
    private static DBConnection instance;
    private Connection connection;

    //Constructor para iniciar la conexion
    private DBConnection(){
        try {
            this.connection = DriverManager.getConnection(URL,USUARIO,PASSWORD);
            System.out.println("Conexion exitosa con la base de datos.");
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar con la base de datos",e);
        }
    }

    //Obtener la instancia unica
    public static DBConnection getInstance(){
        if (instance == null){
            instance = new DBConnection();
        }
        return instance;
    }

    //Metodo obtener la conexion
    public Connection getConnection() {
        return connection;
    }

    //Metodo para cerrar la conexion
    public void cerrarConexion(){
        if(connection != null){
            try {
                connection.close();
                connection = null;
                instance = null;
                System.out.println("Conexion cerrada correctamente.");
            }catch (SQLException e){
                throw new RuntimeException("Error al cerrar la conexcion",e);
            }
        }
    }
}
