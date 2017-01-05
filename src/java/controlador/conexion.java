/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
private String DATABASE = "proyecto_conferencia";
private String CLASSNAME = "com.mysql.jdbc.Driver";
private String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
protected Connection con;
public conexion() {
    try{   
    Class.forName(CLASSNAME);
    con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    } catch (ClassNotFoundException | SQLException e){
        System.err.printf("ERROR ", e);   
        }
}
    
    
    
    
    
}
