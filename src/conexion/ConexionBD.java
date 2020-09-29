package conexion;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Sony
 */

public class ConexionBD {

    Connection conect;

    public Connection conexion() {
        try {
            String DB= "jdbc:mysql://localhost:3306/ghbus?serverTimezone=UTC";
            conect = DriverManager.getConnection(DB, "root", "root"); 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión" + e);
        }
        return conect;
    }   
//    
//     public Connection Desconectar() {
//        try {
//            conect.close();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error en la conexión" + e);
//        }
//        return conect;
//    }   
}
