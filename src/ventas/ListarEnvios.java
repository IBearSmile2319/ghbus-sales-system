/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import alertas.principal.ErrorAlert;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tabla.EstiloTablaHeader;
import tabla.EstiloTablaRenderer;
import tabla.MyScrollbarUI;
/*envios*/
import Controlador.EnviosCTD;
import Modelo.Envios;
/*cliente*/
import Controlador.ClientesCTD;
import Modelo.Cliente;
import alertas.principal.SuccessAlert;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Rojeru San
 */
public class ListarEnvios extends javax.swing.JInternalFrame {
    EnviosCTD enctd=new EnviosCTD();
    Envios en=new Envios();
    /*Clientes*/
    ClientesCTD clctd=new ClientesCTD();
    Cliente cl=new Cliente();
    
    DefaultTableModel modelo=new DefaultTableModel();
    Date date=new Date();
    
    public ListarEnvios() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        JTBLEncomiendas.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
        JTBLEncomiendas.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getVerticalScrollBar().setUI(new MyScrollbarUI());
        jScrollPane1.getHorizontalScrollBar().setUI(new MyScrollbarUI());
        limpiaCampos();
        txtFecha.setText(new SimpleDateFormat("d/MM/yyyy").format(date));

    }
    public void guardar_envio(){
        if(!"".equals(txtDe.getText())||!"".equals(txtA.getText())||!"".equals(txtRemitente.getText())||!"".equals(txtDniRemitente.getText())||!"".equals(txtCelularRemitente.getText())||!"".equals(txtRucRemitente.getText())||!"".equals(txtBeneficiario.getText())||!"".equals(txtDniBeneficiario.getText())||!"".equals(txtCelularBeneficiario.getText())||!"".equals(txtDiceContener.getText())||!"".equals(txtClaveEnvio.getText())){
            en.setDesde(txtDe.getText().toUpperCase());
            en.setHacia(txtA.getText().toUpperCase());
            en.setRemitente(txtRemitente.getText().toUpperCase());
            en.setDni_rem(txtDniRemitente.getText());
            en.setCelular_rem(txtCelularRemitente.getText());
            en.setRuc_rem(txtRucRemitente.getText());
            en.setBeneficiario(txtBeneficiario.getText().toUpperCase());
            en.setDni_bene(txtDniBeneficiario.getText());
            en.setCelular_bene(txtCelularBeneficiario.getText());
            if(!"".equals(txtDireccionBeneficiario.getText())){
                en.setDireccion_bene(txtDireccionBeneficiario.getText().toUpperCase());
            }else{
                en.setDireccion_bene("");
            }
            if(!"".equals(txtCorreoEnvios.getText())){
                en.setCorreo(txtCorreoEnvios.getText().toUpperCase());
            }else{
                en.setCorreo("no tiene".toUpperCase());
            }
            
            en.setCant_enc(Integer.parseInt(txtCantidad.getText()));
            en.setContenido(txtDiceContener.getText().toUpperCase());
            en.setPrecio_unit(Double.parseDouble(txtPrecioUnit.getText()));
            if(!"".equals(txtImporte.getText())){
                en.setImporte(Double.parseDouble(txtImporte.getText()));
            }else{
                
                en.setImporte(0.00);
            }
            
            en.setClave(txtClaveEnvio.getText());
            enctd.Envios_post(en);
            
            agregar_tabla_envios();
            
            SuccessAlert sa = new SuccessAlert(new JFrame(), true);
            sa.titulo.setText("¡HECHO!");
            sa.msj.setText("SE HA AGREGADO UNA");
            sa.msj1.setText("NUEVA ENCOMIENDA");
            sa.setVisible(true);
        }else{
            ErrorAlert er = new ErrorAlert(new JFrame(), true);
            er.titulo.setText("OOPS...");
            er.msj.setText("LOS CAMPOS ESTAN VACIOS");
            er.msj1.setText("");
            er.setVisible(true);
        }
    }
    public void guardar_cliente_enviorem(){
        String dnienviorem=txtDniRemitente.getText();
        Cliente clienenviorem=clctd.verificarCli(dnienviorem);
        if(clienenviorem.getDni()!=null){
            System.out.println("Ya existe el cliente");
        }else{
            cl.setNombre(txtRemitente.getText());
            cl.setDni(txtDniRemitente.getText());
            clctd.Registrar_cliente(cl);
        }
    }
    public void guardar_cliente_enviobene(){
        String dnienviobene=txtDniBeneficiario.getText();
        Cliente clienenviobene=clctd.verificarCli(dnienviobene);
        if(clienenviobene.getDni()!=null){
            System.out.println("Ya existe el cliente");
        }else{
            cl.setNombre(txtBeneficiario.getText());
            cl.setDni(txtDniBeneficiario.getText());
            clctd.Registrar_cliente(cl);
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cerrar = new principal.MaterialButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtFecha = new app.bolivia.swing.JCTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        txtImporte = new app.bolivia.swing.JCTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCambio = new app.bolivia.swing.JCTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtRemitente = new app.bolivia.swing.JCTextField();
        txtBeneficiario = new app.bolivia.swing.JCTextField();
        txtA = new app.bolivia.swing.JCTextField();
        txtDniRemitente = new app.bolivia.swing.JCTextField();
        txtDe = new app.bolivia.swing.JCTextField();
        txtRucRemitente = new app.bolivia.swing.JCTextField();
        txtPrecioUnit = new app.bolivia.swing.JCTextField();
        txtCelularRemitente = new app.bolivia.swing.JCTextField();
        txtDniBeneficiario = new app.bolivia.swing.JCTextField();
        txtCorreoEnvios = new app.bolivia.swing.JCTextField();
        txtDireccionBeneficiario = new app.bolivia.swing.JCTextField();
        txtCelularBeneficiario = new app.bolivia.swing.JCTextField();
        txtCantidad = new app.bolivia.swing.JCTextField();
        txtDiceContener = new app.bolivia.swing.JCTextField();
        txtClaveEnvio = new app.bolivia.swing.JCTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLEncomiendas = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnCancelar = new principal.MaterialButton();
        btnRegistrarEnvio = new principal.MaterialButton();
        quitar = new principal.MaterialButton();
        btnImprimir = new principal.MaterialButton();

        setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        setBorder(dropShadowBorder1);
        setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(58, 159, 171));

        cerrar.setBackground(new java.awt.Color(255, 255, 255));
        cerrar.setForeground(new java.awt.Color(58, 159, 171));
        cerrar.setText("X");
        cerrar.setToolTipText("<html> <head> <style> #contenedor{background:white;color:black; padding-left:10px;padding-right:10px;margin:0; padding-top:5px;padding-bottom:5px;} </style> </head> <body> <h4 id=\"contenedor\">Cerrar</h4> </body> </html>");
        cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cerrar.setFont(new java.awt.Font("Roboto Medium", 1, 20)); // NOI18N
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventas/caja.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Encomiendas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(75, 75, 75)
                    .addComponent(jLabel4)
                    .addContainerGap(844, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 159, 171), 3));

        txtFecha.setBorder(null);
        txtFecha.setForeground(new java.awt.Color(58, 159, 171));
        txtFecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtFecha.setPlaceholder("FECHA");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventas/campo-calendario.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 159, 171), 3));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtImporte.setBorder(null);
        txtImporte.setForeground(new java.awt.Color(58, 159, 171));
        txtImporte.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtImporte.setPlaceholder("IMPORTE");
        txtImporte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtImporteKeyTyped(evt);
            }
        });
        jPanel8.add(txtImporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 110, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventas/campo-importe.png"))); // NOI18N
        jPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 180, -1));

        txtCambio.setEditable(false);
        txtCambio.setBorder(null);
        txtCambio.setForeground(new java.awt.Color(58, 159, 171));
        txtCambio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCambio.setPlaceholder("CAMBIO");
        txtCambio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCambioKeyTyped(evt);
            }
        });
        jPanel8.add(txtCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 110, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventas/campo-cambio.png"))); // NOI18N
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 180, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 159, 171), 3));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtRemitente.setBackground(new java.awt.Color(204, 204, 204));
        txtRemitente.setBorder(null);
        txtRemitente.setForeground(new java.awt.Color(58, 159, 171));
        txtRemitente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtRemitente.setPlaceholder("REMITENTE:");
        jPanel4.add(txtRemitente, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 260, 30));

        txtBeneficiario.setBackground(new java.awt.Color(204, 204, 204));
        txtBeneficiario.setBorder(null);
        txtBeneficiario.setForeground(new java.awt.Color(58, 159, 171));
        txtBeneficiario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtBeneficiario.setPlaceholder("BENEFICIARIO:");
        jPanel4.add(txtBeneficiario, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 260, 30));

        txtA.setBackground(new java.awt.Color(204, 204, 204));
        txtA.setBorder(null);
        txtA.setForeground(new java.awt.Color(58, 159, 171));
        txtA.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtA.setPlaceholder("A:");
        jPanel4.add(txtA, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 140, 30));

        txtDniRemitente.setBackground(new java.awt.Color(204, 204, 204));
        txtDniRemitente.setBorder(null);
        txtDniRemitente.setForeground(new java.awt.Color(58, 159, 171));
        txtDniRemitente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDniRemitente.setPlaceholder("DNI/REMITENTE:");
        txtDniRemitente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDniRemitenteKeyPressed(evt);
            }
        });
        jPanel4.add(txtDniRemitente, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 100, 30));

        txtDe.setBackground(new java.awt.Color(204, 204, 204));
        txtDe.setBorder(null);
        txtDe.setForeground(new java.awt.Color(58, 159, 171));
        txtDe.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDe.setPlaceholder("DE:");
        jPanel4.add(txtDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 30));

        txtRucRemitente.setBackground(new java.awt.Color(204, 204, 204));
        txtRucRemitente.setBorder(null);
        txtRucRemitente.setForeground(new java.awt.Color(58, 159, 171));
        txtRucRemitente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtRucRemitente.setPlaceholder("RUC/REMITENTE:");
        jPanel4.add(txtRucRemitente, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 140, 30));

        txtPrecioUnit.setBackground(new java.awt.Color(204, 204, 204));
        txtPrecioUnit.setBorder(null);
        txtPrecioUnit.setForeground(new java.awt.Color(58, 159, 171));
        txtPrecioUnit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPrecioUnit.setPlaceholder("PRECIO UNIT:");
        jPanel4.add(txtPrecioUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 110, 30));

        txtCelularRemitente.setBackground(new java.awt.Color(204, 204, 204));
        txtCelularRemitente.setBorder(null);
        txtCelularRemitente.setForeground(new java.awt.Color(58, 159, 171));
        txtCelularRemitente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCelularRemitente.setPlaceholder("CELULAR/REMITENTE:");
        jPanel4.add(txtCelularRemitente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 130, 30));

        txtDniBeneficiario.setBackground(new java.awt.Color(204, 204, 204));
        txtDniBeneficiario.setBorder(null);
        txtDniBeneficiario.setForeground(new java.awt.Color(58, 159, 171));
        txtDniBeneficiario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDniBeneficiario.setPlaceholder("DNI/BENEFICIARIO:");
        txtDniBeneficiario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDniBeneficiarioKeyPressed(evt);
            }
        });
        jPanel4.add(txtDniBeneficiario, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 100, 30));

        txtCorreoEnvios.setBackground(new java.awt.Color(204, 204, 204));
        txtCorreoEnvios.setBorder(null);
        txtCorreoEnvios.setForeground(new java.awt.Color(58, 159, 171));
        txtCorreoEnvios.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCorreoEnvios.setPlaceholder("CORREO:");
        jPanel4.add(txtCorreoEnvios, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 220, 30));

        txtDireccionBeneficiario.setBackground(new java.awt.Color(204, 204, 204));
        txtDireccionBeneficiario.setBorder(null);
        txtDireccionBeneficiario.setForeground(new java.awt.Color(58, 159, 171));
        txtDireccionBeneficiario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDireccionBeneficiario.setPlaceholder("DIRECCION:");
        jPanel4.add(txtDireccionBeneficiario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 270, 30));

        txtCelularBeneficiario.setBackground(new java.awt.Color(204, 204, 204));
        txtCelularBeneficiario.setBorder(null);
        txtCelularBeneficiario.setForeground(new java.awt.Color(58, 159, 171));
        txtCelularBeneficiario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCelularBeneficiario.setPlaceholder("CELULAR/BENEFICIARIO:");
        jPanel4.add(txtCelularBeneficiario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 150, 30));

        txtCantidad.setBackground(new java.awt.Color(204, 204, 204));
        txtCantidad.setBorder(null);
        txtCantidad.setForeground(new java.awt.Color(58, 159, 171));
        txtCantidad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCantidad.setPlaceholder("CANTIDAD:");
        jPanel4.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 150, 30));

        txtDiceContener.setBackground(new java.awt.Color(204, 204, 204));
        txtDiceContener.setBorder(null);
        txtDiceContener.setForeground(new java.awt.Color(58, 159, 171));
        txtDiceContener.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDiceContener.setPlaceholder("CONTENIDO:");
        jPanel4.add(txtDiceContener, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 270, 30));

        txtClaveEnvio.setBackground(new java.awt.Color(204, 204, 204));
        txtClaveEnvio.setBorder(null);
        txtClaveEnvio.setForeground(new java.awt.Color(58, 159, 171));
        txtClaveEnvio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtClaveEnvio.setPlaceholder("CLAVE:");
        jPanel4.add(txtClaveEnvio, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 70, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(58, 159, 171));
        jLabel7.setText("S/:");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, 30, 30));

        jPanel7.setBackground(new java.awt.Color(58, 159, 171));

        JTBLEncomiendas.setBackground(new java.awt.Color(0, 0, 0));
        JTBLEncomiendas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        JTBLEncomiendas.setForeground(new java.awt.Color(255, 255, 255));
        JTBLEncomiendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CANTIDAD", "DICE CONTENER", "S/: PRECIO UNIT", "IMPORTE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTBLEncomiendas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JTBLEncomiendas.setDoubleBuffered(true);
        JTBLEncomiendas.setRowHeight(20);
        JTBLEncomiendas.setSelectionBackground(new java.awt.Color(0, 153, 255));
        JTBLEncomiendas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(JTBLEncomiendas);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("TOTAL A PAGAR: $");

        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(255, 255, 255));
        txtTotal.setText("0.0");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder2 = new org.jdesktop.swingx.border.DropShadowBorder();
        jPanel6.setBorder(dropShadowBorder2);

        btnCancelar.setBackground(new java.awt.Color(58, 159, 171));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("CANCELAR");
        btnCancelar.setToolTipText("<html> <head> <style> #contenedor{background:white;color:black; padding-left:10px;padding-right:10px;margin:0; padding-top:5px;padding-bottom:5px;} </style> </head> <body> <h4 id=\"contenedor\">Canclar la ventar</h4> </body> </html>");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCancelar.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnRegistrarEnvio.setBackground(new java.awt.Color(58, 159, 171));
        btnRegistrarEnvio.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarEnvio.setText("Registrar Envio");
        btnRegistrarEnvio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegistrarEnvio.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnRegistrarEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarEnvioActionPerformed(evt);
            }
        });

        quitar.setBackground(new java.awt.Color(58, 159, 171));
        quitar.setForeground(new java.awt.Color(255, 255, 255));
        quitar.setText("QUITAR");
        quitar.setToolTipText("<html> <head> <style> #contenedor{background:#3A9FAB;color:white; padding-left:10px;padding-right:10px;margin:0; padding-top:5px;padding-bottom:5px;} </style> </head> <body> <h4 id=\"contenedor\">Quitar</h4> </body> </html>");
        quitar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        quitar.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        quitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitarActionPerformed(evt);
            }
        });

        btnImprimir.setBackground(new java.awt.Color(58, 159, 171));
        btnImprimir.setForeground(new java.awt.Color(255, 255, 255));
        btnImprimir.setText("IMPRIMIR");
        btnImprimir.setToolTipText("<html> <head> <style> #contenedor{background:white;color:black; padding-left:10px;padding-right:10px;margin:0; padding-top:5px;padding-bottom:5px;} </style> </head> <body> <h4 id=\"contenedor\">Canclar la ventar</h4> </body> </html>");
        btnImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnImprimir.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistrarEnvio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(quitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrarEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quitar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
    
        this.dispose();
    }//GEN-LAST:event_cerrarActionPerformed

    private void txtImporteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImporteKeyTyped
        char num = evt.getKeyChar();
        if ((num < '0' || num > '9')) {
            evt.consume();
        }
        if ((num == KeyEvent.VK_ENTER)) {
            if (this.txtImporte.getText().equals("")) {
                ErrorAlert er = new ErrorAlert(new JFrame(), true);
                er.titulo.setText("OOPS...");
                er.msj.setText("DEBES INGRESAR UNA");
                er.msj1.setText("CANTIDAD");
                er.setVisible(true);
            } else {
                double recibe = Double.parseDouble(txtImporte.getText());
                double total = Double.parseDouble(txtTotal.getText());

                if (total > 0.0) {
                    if (recibe > total) {
                        this.txtCambio.setText(String.valueOf(recibe - total));
                    } else {
                        ErrorAlert er = new ErrorAlert(new JFrame(), true);
                        er.titulo.setText("OOPS...");
                        er.msj.setText("INGRESA UNA CANTIDAD");
                        er.msj1.setText("VALIDA");
                        er.setVisible(true);
                    }
                } else {
                    ErrorAlert er = new ErrorAlert(new JFrame(), true);
                    er.titulo.setText("OOPS...");
                    er.msj.setText("IMPOSIBLE REALIZAR");
                    er.msj1.setText("LA OPERACIÓN");
                    er.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_txtImporteKeyTyped

    private void txtCambioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCambioKeyTyped
        char num = evt.getKeyChar();
        if ((num < '0' || num > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCambioKeyTyped
//new ventas.Productos(new JFrame(), true).setVisible(true);
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiaCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegistrarEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarEnvioActionPerformed
        guardar_envio();
        if(!"".equals(txtDniRemitente.getText())){
            guardar_cliente_enviorem();
            
        }else{
            System.out.print("no estaba seleccionado!");
        }
        if(!"".equals(txtBeneficiario.getText())){
            guardar_cliente_enviobene();
        }else{
            System.out.print("no estaba seleccionado!");
        }
        
    }//GEN-LAST:event_btnRegistrarEnvioActionPerformed

    private void quitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) this.JTBLEncomiendas.getModel();
        if (modelo.getRowCount() > 0) {
            if (this.JTBLEncomiendas.getSelectedRowCount() < 1) {
                ErrorAlert er = new ErrorAlert(new JFrame(), true);
                er.titulo.setText("OOPS...");
                er.msj.setText("SELECCIONA UN");
                er.msj1.setText("REGISTRO");
                er.setVisible(true);
            } else {
                modelo=(DefaultTableModel) JTBLEncomiendas.getModel();
        modelo.removeRow(JTBLEncomiendas.getSelectedRow());
        totalpagar();
        txtDiceContener.requestFocus();
            }
        }
    }//GEN-LAST:event_quitarActionPerformed

    private void txtDniRemitenteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniRemitenteKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            if(!"".equals(txtDniRemitente.getText())){
                String dni=txtDniRemitente.getText();
                Cliente clien=clctd.verificarCli(dni);
                if(clien.getNombre()!=null){
                    txtRemitente.setText(""+clien.getNombre());
                }else{
                    txtRemitente.setText(""+clien.getNombre());
                    txtRemitente.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_txtDniRemitenteKeyPressed

    private void txtDniBeneficiarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniBeneficiarioKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            if(!"".equals(txtDniBeneficiario.getText())){
                String dni=txtDniBeneficiario.getText();
                Cliente clien=clctd.verificarCli(dni);
                if(clien.getNombre()!=null){
                    txtBeneficiario.setText(""+clien.getNombre());
                }else{
                    txtBeneficiario.setText(""+clien.getNombre());
                    txtBeneficiario.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_txtDniBeneficiarioKeyPressed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        SuccessAlert sa = new SuccessAlert(new JFrame(), true);
        sa.titulo.setText("¡HECHO!");
        sa.msj.setText("SE HA GENERADO LA");
        sa.msj1.setText("BOLETA DE ENVIO");
        sa.setVisible(true);
        pdfEnvios();
    }//GEN-LAST:event_btnImprimirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable JTBLEncomiendas;
    private principal.MaterialButton btnCancelar;
    private principal.MaterialButton btnImprimir;
    private principal.MaterialButton btnRegistrarEnvio;
    private principal.MaterialButton cerrar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private principal.MaterialButton quitar;
    private app.bolivia.swing.JCTextField txtA;
    private app.bolivia.swing.JCTextField txtBeneficiario;
    public static app.bolivia.swing.JCTextField txtCambio;
    private app.bolivia.swing.JCTextField txtCantidad;
    private app.bolivia.swing.JCTextField txtCelularBeneficiario;
    private app.bolivia.swing.JCTextField txtCelularRemitente;
    private app.bolivia.swing.JCTextField txtClaveEnvio;
    private app.bolivia.swing.JCTextField txtCorreoEnvios;
    private app.bolivia.swing.JCTextField txtDe;
    private app.bolivia.swing.JCTextField txtDiceContener;
    private app.bolivia.swing.JCTextField txtDireccionBeneficiario;
    private app.bolivia.swing.JCTextField txtDniBeneficiario;
    private app.bolivia.swing.JCTextField txtDniRemitente;
    private app.bolivia.swing.JCTextField txtFecha;
    public static app.bolivia.swing.JCTextField txtImporte;
    private app.bolivia.swing.JCTextField txtPrecioUnit;
    private app.bolivia.swing.JCTextField txtRemitente;
    private app.bolivia.swing.JCTextField txtRucRemitente;
    public static javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables

    

    void limpiaCampos() {
        DefaultTableModel modelo = (DefaultTableModel) JTBLEncomiendas.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        txtDe.setText("");
        txtA.setText("");
        txtDniBeneficiario.setText("");
        txtDniRemitente.setText("");
        txtBeneficiario.setText("");
        txtRemitente.setText("");
        txtClaveEnvio.setText("");
        txtCelularBeneficiario.setText("");
        txtCelularRemitente.setText("");
        txtCantidad.setText("");
        txtDireccionBeneficiario.setText("");
        txtDiceContener.setText("");
        txtTotal.setText("");
        txtPrecioUnit.setText("");
        txtDniRemitente.requestFocus();

    }
    double totalpagar=0;
    private void totalpagar(){
        totalpagar=0.00;
        int numfila=JTBLEncomiendas.getRowCount();
        for (int i = 0; i < numfila; i++) {
            double cal=Double.parseDouble(String.valueOf(JTBLEncomiendas.getModel().getValueAt(i,2)));
            totalpagar=totalpagar+cal;
        }
        txtTotal.setText(String.valueOf(totalpagar));
    }
    private void agregar_tabla_envios(){
        if(!"".equals(txtDiceContener.getText())){
                String cantidad= txtCantidad.getText();
                String dicecontener=txtDiceContener.getText();
                double precioUnit=Double.parseDouble(txtPrecioUnit.getText());
                String importe = txtImporte.getText();
                modelo = (DefaultTableModel) JTBLEncomiendas.getModel();
                for (int i=0;i< JTBLEncomiendas.getRowCount();i++) {
                    if(JTBLEncomiendas.getValueAt(i,1).equals(txtDiceContener.getText())){
                        JOptionPane.showMessageDialog(null, "no se puede repetir el mismo nombre de envio");
                        return;
                        
                    }
                }
                ArrayList lista=new ArrayList();
                lista.add(cantidad);
                lista.add(dicecontener);
                lista.add(precioUnit);
                lista.add(importe);
                Object[] obj=new Object[4];
                obj[0]=lista.get(0);
                obj[1]=lista.get(1);
                obj[2]=lista.get(2);
                obj[3]=lista.get(3);
                modelo.addRow(obj);
                JTBLEncomiendas.setModel(modelo);
                totalpagar();
            }else{
                JOptionPane.showMessageDialog(null, "ingrese contenido");
            }
    }
    private void pdfEnvios(){
        try {
            Date date=new Date();
            /**variables esternas*/
            int id=enctd.extraerID();
            
            /*convertir numero a letras*/
            
            
            /*comienzo del pdf*/
            FileOutputStream archivo;
            File file=new File("GHBUS/RECIBOS/Encomienda_"+id+".pdf");
            archivo= new FileOutputStream(file);
            Document doc= new Document();
                PdfWriter.getInstance(doc,archivo);
                doc.open();
//                Image img= Image.getInstance("/src/imgenes/logo.png");
                Paragraph fecha= new Paragraph();
                Font negrita= new Font(Font.FontFamily.TIMES_ROMAN,11,Font.BOLD,BaseColor.BLUE);
                fecha.add(Chunk.NEWLINE);
                
                fecha.add("FACTURA: \n"+"FECHA: "+new SimpleDateFormat("d/MM/yyyy").format(date)+"\n\n");
                PdfPTable Encabezado=new PdfPTable(3);
                Encabezado.setWidthPercentage(100);
                Encabezado.getDefaultCell().setBorder(0);
                float[] ColumnaEncabezado=new float[]{140f,10f,60f};
                Encabezado.setWidths(ColumnaEncabezado);
                Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
                if(id<=9){
                    Encabezado.addCell("RECIBO: N°00"+id+"\nGHBUS EMPRESA DE TRANSPORTES GRUPO HORNA\nPARA TRANSPORTE DE CARGA Y ENCOMIENDA.");
                }else{
                    Encabezado.addCell("RECIBO: N°0"+id+"\nGHBUS EMPRESA DE TRANSPORTES GRUPO HORNA\nPARA TRANSPORTE DE CARGA Y ENCOMIENDA.");
                }
                
                Encabezado.addCell("");
                Encabezado.addCell(fecha);
                doc.add(Encabezado);
                /*FIN DE ENCABEZADO*/
                Paragraph bole=new Paragraph();
                bole.add(Chunk.NEWLINE);
                bole.add("\n\n");
                doc.add(bole);
                /*-----CUADRO1-------*/
                PdfPTable fila1=new PdfPTable(3);
                fila1.setWidthPercentage(100);
                fila1.getDefaultCell().setBorder(0);
                float[] ColumnaFila1=new float[]{80f,80F,80f};
                fila1.setWidths(ColumnaFila1);
                fila1.setHorizontalAlignment(Element.ALIGN_CENTER);
                fila1.addCell("\nDESTINO: "+txtDe.getText().toUpperCase());
                fila1.addCell("\nA: "+txtA.getText().toUpperCase()+"\n\n");
                fila1.addCell("\nFECHA: "+new SimpleDateFormat("dd/MMM").format(date).toUpperCase()+"\n\n");
                doc.add(fila1);
                /*-----CUADRO2-------*/
                PdfPTable fila2=new PdfPTable(3);
                fila2.setWidthPercentage(100);
                fila2.getDefaultCell().setBorder(0);
                float[] ColumnaFila2=new float[]{70f,30,50f};
                fila2.setWidths(ColumnaFila2);
                fila2.setHorizontalAlignment(Element.ALIGN_CENTER);
                fila2.addCell("\n\n"+"REMITENTE: "+txtRemitente.getText().toUpperCase()+"\n\n");
                fila2.addCell("\n\n"+"DNI: "+txtDniRemitente.getText()+"\n\n");
                fila2.addCell("\n\n"+"CELULAR: "+txtCelularRemitente.getText()+"\n\n");
                doc.add(fila2);
                /*remitente*/
                PdfPTable filaruc=new PdfPTable(1);
                filaruc.setWidthPercentage(100);
                filaruc.getDefaultCell().setBorder(0);
                float[] ColumnaFilaruc=new float[]{100f};
                filaruc.setWidths(ColumnaFilaruc);
                filaruc.setHorizontalAlignment(Element.ALIGN_CENTER);
                filaruc.addCell("\n"+"RUC DEL REMITENTE: "+txtRucRemitente.getText());
                doc.add(filaruc);
                /*-----CUADRO3-------*/
                PdfPTable fila3=new PdfPTable(3);
                fila3.setWidthPercentage(100);
                fila3.getDefaultCell().setBorder(0);
                float[] ColumnaFila3=new float[]{70f,30f,50f};
                fila3.setWidths(ColumnaFila3);
                fila3.setHorizontalAlignment(Element.ALIGN_CENTER);
                fila3.addCell("\nBENEFICIARIO: "+txtBeneficiario.getText().toUpperCase()+"\n\n");
                fila3.addCell("\nDNI: "+txtDniBeneficiario.getText()+"\n\n");
                fila3.addCell("\nCELULAR: "+txtCelularBeneficiario.getText()+"\n\n");
                doc.add(fila3);
                /*direccion*/
                PdfPTable filadire=new PdfPTable(1);
                filadire.setWidthPercentage(100);
                filadire.getDefaultCell().setBorder(0);
                float[] ColumnaFiladire=new float[]{100f};
                filadire.setWidths(ColumnaFiladire);
                filadire.setHorizontalAlignment(Element.ALIGN_CENTER);
                filadire.addCell("DIRECCION: "+txtDireccionBeneficiario.getText().toUpperCase());
                doc.add(filadire);
                /*correo*/
                PdfPTable filacorreo=new PdfPTable(1);
                filacorreo.setWidthPercentage(100);
                filacorreo.getDefaultCell().setBorder(0);
                float[] ColumnaFilacorreo=new float[]{100f};
                filacorreo.setWidths(ColumnaFilacorreo);
                filacorreo.setHorizontalAlignment(Element.ALIGN_CENTER);
                filacorreo.addCell("CORREO: "+txtCorreoEnvios.getText().toUpperCase());
                doc.add(filacorreo);
                /*separador*/
                Paragraph sepa=new Paragraph();
                sepa.add(Chunk.NEWLINE);
                sepa.add("\n\n");
                doc.add(sepa);
                /*cuadro*/
                /*-----CUADRO1-------*/
                PdfPTable tablaenvio=new PdfPTable(4);
                tablaenvio.setWidthPercentage(100);
                tablaenvio.getDefaultCell().setBorder(7|Rectangle.OUT_BOTTOM| Rectangle.OUT_RIGHT);
                float[] Columnatablaenvio=new float[]{25f,25f,25f,25f};
                tablaenvio.setWidths(Columnatablaenvio);
                tablaenvio.setHorizontalAlignment(Element.ALIGN_CENTER);
                PdfPCell envio1=new PdfPCell(new Phrase("\n\nCANTIDAD.\n\n"));
                PdfPCell envio2=new PdfPCell(new Phrase("\n\nDICE CONTENER.\n\n"));
                PdfPCell envio3=new PdfPCell(new Phrase("\n\nPRECIO UNIT.\n\n"));
                PdfPCell envio4=new PdfPCell(new Phrase("\n\nIMPORTE\n\n"));
                envio1.setBorder(7|Rectangle.OUT_BOTTOM| Rectangle.OUT_RIGHT);
                envio2.setBorder(7|Rectangle.OUT_BOTTOM| Rectangle.OUT_RIGHT);
                envio3.setBorder(7|Rectangle.OUT_BOTTOM| Rectangle.OUT_RIGHT);
                envio4.setBorder(7|Rectangle.OUT_BOTTOM| Rectangle.OUT_RIGHT);
                tablaenvio.addCell(envio1);
                tablaenvio.addCell(envio2);
                tablaenvio.addCell(envio3);
                tablaenvio.addCell(envio4);
                for (int i = 0; i < JTBLEncomiendas.getRowCount(); i++) {
                    String cantidad=JTBLEncomiendas.getValueAt(i, 0).toString();
                    String contenido=JTBLEncomiendas.getValueAt(i, 1).toString();
                    String precio=JTBLEncomiendas.getValueAt(i, 2).toString();
                    String importe=JTBLEncomiendas.getValueAt(i, 3).toString();
                        tablaenvio.addCell("\n"+cantidad+"\n");
                        tablaenvio.addCell("\n"+contenido+"\n");
                        tablaenvio.addCell("\n"+precio+"\n");
                        tablaenvio.addCell("\n"+importe+"\n");
                        
                }
                doc.add(tablaenvio);
                /*vacio*/
                PdfPTable fila0=new PdfPTable(4);
                fila0.setWidthPercentage(100);
                fila0.getDefaultCell().setBorder(7|Rectangle.OUT_BOTTOM| Rectangle.OUT_RIGHT);
                float[] ColumnaFila0=new float[]{25f,25f,25f,25f};
                fila0.setWidths(ColumnaFila0);
                fila0.setHorizontalAlignment(Element.ALIGN_CENTER);
                fila0.addCell("\n");
                fila0.addCell("\n");
                fila0.addCell("\n");
                fila0.addCell("\n");
                doc.add(fila0);
                //tabla10
                PdfPTable fila10=new PdfPTable(4);
                fila10.setWidthPercentage(100);
                fila10.getDefaultCell().setBorder(7|Rectangle.OUT_BOTTOM| Rectangle.OUT_RIGHT);
                float[] ColumnaFila10=new float[]{25f,25f,25f,25f};
                fila10.setWidths(ColumnaFila10);
                fila10.setHorizontalAlignment(Element.ALIGN_CENTER);
                fila10.addCell("");
                fila10.addCell(txtA.getText());
                fila10.addCell("");
                fila10.addCell("");
                doc.add(fila10);
                //tabla10
                PdfPTable fila11=new PdfPTable(4);
                fila11.setWidthPercentage(100);
                fila11.getDefaultCell().setBorder(7|Rectangle.OUT_BOTTOM| Rectangle.OUT_RIGHT);
                float[] ColumnaFila11=new float[]{25f,25f,25f,25f};
                fila11.setWidths(ColumnaFila11);
                fila11.setHorizontalAlignment(Element.ALIGN_CENTER);
                fila11.addCell("");
                fila11.addCell("CLAVE: "+txtClaveEnvio.getText());
                fila11.addCell("");
                fila11.addCell("");
                doc.add(fila11);
                //tabla10
                PdfPTable fila12=new PdfPTable(4);
                fila12.setWidthPercentage(100);
                fila12.getDefaultCell().setBorder(7|Rectangle.OUT_BOTTOM| Rectangle.OUT_RIGHT);
                float[] ColumnaFila12=new float[]{25f,25f,25f,25f};
                fila12.setWidths(ColumnaFila12);
                fila12.setHorizontalAlignment(Element.ALIGN_CENTER);
                fila12.addCell("");
                fila12.addCell("TOTAL: S/.");
                fila12.addCell(txtTotal.getText());
                fila12.addCell("");
                doc.add(fila12);
                //tabla10
                PdfPTable fila13=new PdfPTable(3);
                fila13.setWidthPercentage(100);
                fila13.getDefaultCell().setBorder(7|Rectangle.OUT_BOTTOM| Rectangle.OUT_RIGHT);
                float[] ColumnaFila13=new float[]{50f,25f,25f};
                fila13.setWidths(ColumnaFila13);
                fila13.setHorizontalAlignment(Element.ALIGN_CENTER);
                fila13.addCell("El cliente sertifica que no envia dinero ni especies valoradas.");
                fila13.addCell("TOTAL: S/.");
                fila13.addCell("");
                doc.add(fila13);
                /**/
                doc.close();
                archivo.close();
                Desktop.getDesktop().open(file);
        } catch (DocumentException | FileNotFoundException ex) {
            Logger.getLogger(ModalCorteDia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ModalCorteDia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
