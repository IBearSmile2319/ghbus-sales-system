/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rojeru San CL
 */
public class Opciones {

    static ConexionBD cc = new ConexionBD();
    public static Connection cn = cc.conexion();
    static PreparedStatement ps;

    public static int registrar(Sentencias uc) {
        int rsu = 0;
        String sql = Sentencias.REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, uc.getId_venta());
            ps.setInt(2, uc.getId_producto());
            ps.setDouble(3, uc.getCantidad());
            ps.setDouble(4, uc.getTotal());
            ps.setString(5, uc.getFecha());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(sql);
        return rsu;
    }

    public static int actualizar(Sentencias uc) {
        int rsu = 0;
        String sql = Sentencias.ACTUALIZAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, uc.getCantidad());
            ps.setDouble(2, uc.getTotal());
            ps.setString(3, uc.getFecha());
            ps.setInt(4, uc.getId_producto());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
        }
        System.out.println(sql);
        return rsu;
    }

    public static int eliminar(int id) {
        int rsu = 0;
        String sql = Sentencias.ELIMINAR;

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
        String sql = Sentencias.ELIMINAR_TODO;

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
        DefaultTableModel modelo = (DefaultTableModel) ventas.Productos.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = Sentencias.LISTAR;
        } else {
            sql = "SELECT * FROM producto WHERE (idproducto LIKE'" + busca + "%' OR "
                    + "nombre LIKE'" + busca + "%' OR descripcion LIKE'" + busca + "%' OR "
                    + "tipoproducto LIKE'" + busca + "%' OR precio LIKE'" + busca + "%' OR "
                    + "idproducto LIKE'" + busca + "%') "
                    + "ORDER BY idproducto";
        }
        String datos[] = new String[6];
        try {           
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("idproducto");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("descripcion");
                datos[3] = rs.getString("tipoproducto");
                datos[4] = rs.getString("precio");
                datos[5] = rs.getString("stock");
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void calcular() {
        String pre;
        String can;
        double total = 0;
        double precio;
        int cantidad;
        double imp = 0.0;

        for (int i = 0; i < ventas.ListarEnvios.JTBLEncomiendas.getRowCount(); i++) {
            pre = ventas.ListarEnvios.JTBLEncomiendas.getValueAt(i, 4).toString();
            can = ventas.ListarEnvios.JTBLEncomiendas.getValueAt(i, 3).toString();
            precio = Double.parseDouble(pre);
            cantidad = Integer.parseInt(can);
            imp = precio * cantidad;
            total = total + imp;
            ventas.ListarEnvios.JTBLEncomiendas.setValueAt(Math.rint(imp * 100) / 100, i, 5);

        }
        ventas.ListarEnvios.txtTotal.setText("" + Math.rint(total * 100) / 100);
    }

    public static void corteCaja() {
        int filas = ventas.ListarBoletos.tabla.getRowCount();
        double totalE = 0.0;
        for (int i = 0; i < filas; i++) {
            totalE = totalE + Double.parseDouble(ventas.ListarBoletos.tabla.getValueAt(i, 3).toString());
        }
        ventas.ListarBoletos.lblTotal.setText(String.valueOf(totalE));
    }

    public static void enviar(int codigo, int cantidad) {
        DefaultTableModel tabladet = (DefaultTableModel) ventas.ListarEnvios.JTBLEncomiendas.getModel();
        String[] dato = new String[6];
        int fila = ventas.Productos.tabla.getSelectedRow();

        String sql = "SELECT * FROM producto WHERE idproducto = " + codigo;
        String cod = String.valueOf(codigo);
        String nombre = null;
        String descripcion = null;
        String precio = null;
        String cant = String.valueOf(cantidad);
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                nombre = rs.getString("nombre");
                descripcion = rs.getString("descripcion");
                precio = rs.getString("precio");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        int c = 0;
        int j = 0;

        for (int i = 0; i < ventas.ListarEnvios.JTBLEncomiendas.getRowCount(); i++) {
            Object com = ventas.ListarEnvios.JTBLEncomiendas.getValueAt(i, 0);
            Object cant1 = ventas.ListarEnvios.JTBLEncomiendas.getValueAt(i, 3);
            if (cod.equals(com)) {
                j = i;
                int cantT = Integer.parseInt(cant) + Integer.parseInt((String) cant1);
                ventas.ListarEnvios.JTBLEncomiendas.setValueAt(String.valueOf(cantT), i, 3);
                c++;
                calcular();
                ventas.ListarEnvios.txtImporte.setText("");
                ventas.ListarEnvios.txtCambio.setText("");
            }
        }
        if (c == 0) {

            dato[0] = cod;
            dato[1] = nombre;
            dato[2] = descripcion;
            dato[3] = cant;
            dato[4] = precio;

            tabladet.addRow(dato);

            ventas.ListarEnvios.JTBLEncomiendas.setModel(tabladet);
            calcular();

            ventas.ListarEnvios.txtImporte.setText("");
            ventas.ListarEnvios.txtCambio.setText("");
        }
    }
    
}
