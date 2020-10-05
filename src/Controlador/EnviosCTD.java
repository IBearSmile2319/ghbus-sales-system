package Controlador;
import Modelo.Envios;
import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class EnviosCTD {
    static ConexionBD cc = new ConexionBD();
    static Connection cn = cc.conexion();
    static PreparedStatement ps;
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
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    public static int eliminar(int id) {
        int rsu = 0;
        String sql = "DELETE FROM envios where id=?";

        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }
    public static int eliminarTodo() {
        int rsu = 0;
        String sql = "TRUNCATE TABLE envios";

        try {
            ps = cn.prepareStatement(sql);
            rsu = ps.executeUpdate();
            rsu++;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }
    public static void listar(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) producto.Productos.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            Calendar fecha=new GregorianCalendar();
            int año=fecha.get(Calendar.YEAR);
            int mes=fecha.get(Calendar.MONTH)+1;
            int dia=fecha.get(Calendar.DAY_OF_MONTH);
            String calendario;
            if(mes<=9){
                if(dia<=9){
                    calendario=año+"-0"+mes+"-0"+dia;
                }else{
                    calendario=año+"-0"+mes+"-"+dia;
                }
            }else{
                if(dia<=9){
                    calendario=año+"-"+mes+"-0"+dia;
                }else{
                    calendario=año+"-"+mes+"-"+dia;
                }
                
            }
            sql = "SELECT*FROM envios where fecha_actual LIKE'"+calendario+"%' ORDER BY id desc";
        } else {
            sql = "SELECT * FROM envios WHERE (id LIKE'" + busca + "%' OR "
                    + "desde LIKE'" + busca + "%' OR hacia LIKE'" + busca + "%' OR "
                    + "remitente LIKE'" + busca + "%' OR dni_rem LIKE'" + busca + "%' OR "
                    + "beneficiario LIKE'" + busca + "%' OR dni_bene LIKE'" + busca + "%' OR "
                    + "fecha_actual LIKE'" + busca + "%') "
                    + "ORDER BY id desc";
        }
        String datos[] = new String[17];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("id");
                datos[1] = rs.getString("desde");
                datos[2] = rs.getString("hacia");
                datos[3] = rs.getString("remitente");
                datos[4] = rs.getString("dni_rem");
                datos[5] = rs.getString("celular_rem");
                datos[6] = rs.getString("beneficiario");
                datos[7] = rs.getString("dni_bene");
                datos[8] = rs.getString("celular_bene");
                datos[9] = rs.getString("direccion_bene");
                datos[10] = rs.getString("correo");
                datos[11] = rs.getString("cant_enc");
                datos[12] = rs.getString("contenido");
                datos[13] = rs.getString("precio_unit");
                datos[14] = rs.getString("importe");
                datos[15] = rs.getString("clave");
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnviosCTD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static int extraerID() {
        int c = 0;
        String SQL = "SELECT MAX(id) FROM envios";

        try {
             Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                c = rs.getInt(1);
            }
                      
        } catch (SQLException ex) {
            Logger.getLogger(EnviosCTD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
}
