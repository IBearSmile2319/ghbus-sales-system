/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import Controlador.BoletoCTD;
import Controlador.ClientesCTD;
import Modelo.Boleto;
import Modelo.Cliente;
import alertas.principal.AWTUtilities;
import alertas.principal.ErrorAlert;
import alertas.principal.SuccessAlert;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import tabla.EstiloTablaHeader;
import tabla.EstiloTablaRenderer;
import tabla.MyScrollbarUI;
import Controlador.Numero_a_Letra;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Frame;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ModalCorteDia extends javax.swing.JDialog {
    Numero_a_Letra nl=new Numero_a_Letra();
    /*BOLETO*/
    Boleto bl=new Boleto();
    BoletoCTD blctd=new BoletoCTD();
    /*CLIENTE*/
    Cliente cl=new Cliente();
    ClientesCTD clctd=new ClientesCTD();
    Timer timer = null;
    TimerTask task;
    int i = 32;
    public ModalCorteDia(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        AWTUtilities.setOpaque(this, false);
        this.lblid.setVisible(false);

    }
    /*BOLETO GET AND POST*/
    public void guardar_modificar_boleto(){
      
            int año,mes,dia;
            año=CFV.getCalendar().get(Calendar.YEAR);
            mes=CFV.getCalendar().get(Calendar.MONTH)+1;
            dia=CFV.getCalendar().get(Calendar.DAY_OF_MONTH);
            String fechaViaje=año+"-"+mes+"-"+dia;
            /*convertir numeno a letas*/
            int numero=0;
            numero=(int)Double.parseDouble(lblvalor_venta.getText());
            String letras=nl.Convertir(String.valueOf(numero), true);
            /*base de datos*/
            if(!"".equals(lblnombre_razonsocial.getText())){
                bl.setNombre_razonsocial(lblnombre_razonsocial.getText().toUpperCase());
            }else{
                bl.setNombre_razonsocial("");
            }
            if(!"".equals(lblruc.getText())){
                bl.setRuc(lblruc.getText().toUpperCase());
            }else{
                bl.setRuc("");
            }
            bl.setPasajero(lblpasajero.getText().toUpperCase());
            bl.setAsiento(Integer.parseInt(lblasiento.getText()));
            bl.setOrigen(lblorigen.getText().toUpperCase());
            bl.setDestino(lbldestino.getText().toUpperCase());
            bl.setFecha_viaje(fechaViaje);
            bl.setHora_partida(lblhora_partida.getText().toUpperCase());
            bl.setDni(lbldni.getText());
            bl.setValor_venta(Double.parseDouble(lblvalor_venta.getText()));
            bl.setPrecio_total(Double.parseDouble(lblprecio_total.getText()));
            bl.setCelular(lblcelular.getText());
            if(!"".equals(lblcorreo.getText())){
                
                bl.setCorreo(lblcorreo.getText().toUpperCase());
            }else{
                bl.setCorreo("no tiene".toUpperCase());
            }
            bl.setSon(letras.toUpperCase());
            if(this.registrar.getText().equals("MODIFICAR")){
                bl.setId(Integer.parseInt(lblid.getText()));
                blctd.boleto_Put(bl);
            }else{
                blctd.boleto_Post(bl);
            }
    }
    
    /*CLIENTE GET AND POST*/
    public void guardar_cliente_boleto(){
            cl.setNombre(lblpasajero.getText().toUpperCase());
            cl.setDni(lbldni.getText());
            clctd.Registrar_cliente(cl);
    }
    public void G_V_cliente_boleto(){
        ClientesCTD cli=new ClientesCTD();
        String dniboleto=lbldni.getText();
        Cliente clienboleto=cli.verificar(dniboleto);
        if(clienboleto==null){
            guardar_cliente_boleto();
            
        }else{
            System.out.println("Ya existe el cliente");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel3 = new org.edisoncor.gui.panel.Panel();
        jPanel1 = new javax.swing.JPanel();
        cerrar = new principal.MaterialButton();
        lblid = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblnombre_razonsocial = new app.bolivia.swing.JCTextField();
        lblpasajero = new app.bolivia.swing.JCTextField();
        lblruc = new app.bolivia.swing.JCTextField();
        lblasiento = new app.bolivia.swing.JCTextField();
        lblorigen = new app.bolivia.swing.JCTextField();
        lbldestino = new app.bolivia.swing.JCTextField();
        lblhora_partida = new app.bolivia.swing.JCTextField();
        lblcelular = new app.bolivia.swing.JCTextField();
        lblcorreo = new app.bolivia.swing.JCTextField();
        lblvalor_venta = new app.bolivia.swing.JCTextField();
        lbldni = new app.bolivia.swing.JCTextField();
        CFV = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblprecio_total = new javax.swing.JLabel();
        btnGuardarSoloCliente = new principal.MaterialButton();
        btnLimpiar = new principal.MaterialButton();
        btnimprimir = new principal.MaterialButton();
        registrar = new principal.MaterialButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alertas/img/fondo.png"))); // NOI18N
        panel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(58, 159, 171));

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

        lblid.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblid.setForeground(new java.awt.Color(255, 255, 255));
        lblid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblid.setText("id");

        titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("REGISTRAR PASAJE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                .addComponent(lblid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131)
                .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblid)
                    .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 11, 633, -1));

        jPanel2.setBackground(new java.awt.Color(58, 159, 171));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("VENTA DE PASAJE:");

        lblnombre_razonsocial.setBorder(null);
        lblnombre_razonsocial.setForeground(new java.awt.Color(58, 159, 171));
        lblnombre_razonsocial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblnombre_razonsocial.setPlaceholder("NOMBRE/RAZON SOCIAL:");

        lblpasajero.setBorder(null);
        lblpasajero.setForeground(new java.awt.Color(58, 159, 171));
        lblpasajero.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblpasajero.setPlaceholder("PASAJERO:");

        lblruc.setBorder(null);
        lblruc.setForeground(new java.awt.Color(58, 159, 171));
        lblruc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblruc.setPlaceholder("RUC:");

        lblasiento.setBorder(null);
        lblasiento.setForeground(new java.awt.Color(58, 159, 171));
        lblasiento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblasiento.setPlaceholder("ACIENTO:");

        lblorigen.setBorder(null);
        lblorigen.setForeground(new java.awt.Color(58, 159, 171));
        lblorigen.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblorigen.setPlaceholder("ORIGEN:");

        lbldestino.setBorder(null);
        lbldestino.setForeground(new java.awt.Color(58, 159, 171));
        lbldestino.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbldestino.setPlaceholder("DESTINO:");

        lblhora_partida.setBorder(null);
        lblhora_partida.setForeground(new java.awt.Color(58, 159, 171));
        lblhora_partida.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblhora_partida.setPlaceholder("HORA/PARTIDA:");

        lblcelular.setBorder(null);
        lblcelular.setForeground(new java.awt.Color(58, 159, 171));
        lblcelular.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblcelular.setPlaceholder("CELULAR:");

        lblcorreo.setBorder(null);
        lblcorreo.setForeground(new java.awt.Color(58, 159, 171));
        lblcorreo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblcorreo.setPlaceholder("CORREO:");

        lblvalor_venta.setBorder(null);
        lblvalor_venta.setForeground(new java.awt.Color(58, 159, 171));
        lblvalor_venta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblvalor_venta.setPlaceholder("PRECIO:");
        lblvalor_venta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lblvalor_ventaKeyReleased(evt);
            }
        });

        lbldni.setBorder(null);
        lbldni.setForeground(new java.awt.Color(58, 159, 171));
        lbldni.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbldni.setPlaceholder("DNI:");
        lbldni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lbldniKeyPressed(evt);
            }
        });

        CFV.setDateFormatString("yyyy-MM-d");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblhora_partida, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CFV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblpasajero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                    .addComponent(lblnombre_razonsocial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblruc, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(lblorigen, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbldni, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addComponent(lbldestino, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblcorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblvalor_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(lblasiento, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblnombre_razonsocial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblruc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbldni, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblpasajero, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblorigen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbldestino, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblasiento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblvalor_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblhora_partida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(CFV, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addGap(44, 44, 44))))
        );

        CFV.getAccessibleContext().setAccessibleName("");

        panel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 610, 220));

        jPanel4.setBackground(new java.awt.Color(58, 159, 171));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("TOTAL: $");

        lblprecio_total.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblprecio_total.setForeground(new java.awt.Color(255, 255, 255));
        lblprecio_total.setText("0.0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblprecio_total, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblprecio_total, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 450, 240, 40));

        btnGuardarSoloCliente.setBackground(new java.awt.Color(58, 159, 171));
        btnGuardarSoloCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarSoloCliente.setText("GSC");
        btnGuardarSoloCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGuardarSoloCliente.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnGuardarSoloCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarSoloClienteActionPerformed(evt);
            }
        });
        panel3.add(btnGuardarSoloCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(538, 310, 100, 47));

        btnLimpiar.setBackground(new java.awt.Color(58, 159, 171));
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("limpiar");
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiar.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        panel3.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 168, 47));

        btnimprimir.setBackground(new java.awt.Color(58, 159, 171));
        btnimprimir.setForeground(new java.awt.Color(255, 255, 255));
        btnimprimir.setText("imprimir");
        btnimprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnimprimir.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirActionPerformed(evt);
            }
        });
        panel3.add(btnimprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 168, 47));

        registrar.setBackground(new java.awt.Color(58, 159, 171));
        registrar.setForeground(new java.awt.Color(255, 255, 255));
        registrar.setText("REGISTRAR");
        registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        registrar.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });
        panel3.add(registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 170, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**/
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        task = new TimerTask() {
            @Override
            public void run() {
                if (i == 352) {
                    timer.cancel();
                } else {
                    Ubicar(i);
                    i += 32;
                    Trasparencia((float) i / 352);
                }
            }
        };
        timer = new Timer();
        timer.schedule(task, 0, 2);
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        setVisible(false);
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        task = new TimerTask() {
            @Override
            public void run() {
                if (i == 0) {
                    Cerrar();
                } else {
                    Ubicar(i);
                    i -= 32;
                    Trasparencia((float) i / 352);
                }
            }
        };
        timer = new Timer();
        timer.schedule(task, 0, 2);
    }//GEN-LAST:event_cerrarActionPerformed

    private void lblvalor_ventaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblvalor_ventaKeyReleased
        lblprecio_total.setText(lblvalor_venta.getText());
    }//GEN-LAST:event_lblvalor_ventaKeyReleased

    private void btnGuardarSoloClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarSoloClienteActionPerformed
        if(!"".equals(lbldni.getText()) || !"".equals(lblpasajero.getText())){
            G_V_cliente_boleto();
            
            SuccessAlert sa = new SuccessAlert(new JFrame(), true);
            sa.titulo.setText("¡HECHO!");
            sa.msj.setText("SE HA REGISTRADO UN");
            sa.msj1.setText("NUEVO PASAJERO");
            sa.setVisible(true);
        }else{
            ErrorAlert er = new ErrorAlert(new JFrame(), true);
            er.titulo.setText("OOPS...");
            er.msj.setText("EL CAMPO DNI O PASAJERO");
            er.msj1.setText("ESTAN VACIOS");
            er.setVisible(true);
        }
        
    }//GEN-LAST:event_btnGuardarSoloClienteActionPerformed

    private void lbldniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbldniKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            if(!"".equals(lbldni.getText())){
                String dni=lbldni.getText();
                Cliente clien=clctd.verificarCli(dni);
                if(clien.getNombre()!=null){
                    lblpasajero.setText(""+clien.getNombre());
                }else{
                    lblpasajero.setText("");
                    lblpasajero.requestFocus();
                }
            }else{
                System.out.println("no ingreso el codigo");
                lblpasajero.setText("");
                lbldni.requestFocus();
            }
        }
    }//GEN-LAST:event_lbldniKeyPressed

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        if(!"".equals(lblpasajero.getText()) && !"".equals(lblorigen.getText())&& !"".equals(lbldestino.getText())&& !"".equals(lblhora_partida.getText())&& !"".equals(lbldni.getText())&&!"".equals(lblvalor_venta.getText())){
            if (this.registrar.getText().equals("MODIFICAR")){
                guardar_modificar_boleto();
                guardar_cliente_boleto();
                
                blctd.listarBoletos("");
                SuccessAlert sa = new SuccessAlert(new JFrame(), true);
                    sa.titulo.setText("¡HECHO!");
                    sa.msj.setText("SE HA MODIFICADO");
                    sa.msj1.setText("UN PASAJERO");
                    sa.setVisible(true);
            }else{
                guardar_modificar_boleto();
                guardar_cliente_boleto();
                
                blctd.listarBoletos("");
                SuccessAlert sa = new SuccessAlert(new JFrame(), true);
                sa.titulo.setText("¡HECHO!");
                sa.msj.setText("SE HA REGISTRADO UN");
                sa.msj1.setText("NUEVO PASAJERO");
                sa.setVisible(true);
                pdfRecibo();
            }
            
        }else{
            ErrorAlert er = new ErrorAlert(new JFrame(), true);
            er.titulo.setText("OOPS...");
            er.msj.setText("LOS CAMPOS ESTAN VACIOS");
            er.msj1.setText("");
            er.setVisible(true);
        }
    }//GEN-LAST:event_registrarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
        
        SuccessAlert sa = new SuccessAlert(new JFrame(), true);
        sa.titulo.setText("¡HECHO!");
        sa.msj.setText("SE HA CREADO EL EL PDF");
        sa.msj1.setText("DEL NUEVO BOLETO");
        sa.setVisible(true);
        pdfRecibo();
    }//GEN-LAST:event_btnimprimirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ModalCorteDia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModalCorteDia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModalCorteDia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModalCorteDia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModalCorteDia dialog = new ModalCorteDia(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public com.toedter.calendar.JDateChooser CFV;
    private principal.MaterialButton btnGuardarSoloCliente;
    private principal.MaterialButton btnLimpiar;
    private principal.MaterialButton btnimprimir;
    private principal.MaterialButton cerrar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    public static app.bolivia.swing.JCTextField lblasiento;
    public static app.bolivia.swing.JCTextField lblcelular;
    public static app.bolivia.swing.JCTextField lblcorreo;
    public static app.bolivia.swing.JCTextField lbldestino;
    public static app.bolivia.swing.JCTextField lbldni;
    public static app.bolivia.swing.JCTextField lblhora_partida;
    public static javax.swing.JLabel lblid;
    public static app.bolivia.swing.JCTextField lblnombre_razonsocial;
    public static app.bolivia.swing.JCTextField lblorigen;
    public static app.bolivia.swing.JCTextField lblpasajero;
    public static javax.swing.JLabel lblprecio_total;
    public static app.bolivia.swing.JCTextField lblruc;
    public static app.bolivia.swing.JCTextField lblvalor_venta;
    private org.edisoncor.gui.panel.Panel panel3;
    public static principal.MaterialButton registrar;
    public static javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables

    private void Cerrar() {
        this.dispose();
        timer = null;
        task = null;
    }

    private void Trasparencia(float trasp) {
        AWTUtilities.setOpacity(this, trasp);
    }

    private void Ubicar(int y) {
        this.setLocation(590, y - 260);
    }
    private void pdfRecibo(){
        try {
            /**variables esternas*/
            int año,mes,dia;
            año=CFV.getCalendar().get(Calendar.YEAR);
            mes=CFV.getCalendar().get(Calendar.MONTH)+1;
            dia=CFV.getCalendar().get(Calendar.DAY_OF_MONTH);
            String fechaViaje;
            if(mes<=9){
                fechaViaje=año+"-0"+mes+"-"+dia;
            }else{
                fechaViaje=año+"-"+mes+"-"+dia;
            }
            
            /*convertir numero a letras*/
            int numero=0;
            numero=(int)Double.parseDouble(lblvalor_venta.getText());
            String letras=nl.Convertir(String.valueOf(numero), true);
            //variable 
            int id=1;
            if (this.registrar.getText().equals("MODIFICAR")){
                id=Integer.parseInt(lblid.getText());
            }else{
                id=blctd.IdBoleto();
            }
            
            /*comienzo del pdf*/
            FileOutputStream archivo;
            File file=new File("src/pdf/boleto"+id+".pdf");
            archivo= new FileOutputStream(file);
            Document doc= new Document();
                PdfWriter.getInstance(doc,archivo);
                doc.open();
//                Image img= Image.getInstance("/src/imgenes/logo.png");
                Paragraph fecha= new Paragraph();
                Font negrita= new Font(Font.FontFamily.TIMES_ROMAN,11,Font.BOLD,BaseColor.BLUE);
                fecha.add(Chunk.NEWLINE);
                Date date=new Date();
                fecha.add("FACTURA:"+id+" \n"+"FECHA: "+new SimpleDateFormat("d/MM/yyyy").format(date)+"\n\n");
                PdfPTable Encabezado=new PdfPTable(3);
                Encabezado.setWidthPercentage(100);
                Encabezado.getDefaultCell().setBorder(0);
                float[] ColumnaEncabezado=new float[]{140f,10f,60f};
                Encabezado.setWidths(ColumnaEncabezado);
                Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
                if(id<=9){
                    Encabezado.addCell("RECIBO: N°00"+id+"\nGHBUS EMPRESA DE TRANSPORTES GRUPO HORNA\nPARA TRANSPORTE DE PASAJEROS.");
                }else{
                    Encabezado.addCell("RECIBO: N°0"+id+"\nGHBUS EMPRESA DE TRANSPORTES GRUPO HORNA\nPARA TRANSPORTE DE PASAJEROS.");
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
                PdfPTable fila1=new PdfPTable(2);
                fila1.setWidthPercentage(100);
                fila1.getDefaultCell().setBorder(7|Rectangle.OUT_BOTTOM| Rectangle.OUT_RIGHT);
                float[] ColumnaFila1=new float[]{120f,80f};
                fila1.setWidths(ColumnaFila1);
                fila1.setHorizontalAlignment(Element.ALIGN_CENTER);
                fila1.addCell("\nNOMBRE O RAZON SOCIAL:"+lblnombre_razonsocial.getText()+"\n\n");
                fila1.addCell("\nRUC: "+lblruc.getText()+"\n\n");
                doc.add(fila1);
                /*-----CUADRO2-------*/
                PdfPTable fila2=new PdfPTable(2);
                fila2.setWidthPercentage(100);
                fila2.getDefaultCell().setBorder(7|Rectangle.OUT_BOTTOM| Rectangle.OUT_RIGHT);
                float[] ColumnaFila2=new float[]{120f,80f};
                fila2.setWidths(ColumnaFila2);
                fila2.setHorizontalAlignment(Element.ALIGN_CENTER);
                fila2.addCell("PASAJERO: "+lblpasajero.getText());
                fila2.addCell("ACIENTO: N°"+lblasiento.getText());
                doc.add(fila2);
                /*-----CUADRO3-------*/
                PdfPTable fila3=new PdfPTable(3);
                fila3.setWidthPercentage(100);
                fila3.getDefaultCell().setBorder(7|Rectangle.OUT_BOTTOM| Rectangle.OUT_RIGHT);
                float[] ColumnaFila3=new float[]{60f,60f,80f};
                fila3.setWidths(ColumnaFila3);
                fila3.setHorizontalAlignment(Element.ALIGN_CENTER);
                fila3.addCell("\nORIGEN: "+lblorigen.getText()+"\n\n");
                fila3.addCell("\nDESTINO: "+lbldestino.getText()+"\n\n");
                fila3.addCell("\nFECHA DE EXPEDICION: "+new SimpleDateFormat("dd/MMM").format(date)+"\n\n");
                doc.add(fila3);
                /*-----CUADRO4-------*/
                PdfPTable fila4=new PdfPTable(3);
                fila4.setWidthPercentage(100);
                fila4.getDefaultCell().setBorder(7|Rectangle.OUT_BOTTOM| Rectangle.OUT_RIGHT);
                float[] ColumnaFila4=new float[]{60f,60f,80f};
                fila4.setWidths(ColumnaFila4);
                fila4.setHorizontalAlignment(Element.ALIGN_CENTER);
                fila4.addCell("\nFECHA DE VIAJE: "+fechaViaje+"\n\n");
                fila4.addCell("\nHORA DE PARTIDA: "+lblhora_partida.getText()+"\n\n");
                fila4.addCell("\nVALIDO EN LA HORA Y FECHA INDICADA"+"\n\n");
                doc.add(fila4);
                /*-----CUADRO5-------*/
                PdfPTable fila5=new PdfPTable(3);
                fila5.setWidthPercentage(100);
                fila5.getDefaultCell().setBorder(7|Rectangle.OUT_BOTTOM| Rectangle.OUT_RIGHT);
                float[] ColumnaFila5=new float[]{60f,60f,80f};
                fila5.setWidths(ColumnaFila5);
                fila5.setHorizontalAlignment(Element.ALIGN_CENTER);
                fila5.addCell("\nDNI: "+lbldni.getText()+"\n\n");
                fila5.addCell("VALOR DE VENTA: S/."+lblvalor_venta.getText());
                fila5.addCell("PRECIO TOTAL: S/."+lblprecio_total.getText());
                doc.add(fila5);
                /*-----CUADRO6-------*/
                PdfPTable fila6=new PdfPTable(2);
                fila6.setWidthPercentage(100);
                fila6.getDefaultCell().setBorder(7|Rectangle.OUT_BOTTOM| Rectangle.OUT_RIGHT);
                float[] ColumnaFila6=new float[]{60f,140f};
                fila6.setWidths(ColumnaFila6);
                fila6.setHorizontalAlignment(Element.ALIGN_CENTER);
                fila6.addCell("CELULAR: "+lblcelular.getText());
                fila6.addCell("CORREO: "+lblcorreo.getText());
                doc.add(fila6);
                /*-----CUADRO7-------*/
                PdfPTable fila7=new PdfPTable(1);
                fila7.setWidthPercentage(100);
                fila7.getDefaultCell().setBorder(7|Rectangle.OUT_BOTTOM| Rectangle.OUT_RIGHT);
                float[] ColumnaFila7=new float[]{100f};
                fila7.setWidths(ColumnaFila7);
                fila7.setHorizontalAlignment(Element.ALIGN_CENTER);
                fila7.addCell("SON: "+letras);
                doc.add(fila7);
                /*separador*/
                Paragraph sepa=new Paragraph();
                sepa.add(Chunk.NEWLINE);
                sepa.add("\n\n");
                doc.add(sepa);
                PdfPTable fila0=new PdfPTable(1);
                fila0.setWidthPercentage(100);
                fila0.getDefaultCell().setBorder(7|Rectangle.OUT_BOTTOM| Rectangle.OUT_RIGHT);
                float[] ColumnaFila0=new float[]{100f};
                fila0.setWidths(ColumnaFila0);
                fila0.setHorizontalAlignment(Element.ALIGN_CENTER);
                fila0.addCell("IMPORTANTE: Todo pasajeto debe estar una hora antes de la partida.\n"
                        + "* Recibo con cargo a regularizar en la agencía.(USUARIO)");
                doc.add(fila0);

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
