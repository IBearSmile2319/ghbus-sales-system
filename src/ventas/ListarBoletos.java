
package ventas;
/*boleto */
import Modelo.Boleto;
import Controlador.BoletoCTD;
/*------*/
import alertas.principal.ErrorAlert;
import alertas.principal.SuccessAlert;
import alertas.principal.WarningAlertBSNA;
import alertas.principal.WarningAlertBSA;
import alertas.principal.WarningAlertV1;
import alertas.principal.WarningAlertV;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import tabla.EstiloTablaHeader;
import tabla.EstiloTablaRenderer;
import tabla.MyScrollbarUI;

public class ListarBoletos extends javax.swing.JInternalFrame {
    Boleto bl=new Boleto();
    BoletoCTD blctd=new BoletoCTD();
    public ListarBoletos() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        this.tabla.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
        this.tabla.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        this.tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getVerticalScrollBar().setUI(new MyScrollbarUI());
        jScrollPane1.getHorizontalScrollBar().setUI(new MyScrollbarUI());

        blctd.listarBoletos("");
        totalpagar();
        this.tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (tabla.getSelectedRow() != -1) {
                    int fila = tabla.getSelectedRow();
                }
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cerrar = new principal.MaterialButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        eliminar = new principal.MaterialButton();
        eliminarTodo = new principal.MaterialButton();
        imprimirreporte = new principal.MaterialButton();
        buscar = new app.bolivia.swing.JCTextField();
        corte = new principal.MaterialButton();
        jLabel3 = new javax.swing.JLabel();
        CanbiarEstadoAabordo = new principal.MaterialButton();
        CanbiarEstadoAnoAbordo = new principal.MaterialButton();
        modificarBoleto = new principal.MaterialButton();
        buscarfexpedicion = new app.bolivia.swing.JCTextField();
        jLabel4 = new javax.swing.JLabel();
        sacarporcentaje = new principal.MaterialButton();

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

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("COMPRA DE PASAJES");

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
                    .addGap(74, 74, 74)
                    .addComponent(jLabel2)
                    .addContainerGap(629, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel7.setBackground(new java.awt.Color(58, 159, 171));

        tabla.setBackground(new java.awt.Color(204, 204, 204));
        tabla.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tabla.setForeground(new java.awt.Color(255, 255, 255));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COD", "CORREO", "NOMBRE", "ORIGEN", "DESTINO", "ASIENTO", "F/EXPEDICION", "F/VIAJE", "HORA", "DNI", "Pre/TOTAL", "CELULAR", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabla.setDoubleBuffered(true);
        tabla.setRowHeight(20);
        tabla.setSelectionBackground(new java.awt.Color(0, 153, 255));
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("TOTAL PASAJES: $");

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(255, 255, 255));
        lblTotal.setText("0.0");

