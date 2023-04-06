
package dao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Ricardo
 */
public class ConexionClever {
    protected Connection conexion;
    
    private final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
    
    private final String BD_URL="jdbc:mysql://ugspusywmp0tjfhr:nsZJ9u3pCgZnVrpVqkNi@bwxzxwin29jpuu5uwcnd-mysql.services.clever-cloud.com:3306/bwxzxwin29jpuu5uwcnd";
                                

    Statement st =null;
    ResultSet rs=null;
   
    public void Conectar() throws Exception{
       try {
           Class.forName (JDBC_DRIVER);
           conexion=DriverManager.getConnection(BD_URL);
            
            
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }
    
    public void Cerrar() throws SQLException{
        if (conexion !=null){
            if (!conexion.isClosed()){
                conexion.close();
            }
        }
    }
       
        

}
