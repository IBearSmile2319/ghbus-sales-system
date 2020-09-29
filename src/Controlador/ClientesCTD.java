
package Controlador;
import Modelo.Cliente;
import clientes.Clientes;
import conexion.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class ClientesCTD {
    static ConexionBD cc=new ConexionBD();
    public static Connection cn=cc.conexion();
    static PreparedStatement ps;
    static ResultSet rs;
    public Cliente verificar(String dni){
        Cliente cl=new Cliente();
        String sql="select*from clientes where dni=?";
        try {
            ps=cn.prepareStatement(sql);
            ps.setString(1, dni);
            rs=ps.executeQuery();
            if(!rs.next()){
                cl=null;
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return cl;
    }
    public boolean Registrar_cliente(Cliente cl){
        String sql="INSERT INTO clientes (nombre,dni) VALUES(?,?)";
        try {
            ps=cn.prepareStatement(sql);
            ps.setString(1,cl.getNombre());
            ps.setString(2,cl.getDni());
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
    public static void listarCliente(String busca){
        DefaultTableModel modelo= (DefaultTableModel) Clientes.tabla.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql="";
        if(busca.equals("")){
            sql="select*from clientes";
        }else{
            sql="SELECT*FROM clientes where (id LIKE '"+busca+"%' OR "
                    +"nombre LIKE'" + busca + "%' OR dni LIKE'" + busca + "%')";
        }
        String datos[]= new String[4];
        try {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()) {
                datos[0]=rs.getString("id");
                datos[1]=rs.getString("nombre");
                datos[2]=rs.getString("dni");
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static int actualizar(Cliente cl) {
        int rsu = 0;
        String sql = "UPDATE clientes SET "
                +"nombre=?,"
                +"dni=?,"
                +"where id=?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, cl.getNombre());
            ps.setString(2, cl.getDni());
            ps.setInt(3, cl.getId());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
        }
        System.out.println(sql);
        return rsu;
    }
    public static int eliminar(int id) {
        int rsu = 0;
        String sql = "DELETE FROM clientes where id=?";

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
    public static boolean verificaCliente(String dni) {
        boolean existe = false;
        String user = "";
        try {
            String sql = "SELECT * FROM clientes WHERE dni = '" + dni + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                user = rs.getString(2);
            }

            if (user.equals(dni)) {
                existe = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClientesCTD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existe;
    }
    public Cliente verificarCli(String dni){
        Cliente cliente=new Cliente();
        String sql="select*from clientes where dni=?";
        try {
            ps=cn.prepareStatement(sql);
            ps.setString(1, dni);
            rs=ps.executeQuery();
            if(rs.next()){
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDni(rs.getString("dni"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return cliente;
    }
}
