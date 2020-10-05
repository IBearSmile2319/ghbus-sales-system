package Controlador;
import conexion.ConexionBD;
import Modelo.Boleto;
import Modelo.Cliente;
import java.awt.Component;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
public class BoletoCTD {
    static ConexionBD cc=new ConexionBD();
    public static Connection cn=cc.conexion();
    static PreparedStatement ps;
    static ResultSet rs;
    public boolean boleto_Post(Boleto bl){
        String sql="insert into boleto(recibo,nombre_razonsocial,ruc,pasajero,asiento,origen,destino,fecha_viaje,hora_partida,dni,valor_venta,precio_total,celular,correo,son) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps=cn.prepareStatement(sql);
            ps.setString(1,bl.getRecibo());
            ps.setString(2,bl.getNombre_razonsocial());
            ps.setString(3,bl.getRuc());
            ps.setString(4,bl.getPasajero());
            ps.setInt(5,bl.getAsiento());
            ps.setString(6,bl.getOrigen());
            ps.setString(7,bl.getDestino());
            ps.setString(8,bl.getFecha_viaje());
            ps.setString(9,bl.getHora_partida());
            ps.setString(10,bl.getDni());
            ps.setDouble(11,bl.getValor_venta());
            ps.setDouble(12,bl.getPrecio_total());
            ps.setString(13,bl.getCelular());
            ps.setString(14,bl.getCorreo());
            ps.setString(15,bl.getSon());
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
        
    }
    public boolean boleto_Put(Boleto bl){
        String sql="update boleto set nombre_razonsocial=?,ruc=?,pasajero=?,asiento=?,origen=?,destino=?,fecha_viaje=?,hora_partida=?,dni=?,valor_venta=?,precio_total=?,celular=?,correo=?,son=? where id=?";
        try {
            ps=cn.prepareStatement(sql);
            ps.setString(1,bl.getNombre_razonsocial());
            ps.setString(2,bl.getRuc());
            ps.setString(3,bl.getPasajero());
            ps.setInt(4,bl.getAsiento());
            ps.setString(5,bl.getOrigen());
            ps.setString(6,bl.getDestino());
            ps.setString(7,bl.getFecha_viaje());
            ps.setString(8,bl.getHora_partida());
            ps.setString(9,bl.getDni());
            ps.setDouble(10,bl.getValor_venta());
            ps.setDouble(11,bl.getPrecio_total());
            ps.setString(12,bl.getCelular());
            ps.setString(13,bl.getCorreo());
            ps.setString(14,bl.getSon());
            ps.setInt(15,bl.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
        
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
    public static void listarBoletos(String busca){
        DefaultTableModel modelo = (DefaultTableModel) ventas.ListarBoletos.tabla.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if ("".equals(busca)) {
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
            
            System.out.print(calendario);
            sql = "select*from boleto where fecha_expedicion like'"+calendario+"%' order by id desc";
        } else {
            sql = "SELECT * FROM boleto WHERE id LIKE'" + busca + "%' OR "
                    + "pasajero LIKE'" + busca + "%' OR asiento LIKE'" + busca + "%' OR "
                    + "origen LIKE'" + busca + "%' OR destino LIKE'" + busca + "%' OR "
                    + "fecha_viaje LIKE'" + busca + "%' OR "
                    + "hora_partida LIKE'" + busca + "%' OR dni LIKE'" + busca + "%' OR "
                    + "valor_venta LIKE'" + busca + "%' OR precio_total LIKE'" + busca + "%' OR "
                    + "celular LIKE'" + busca + "%' OR correo LIKE'" + busca + "%' OR "
                    + "recibo LIKE'" + busca + "%' order by id desc";
        }
        String datos[] = new String[13];
        try {
            Statement st=cn.createStatement();
            rs=st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("id");
                datos[1] = rs.getString("correo");
                datos[2] = rs.getString("pasajero");
                datos[3] = rs.getString("origen");
                datos[4] = rs.getString("destino");
                datos[5] = rs.getString("asiento");
                datos[6] = rs.getString("fecha_expedicion");
                datos[7] = rs.getString("fecha_viaje");
                datos[8] = rs.getString("hora_partida");
                datos[9] = rs.getString("dni");
                datos[10] = rs.getString("precio_total");
                datos[11] = rs.getString("celular");
                datos[12] = rs.getString("status");
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ventas.ListarBoletos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void listarBoletosfexpedicion(String busca){
        DefaultTableModel modelo = (DefaultTableModel) ventas.ListarBoletos.tabla.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if ("".equals(busca)) {
            Calendar fecha=new GregorianCalendar();
            int año=fecha.get(Calendar.YEAR);
            int mes=fecha.get(Calendar.MONTH)+1;
            int dia=fecha.get(Calendar.DAY_OF_MONTH);
            String calendario;
            if(mes<=9){
                calendario=año+"-0"+mes+"-"+dia;
            }else{
                calendario=año+"-"+mes+"-"+dia;
            }
            sql = "select*from boleto where fecha_expedicion like'"+calendario+"%' order by id desc";
        } else {
            sql = "SELECT * FROM boleto WHERE fecha_expedicion LIKE'" + busca + "%' order by id desc";
        }
        String datos[] = new String[13];
        try {
            Statement st=cn.createStatement();
            rs=st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("id");
                datos[1] = rs.getString("recibo");
                datos[2] = rs.getString("pasajero");
                datos[3] = rs.getString("origen");
                datos[4] = rs.getString("destino");
                datos[5] = rs.getString("asiento");
                datos[6] = rs.getString("fecha_expedicion");
                datos[7] = rs.getString("fecha_viaje");
                datos[8] = rs.getString("hora_partida");
                datos[9] = rs.getString("dni");
                datos[10] = rs.getString("precio_total");
                datos[11] = rs.getString("celular");
                datos[12] = rs.getString("status");
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ventas.ListarBoletos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static int eliminar(int id) {
        int rsu = 0;
        String sql = "DELETE FROM boleto WHERE id = ?";

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
        String sql = "TRUNCATE TABLE boleto";
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
    
    /*Estados*/
    public static int cambiarestadoAabordo(int id){
        int rsu=0;
        String sql="update boleto set status='ABORDO' where id=?";
        try {
            ps=cn.prepareStatement(sql);
            ps.setInt(1, id);
            rsu=ps.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }
    public static int cambiarestadoANoAbordo(int id){
        int rsu=0;
        String sql="update boleto set status='NO ABORDO' where id=?";
        try {
            ps=cn.prepareStatement(sql);
            ps.setInt(1, id);
            rsu=ps.executeUpdate();      
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }
    public int IdBoleto(){
        int id=1;
        String sql="SELECT MAX(id) FROM boleto";
        try {
            ps=cn.prepareStatement(sql);
            rs=ps.executeQuery();
            if(rs.next()){
                id=rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return id;
    }
    
}
