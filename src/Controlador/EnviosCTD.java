package Controlador;
import Modelo.Cliente;
import Modelo.Envios;
import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class EnviosCTD {
    static ConexionBD cc=new ConexionBD();
    public static Connection cn=cc.conexion();
    static PreparedStatement ps;
    static ResultSet rs;
    public boolean Envios_post (Envios en){
        String sql="insert into envios (desde,hacia,remitente,dni_rem,celular_rem,ruc_rem,beneficiario,dni_bene,celular_bene,direccion_bene,correo,cant_enc,contenido,precio_unit,importe,clave) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        try {
            ps=cn.prepareStatement(sql);
            ps.setString(1,en.getDesde() );
            ps.setString(2,en.getHacia() );
            ps.setString(3,en.getRemitente() );
            ps.setString(4,en.getDni_rem() );
            ps.setString(5,en.getCelular_rem() );
            ps.setString(6,en.getRuc_rem());
            ps.setString(7,en.getBeneficiario() );
            ps.setString(8,en.getDni_bene());
            ps.setString(9,en.getCelular_bene() );
            ps.setString(10,en.getDireccion_bene());
            ps.setString(11,en.getCorreo());
            ps.setInt(12,en.getCant_enc() );
            ps.setString(13,en.getContenido());
            ps.setDouble(14,en.getPrecio_unit() );
            ps.setDouble(15,en.getImporte());
            ps.setString(16,en.getClave());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }finally{
            try {
                cn.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
}