        eliminar.setBackground(new java.awt.Color(255, 255, 255));
        eliminar.setForeground(new java.awt.Color(58, 159, 171));
        eliminar.setText("ELIMINAR");
        eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        eliminar.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        eliminarTodo.setBackground(new java.awt.Color(255, 255, 255));
        eliminarTodo.setForeground(new java.awt.Color(58, 159, 171));
        eliminarTodo.setText("ELIMINAR TODO");
        eliminarTodo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        eliminarTodo.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        eliminarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarTodoActionPerformed(evt);
            }
        });

        imprimirreporte.setBackground(new java.awt.Color(255, 255, 255));
        imprimirreporte.setForeground(new java.awt.Color(58, 159, 171));
        imprimirreporte.setText("IMPRIMIR");
        imprimirreporte.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        imprimirreporte.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        imprimirreporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirreporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(eliminarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(173, 173, 173)
                .addComponent(imprimirreporte, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imprimirreporte, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        buscar.setBorder(null);
        buscar.setForeground(new java.awt.Color(58, 159, 171));
        buscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buscar.setPlaceholder("BUSCAR");
        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscarKeyTyped(evt);
            }
        });

        corte.setBackground(new java.awt.Color(58, 159, 171));
        corte.setForeground(new java.awt.Color(255, 255, 255));
        corte.setText("pasaje");
        corte.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        corte.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        corte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                corteActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/productos/campo-buscar.png"))); // NOI18N

        CanbiarEstadoAabordo.setBackground(new java.awt.Color(0, 153, 51));
        CanbiarEstadoAabordo.setForeground(new java.awt.Color(255, 255, 255));
        CanbiarEstadoAabordo.setText("ABORDO");
        CanbiarEstadoAabordo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CanbiarEstadoAabordo.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        CanbiarEstadoAabordo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CanbiarEstadoAabordoActionPerformed(evt);
            }
        });

        CanbiarEstadoAnoAbordo.setBackground(new java.awt.Color(204, 0, 0));
        CanbiarEstadoAnoAbordo.setForeground(new java.awt.Color(255, 255, 255));
        CanbiarEstadoAnoAbordo.setText("NO ABORDO");
        CanbiarEstadoAnoAbordo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CanbiarEstadoAnoAbordo.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        CanbiarEstadoAnoAbordo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CanbiarEstadoAnoAbordoActionPerformed(evt);
            }
        });

        modificarBoleto.setBackground(new java.awt.Color(58, 159, 171));
        modificarBoleto.setForeground(new java.awt.Color(255, 255, 255));
        modificarBoleto.setText("MODIFICAR");
        modificarBoleto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        modificarBoleto.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        modificarBoleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarBoletoActionPerformed(evt);
            }
        });

        buscarfexpedicion.setBorder(null);
        buscarfexpedicion.setForeground(new java.awt.Color(58, 159, 171));
        buscarfexpedicion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buscarfexpedicion.setPlaceholder("FECH. EXPEDICION");
        buscarfexpedicion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarfexpedicionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscarfexpedicionKeyTyped(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/productos/campo-buscar.png"))); // NOI18N

        sacarporcentaje.setBackground(new java.awt.Color(58, 159, 171));
        sacarporcentaje.setForeground(new java.awt.Color(255, 255, 255));
        sacarporcentaje.setText("SACAR PORCENTAJE");
        sacarporcentaje.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sacarporcentaje.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        sacarporcentaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sacarporcentajeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(buscarfexpedicion, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addComponent(sacarporcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(corte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modificarBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CanbiarEstadoAnoAbordo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(CanbiarEstadoAabordo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(corte, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CanbiarEstadoAabordo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CanbiarEstadoAnoAbordo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(modificarBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sacarporcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscarfexpedicion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_cerrarActionPerformed

    private void eliminarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarTodoActionPerformed
        if (this.tabla.getRowCount() < 1) {
            ErrorAlert er = new ErrorAlert(new JFrame(), true);
            er.titulo.setText("OOPS...");
            er.msj.setText("LA TABLA ESTA VACÍA");
            er.msj1.setText("");
            er.setVisible(true);
        } else {
            WarningAlertV1 wa = new WarningAlertV1(new JFrame(), true);
            wa.titulo.setText("¿ESTAS SEGURO?");
            wa.msj.setText("SE BORRARAN TODOS LOS");
            wa.msj1.setText("REGISTROS PERMANENTEMENTE");
            wa.setVisible(true);
        }
    }//GEN-LAST:event_eliminarTodoActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        if (this.tabla.getRowCount() < 1) {
            ErrorAlert er = new ErrorAlert(new JFrame(), true);
            er.titulo.setText("OOPS...");
            er.msj.setText("LA TABLA ESTA VACÍA");
            er.msj1.setText("");
            er.setVisible(true);
        } else {
            if (this.tabla.getSelectedRowCount() < 1) {
                ErrorAlert er = new ErrorAlert(new JFrame(), true);
                er.titulo.setText("OOPS...");
                er.msj.setText("SELECCIONA UN");
                er.msj1.setText("REGISTRO");
                er.setVisible(true);
            } else {
                int fila = this.tabla.getSelectedRow();
                WarningAlertV wa = new WarningAlertV(new JFrame(), true);
                wa.id.setText(this.tabla.getValueAt(fila, 0).toString());
                wa.titulo.setText("¿ESTAS SEGURO?");
                wa.msj.setText("SE BORRARAN TODAS LAS VENTAS");
                wa.msj1.setText("ASOCIADAS A ÉSTE CÓDIGO");
                wa.setVisible(true);
            }
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyReleased
        blctd.listarBoletos(buscar.getText());
        totalpagar();
        
    }//GEN-LAST:event_buscarKeyReleased

    private void buscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyTyped
        char letras = evt.getKeyChar();

        if (Character.isLowerCase(letras)) {
            String cad = ("" + letras).toUpperCase();
            letras = cad.charAt(0);
            evt.setKeyChar(letras);
        }
    }//GEN-LAST:event_buscarKeyTyped

    private void corteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_corteActionPerformed
        new ModalCorteDia(new JFrame(), true).setVisible(true);
    }//GEN-LAST:event_corteActionPerformed

    private void CanbiarEstadoAabordoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CanbiarEstadoAabordoActionPerformed
        if (this.tabla.getRowCount() < 1) {
            ErrorAlert er = new ErrorAlert(new JFrame(), true);
            er.titulo.setText("OOPS...");
            er.msj.setText("LA TABLA ESTA VACÍA");
            er.msj1.setText("");
            er.setVisible(true);
        } else {
            if (this.tabla.getSelectedRowCount() < 1) {
                ErrorAlert er = new ErrorAlert(new JFrame(), true);
                er.titulo.setText("OOPS...");
                er.msj.setText("SELECCIONA UN");
                er.msj1.setText("REGISTRO");
                er.setVisible(true);
            } else {
                int fila = this.tabla.getSelectedRow();
                WarningAlertBSA wa = new WarningAlertBSA(new JFrame(), true);
                wa.id.setText(this.tabla.getValueAt(fila, 0).toString());
                wa.titulo.setText("¿ESTAS SEGURO?");
                wa.msj.setText("SE CAMBIARA EL ESTADO A ABORDO");
                wa.msj1.setText("ASOCIADA A ÉSTE CÓDIGO");
                wa.setVisible(true);
            }
        }
    }//GEN-LAST:event_CanbiarEstadoAabordoActionPerformed

    private void CanbiarEstadoAnoAbordoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CanbiarEstadoAnoAbordoActionPerformed
        if (this.tabla.getRowCount() < 1) {
            ErrorAlert er = new ErrorAlert(new JFrame(), true);
            er.titulo.setText("OOPS...");
            er.msj.setText("LA TABLA ESTA VACÍA");
            er.msj1.setText("");
            er.setVisible(true);
        } else {
            if (this.tabla.getSelectedRowCount() < 1) {
                ErrorAlert er = new ErrorAlert(new JFrame(), true);
                er.titulo.setText("OOPS...");
                er.msj.setText("SELECCIONA UN");
                er.msj1.setText("REGISTRO");
                er.setVisible(true);
            } else {
                int fila = this.tabla.getSelectedRow();
                WarningAlertBSNA wa = new WarningAlertBSNA(new JFrame(), true);
                wa.id.setText(this.tabla.getValueAt(fila, 0).toString());
                wa.titulo.setText("¿ESTAS SEGURO?");
                wa.msj.setText("SE CAMBIARA EL ESTADO A NO ABORDO");
                wa.msj1.setText("ASOCIADA A ÉSTE CÓDIGO");
                wa.setVisible(true);
            }
        }
    }//GEN-LAST:event_CanbiarEstadoAnoAbordoActionPerformed

    private void modificarBoletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarBoletoActionPerformed
        if (this.tabla.getRowCount() < 1) {
            ErrorAlert er = new ErrorAlert(new JFrame(), true);
            er.titulo.setText("OOPS...");
            er.msj.setText("LA TABLA ESTA VACÍA");
            er.msj1.setText("");
            er.setVisible(true);
        } else {
            if (this.tabla.getSelectedRowCount() < 1) {
                ErrorAlert er = new ErrorAlert(new JFrame(), true);
                er.titulo.setText("OOPS...");
                er.msj.setText("SELECCIONA UN");
                er.msj1.setText("REGISTRO");
                er.setVisible(true);
            } else {
               
                try {
                    int fila = this.tabla.getSelectedRow();
                    ModalCorteDia mc = new ModalCorteDia(new JFrame(), true);
                    mc.lblid.setText(this.tabla.getValueAt(fila, 0).toString());
                    mc.lblpasajero.setText(this.tabla.getValueAt(fila, 2).toString());
                    mc.lblorigen.setText(this.tabla.getValueAt(fila, 3).toString());
                    mc.lbldestino.setText(this.tabla.getValueAt(fila, 4).toString());
                    mc.lblasiento.setText(this.tabla.getValueAt(fila, 5).toString());
                    Date date=new SimpleDateFormat("yyyy-MM-dd").parse((String)this.tabla.getValueAt(fila, 7));
                    mc.CFV.setDate(date);
                    /*....*/
                    mc.lblhora_partida.setText(this.tabla.getValueAt(fila, 8).toString());
                    mc.lbldni.setText(this.tabla.getValueAt(fila, 9).toString());
                    mc.lblvalor_venta.setText(this.tabla.getValueAt(fila, 10).toString());
                    mc.lblprecio_total.setText(this.tabla.getValueAt(fila, 10).toString());
                    mc.lblcelular.setText(this.tabla.getValueAt(fila, 11).toString());
                    mc.titulo.setText("MODIFICAR BOLETO");
                    mc.registrar.setText("MODIFICAR");
                    mc.setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(ListarBoletos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_modificarBoletoActionPerformed

    private void buscarfexpedicionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarfexpedicionKeyReleased
        blctd.listarBoletosfexpedicion(buscarfexpedicion.getText());
        totalpagar();
    }//GEN-LAST:event_buscarfexpedicionKeyReleased

    private void buscarfexpedicionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarfexpedicionKeyTyped
        char letras = evt.getKeyChar();

        if (Character.isLowerCase(letras)) {
            String cad = ("" + letras).toUpperCase();
            letras = cad.charAt(0);
            evt.setKeyChar(letras);
        }
    }//GEN-LAST:event_buscarfexpedicionKeyTyped

    private void imprimirreporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirreporteActionPerformed
        SuccessAlert sa = new SuccessAlert(new JFrame(), true);
        sa.titulo.setText("¡HECHO!");
        sa.msj.setText("SE HA REGISTRADO UN");
        sa.msj1.setText("NUEVO PASAJERO");
        sa.setVisible(true);
        pdfreportePasajeros();
    }//GEN-LAST:event_imprimirreporteActionPerformed

    private void sacarporcentajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sacarporcentajeActionPerformed
        ModaBoletoM mp = new ModaBoletoM(new JFrame(), true);
        mp.titulo.setText("SACAR GANANCIAS DEL DIA PASAJES!");
        mp.txtPrecioTotal.setText(this.lblTotal.getText());
        mp.setVisible(true);
    }//GEN-LAST:event_sacarporcentajeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private principal.MaterialButton CanbiarEstadoAabordo;
    private principal.MaterialButton CanbiarEstadoAnoAbordo;
    public static app.bolivia.swing.JCTextField buscar;
    public static app.bolivia.swing.JCTextField buscarfexpedicion;
    private principal.MaterialButton cerrar;
    private principal.MaterialButton corte;
    private principal.MaterialButton eliminar;
    private principal.MaterialButton eliminarTodo;
    private principal.MaterialButton imprimirreporte;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblTotal;
    private principal.MaterialButton modificarBoleto;
    private principal.MaterialButton sacarporcentaje;
    public static javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
    double totalpagar=0;
    private void totalpagar(){
        totalpagar=0.00;
        int numfila=tabla.getRowCount();
        for (int i = 0; i < numfila; i++) {
            double cal=Double.parseDouble(String.valueOf(tabla.getModel().getValueAt(i,10)));
            totalpagar=totalpagar+cal;
        }
        lblTotal.setText(String.valueOf(totalpagar));
    }
    private void pdfreportePasajeros(){
        try {
            String fechabusqueda=buscar.getText();
            Date date=new Date();
            /*comienzo del pdf*/
            FileOutputStream archivo;
            File file;
            if(!"".equals(fechabusqueda)){
                file=new File("GHBUS/REPORTES/ReportePasajeros"+fechabusqueda+"_"+new SimpleDateFormat("d-MM-yyyy").format(date)+".pdf");
            }else{
                file=new File("GHBUS/REPORTES/ReporteTodo_"+new SimpleDateFormat("d-MM-yyyy").format(date)+".pdf");
            }
            
            archivo= new FileOutputStream(file);
            Document doc= new Document();
                PdfWriter.getInstance(doc,archivo);
                doc.open();
//                Image img= Image.getInstance("/src/imgenes/logo.png");
                Paragraph fecha= new Paragraph();
                Font negrita= new Font(Font.FontFamily.TIMES_ROMAN,20,Font.BOLD,BaseColor.BLUE);
                fecha.add(Chunk.NEWLINE);
                
                fecha.add("REPORTE:1 \n"+"FECHA: "+new SimpleDateFormat("d/MM/yyyy").format(date)+"\n\n");
                PdfPTable Encabezado=new PdfPTable(3);
                Encabezado.setWidthPercentage(100);
                Encabezado.getDefaultCell().setBorder(0);
                float[] ColumnaEncabezado=new float[]{30f,40f,30f};
                Encabezado.setWidths(ColumnaEncabezado);
                Encabezado.setHorizontalAlignment(Element.ALIGN_CENTER);
                String enca="LISTADO DE PASAJEROS";
                Encabezado.addCell("");
                Encabezado.addCell(enca);
                Encabezado.addCell("");
                doc.add(Encabezado);
                /*FIN DE ENCABEZADO*/
                Paragraph bole=new Paragraph();
                bole.add(Chunk.NEWLINE);
                bole.add("\n\n");
                doc.add(bole);
                /*-----CUADRO1-------*/
                PdfPTable tablaboleto=new PdfPTable(7);
                tablaboleto.setWidthPercentage(100);
                tablaboleto.getDefaultCell().setBorder(7|Rectangle.OUT_BOTTOM| Rectangle.OUT_RIGHT);
                float[] Columnatablaboleto=new float[]{4f,22f,12f,13f,17f,13f,16f,};
                tablaboleto.setWidths(Columnatablaboleto);
                tablaboleto.setHorizontalAlignment(Element.ALIGN_LEFT);
                PdfPCell bole1=new PdfPCell(new Phrase("\n\n\nN°.\n\n\n"));
                PdfPCell bole2=new PdfPCell(new Phrase("\n\nNOMBRES Y\n\nAPELLIDOS.\n\n"));
                PdfPCell bole3=new PdfPCell(new Phrase("\n\n\nDNI.\n\n\n"));
                PdfPCell bole4=new PdfPCell(new Phrase("\n\n\nCELULAR.\n\n\n"));
                PdfPCell bole5=new PdfPCell(new Phrase("\nDESTINO /\n\nN°:\n\nACIENTO.\n\n"));
                PdfPCell bole6=new PdfPCell(new Phrase("\nFECHA\n\nDE\n\nVIAJE.\n"));
                PdfPCell bole7=new PdfPCell(new Phrase("\n\n\nCORREO.\n\n\n"));
                bole1.setBorder(7|Rectangle.OUT_BOTTOM| Rectangle.OUT_RIGHT);
                bole2.setBorder(7|Rectangle.OUT_BOTTOM| Rectangle.OUT_RIGHT);
                bole3.setBorder(7|Rectangle.OUT_BOTTOM| Rectangle.OUT_RIGHT);
                bole4.setBorder(7|Rectangle.OUT_BOTTOM| Rectangle.OUT_RIGHT);
                bole5.setBorder(7|Rectangle.OUT_BOTTOM| Rectangle.OUT_RIGHT);
                bole6.setBorder(7|Rectangle.OUT_BOTTOM| Rectangle.OUT_RIGHT);
                bole7.setBorder(7|Rectangle.OUT_BOTTOM| Rectangle.OUT_RIGHT);
                tablaboleto.addCell(bole1);
                tablaboleto.addCell(bole2);
                tablaboleto.addCell(bole3);
                tablaboleto.addCell(bole4);
                tablaboleto.addCell(bole5);
                tablaboleto.addCell(bole6);
                tablaboleto.addCell(bole7);
                int cant=0;
                if(!"".equals(this.buscar.getText())){
                    for (int i = 0; i < tabla.getRowCount(); i++) {
                        cant++;
                        String cantidad=String.valueOf(cant);
                        String nombeyapellido=tabla.getValueAt(i, 2).toString();
                        String dni=tabla.getValueAt(i, 9).toString();
                        String celular=tabla.getValueAt(i, 11).toString();
                        String origen=tabla.getValueAt(i, 3).toString();
                        String destino=tabla.getValueAt(i, 4).toString();
                        String asiento=tabla.getValueAt(i, 5).toString();
                        String fechaDeViaje=tabla.getValueAt(i, 7).toString();
                        String correo=tabla.getValueAt(i, 1).toString();
                        tablaboleto.addCell("\n\n"+cantidad+"\n\n");
                        tablaboleto.addCell("\n"+nombeyapellido);
                        tablaboleto.addCell("\n\n"+dni+"\n\n");
                        tablaboleto.addCell("\n\n"+celular+"\n\n");
                        tablaboleto.addCell(origen+"-\n"+destino+"\nACIENTO\nN°: "+asiento);
                        tablaboleto.addCell("\n\n"+fechaDeViaje+"\n\n");
                        tablaboleto.addCell(correo);
                        

                    }
                    doc.add(tablaboleto);
                    Paragraph sepa=new Paragraph();
                    sepa.add(Chunk.NEWLINE);
                    sepa.add("\n\nFecha:"+fechabusqueda);
                    doc.add(sepa);
                    
                    
                }else{
                    for (int i = 0; i < tabla.getRowCount(); i++) {
                        cant++;
                        String cantidad=String.valueOf(cant);
                        String nombeyapellido=tabla.getValueAt(i, 2).toString();
                        String dni=tabla.getValueAt(i, 9).toString();
                        String celular=tabla.getValueAt(i, 11).toString();
                        String origen=tabla.getValueAt(i, 3).toString();
                        String destino=tabla.getValueAt(i, 4).toString();
                        String asiento=tabla.getValueAt(i, 5).toString();
                        String fechaDeViaje=tabla.getValueAt(i, 7).toString();
                        String correo=tabla.getValueAt(i, 1).toString();
                        tablaboleto.addCell("\n\n"+cantidad+"\n\n");
                        tablaboleto.addCell("\n"+nombeyapellido);
                        tablaboleto.addCell("\n\n"+dni+"\n\n");
                        tablaboleto.addCell("\n\n"+celular+"\n\n");
                        tablaboleto.addCell(origen+"-\n"+destino+"\nACIENTO\nN°: "+asiento);
                        tablaboleto.addCell("\n\n"+fechaDeViaje+"\n\n");
                        tablaboleto.addCell(correo);
                        
                    }
                    doc.add(tablaboleto);
                    
                }
                
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
