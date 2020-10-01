
package Controlador;
import Modelo.Ganancias;
import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
public class GananciasCTD {
    static ConexionBD cc=new ConexionBD();
    public static Connection cn=cc.conexion();
    static PreparedStatement ps;
    static ResultSet rs;
    public boolean ganancias_post(Ganancias gn){
        String sql="insert into ventasdeldia (venta_b_e,valordeldia,porcentaje,ganancias) values (?,?,?,?)";
        try {
            ps=cn.prepareStatement(sql);
            ps.setString(1, gn.getVenta_b_e());
            ps.setDouble(2, gn.getValordeldia());
            ps.setInt(3, gn.getPorcentaje());
            ps.setDouble(4, gn.getGanancias());
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    public static void listarganancias(String busca){
        DefaultTableModel modelo = (DefaultTableModel) about.About.tabla.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if ("".equals(busca)) {
            sql="select * from ventasdeldia order by id desc";
        }else{
            sql="";
        }
        String datos[] = new String[6];
        try {
            Statement st=cn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString("id");
                datos[1]=rs.getString("fecha");
                datos[2]=rs.getString("venta_b_e");
                datos[3]=rs.getString("valordeldia");
                datos[4]=rs.getString("porcentaje");
                datos[5]=rs.getString("ganancias");
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GananciasCTD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static int eliminar(int id) {
        int rsu = 0;
        String sql = "DELETE FROM ventasdeldia WHERE id = ?";

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
        String sql = "TRUNCATE TABLE ventasdeldia";
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
}
