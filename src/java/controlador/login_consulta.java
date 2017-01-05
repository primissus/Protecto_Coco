/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author trafalgar
 */
public class login_consulta extends conexion
{
    
     public boolean autenticacion(String user_name, String Password){
    PreparedStatement pst =null;
    ResultSet rs = null;
        try{
            String consulta = "select * from login where user_name =? and Password=?";
            pst = con.prepareStatement(consulta);
            pst.setString(1, user_name);
            pst.setString(2, Password);
            rs = pst.executeQuery();
            if(rs.absolute(1)){
                 return true;
             }
        } catch (Exception e){
                System.err.printf("Error", e);
                 }finally{
            try{
                        if(con != null) con.close();
                        if(pst != null) pst.close();
                        if(rs != null) rs.close();
                            }   catch (Exception e){
                                 System.err.printf("Error", e);
                                }
                            }
        return false;
    }
    
    
    
    
    
}
