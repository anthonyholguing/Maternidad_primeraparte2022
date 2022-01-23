package maternidad;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Dalember
 */
public class conexion {
    
    public Connection conectarDB() {
        //Variables
        String database = "jdbc:postgresql://localhost:5432/2021MATERNIDADGESTION";
        String user = "postgres";
        String password = "anthonyg";
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(database, user, password);
   
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return conexion;
    }
}
