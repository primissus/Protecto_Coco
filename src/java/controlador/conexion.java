package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author trafalgar
 */
public class conexion {
private String USERNAME = "root";
private String PASSWORD = "";
private String HOST = "localhost";
private String PORT = "3306";
private String DATABASE = "conferencias";
private String CLASSNAME = "com.mysql.jdbc.Driver";
private String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
private Connection con;
public conexion() {
    try{   
    Class.forName(CLASSNAME);
    con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    } catch (ClassNotFoundException e){
        System.err.printf("ERROR ", e);   
        } catch (SQLException e){
        System.err.printf("ERROR ", e);
        }
}
public Connection getConexion(){
    return con;
}
    public static void main(String[] args){
    conexion con = new conexion();
    
    }
    
    
    
}
