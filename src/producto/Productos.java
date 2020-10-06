/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producto;

import Controlador.EnviosCTD;
import alertas.principal.ErrorAlert;
import alertas.principal.WarningAlertP;
import alertas.principal.WarningAlertP1;
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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import tabla.EstiloTablaHeader;
import tabla.EstiloTablaRenderer;
import tabla.MyScrollbarUI;
public class Productos extends javax.swing.JInternalFrame {
    EnviosCTD enctd=new EnviosCTD();
    public Productos() {
        initComponents();
        this.tabla.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
        this.tabla.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        this.tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getVerticalScrollBar().setUI(new MyScrollbarUI());
        jScrollPane1.getHorizontalScrollBar().setUI(new MyScrollbarUI());
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null); 
        enctd.listar("");
        totalpagar();
    }

    public static void seleccionaFila(String id) {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            if (id.equals(tabla.getValueAt(i, 0).toString())) {
                tabla.setRowSelectionInterval(i, i);
                break;
            }
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
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        txtTotal = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        buscar = new app.bolivia.swing.JCTextField();
        jLabel3 = new javax.swing.JLabel();
        imprimirenvios = new principal.MaterialButton();
        eliminar = new principal.MaterialButton();
        eliminarTodo = new principal.MaterialButton();

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

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/productos/productos.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Envios");

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
                    .addGap(89, 89, 89)
                    .addComponent(jLabel4)
                    .addContainerGap(747, Short.MAX_VALUE)))
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

        jPanel7.setBackground(new java.awt.Color(58, 159, 171));

        tabla.setBackground(new java.awt.Color(204, 204, 204));
        tabla.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        tabla.setForeground(new java.awt.Color(255, 255, 255));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COD", "DESDE", "HACIA", "REMITENTE", "DNI. REM", "CELULAR. REM", "BENEFICIARIO. REM", "DNI. BENE", "CELULAR. BENE", "DIRECCION", "CORREO", "CANT.", "CONTENIDO", "PRECIO", "IMPORTE", "CLAVE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true
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
            tabla.getColumnModel().getColumn(5).setMinWidth(100);
            tabla.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(255, 255, 255));
        txtTotal.setText("0.0");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("TOTAL ENVIOS: $");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 931, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/productos/campo-buscar.png"))); // NOI18N

        imprimirenvios.setBackground(new java.awt.Color(58, 159, 171));
        imprimirenvios.setForeground(new java.awt.Color(255, 255, 255));
        imprimirenvios.setText("IMPRIMIR");
        imprimirenvios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        imprimirenvios.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        imprimirenvios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirenviosActionPerformed(evt);
            }
        });

        eliminar.setBackground(new java.awt.Color(58, 159, 171));
        eliminar.setForeground(new java.awt.Color(255, 255, 255));
        eliminar.setText("ELIMINAR");
        eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        eliminar.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        eliminarTodo.setBackground(new java.awt.Color(58, 159, 171));
        eliminarTodo.setForeground(new java.awt.Color(255, 255, 255));
        eliminarTodo.setText("ELIMINAR TODO");
        eliminarTodo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        eliminarTodo.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        eliminarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarTodoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(imprimirenvios, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(eliminarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(imprimirenvios, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(eliminarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 971, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(3, 3, 3)))
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
            WarningAlertP1 wa = new WarningAlertP1(new JFrame(), true);
            totalpagar();
            wa.titulo.setText("¿ESTAS SEGURO?");
            wa.msj.setText("SE BORRARAN TODOS LOS");
            wa.msj1.setText("REGISTROS PERMANENTEMENTE");
            wa.setVisible(true);
        }
    }//GEN-LAST:event_eliminarTodoActionPerformed

    private void imprimirenviosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirenviosActionPerformed
        pdfReporteEnvios();
    }//GEN-LAST:event_imprimirenviosActionPerformed

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
                WarningAlertP wa = new WarningAlertP(new JFrame(), true);
                wa.id.setText(this.tabla.getValueAt(fila, 0).toString());
                wa.titulo.setText("¿ESTAS SEGURO?");
                wa.msj.setText("SE BORRARA PERMANENTEMENTE");
                wa.msj1.setText("");
                wa.setVisible(true);
                totalpagar();
            }
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyReleased
        enctd.listar(this.buscar.getText());
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static app.bolivia.swing.JCTextField buscar;
    private principal.MaterialButton cerrar;
    private principal.MaterialButton eliminar;
    private principal.MaterialButton eliminarTodo;
    private principal.MaterialButton imprimirenvios;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tabla;
    public static javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
    double totalpagar=0;
    private void totalpagar(){
        totalpagar=0.00;
        int numfila=tabla.getRowCount();
        for (int i = 0; i < numfila; i++) {
            double cal=Double.parseDouble(String.valueOf(tabla.getModel().getValueAt(i,13)));
            totalpagar=totalpagar+cal;
        }
        txtTotal.setText(String.valueOf(totalpagar));
    }
    public void pdfReporteEnvios(){
        try {
            String fechabusqueda=buscar.getText();
            Date date=new Date();
            /*comienzo del pdf*/
            FileOutputStream archivo;
            File file;
            if(!"".equals(fechabusqueda)){
                file=new File("GHBUS/REPORTES/ReporteEncomiendas"+fechabusqueda+"_"+new SimpleDateFormat("d-MM-yyyy").format(date)+".pdf");
            }else{
                file=new File("GHBUS/REPORTES/ReporteTodoEncomiendas_"+new SimpleDateFormat("d-MM-yyyy").format(date)+".pdf");
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
                float[] ColumnaEncabezado=new float[]{35f,30f,35f};
                Encabezado.setWidths(ColumnaEncabezado);
                Encabezado.setHorizontalAlignment(Element.ALIGN_CENTER);
                String enca="LISTADO DE ENVIOS";
                Encabezado.addCell("");
                Encabezado.addCell(enca);
                Encabezado.addCell("");
                doc.add(Encabezado);
                /*FIN DE ENCABEZADO*/
                Paragraph bole=new Paragraph();
                bole.add(Chunk.NEWLINE);
                bole.add("\n");
                doc.add(bole);
                /*-----CUADRO1-------*/
                PdfPTable tablaboleto=new PdfPTable(7);
                tablaboleto.setWidthPercentage(100);
                tablaboleto.getDefaultCell().setBorder(7|Rectangle.OUT_BOTTOM| Rectangle.OUT_RIGHT);
                float[] Columnatablaboleto=new float[]{4f,13f,26f,26f,18f,14f,16f,};
                tablaboleto.setWidths(Columnatablaboleto);
                tablaboleto.setHorizontalAlignment(Element.ALIGN_LEFT);
                PdfPCell bole1=new PdfPCell(new Phrase("\n\nN\n\n"));
                PdfPCell bole2=new PdfPCell(new Phrase("\n\n\nDESDE\n   /   \nHACIA.\n\n"));
                PdfPCell bole3=new PdfPCell(new Phrase("\nREMITENTE\n   /   \nDNI\n   /   \nCELULAR.\n\n"));
                PdfPCell bole4=new PdfPCell(new Phrase("\nDESTINATATIO\n   /  \nDNI\n   /   \nCELULAR.\n\n"));
                PdfPCell bole5=new PdfPCell(new Phrase("\n\nDIRECCION\n\n"));
                PdfPCell bole6=new PdfPCell(new Phrase("\n\nCORREO\n"));
                PdfPCell bole7=new PdfPCell(new Phrase("\nCANTIDAD\n   /   \nCONTENIDO.\n"));
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
                    for (int i = 0; i < tabla.getRowCount(); i++) {
                        cant++;
                        String cantidad=String.valueOf(cant);
                        String desde=tabla.getValueAt(i, 1).toString();
                        String hacia=tabla.getValueAt(i, 2).toString();
                        String remit=tabla.getValueAt(i, 3).toString();
                        String dnirem=tabla.getValueAt(i, 4).toString();
                        String celularrem=tabla.getValueAt(i, 5).toString();
                        String benefi=tabla.getValueAt(i, 6).toString();
                        String dnibenefi=tabla.getValueAt(i, 7).toString();
                        String celularbenefi=tabla.getValueAt(i, 8).toString();
                        String direccion=tabla.getValueAt(i, 9).toString();
                        String correo=tabla.getValueAt(i, 10).toString();
                        String canti=tabla.getValueAt(i, 11).toString();
                        String contenido=tabla.getValueAt(i, 12).toString();
                        String clave=tabla.getValueAt(i, 15).toString();
                        
                        tablaboleto.addCell("\n\n\n"+cantidad+"\n\n");
                        tablaboleto.addCell("\n\n"+desde+"\n   /   \n"+hacia+"\n\n");
                        tablaboleto.addCell("\n\n"+remit+"\n   /   \nDNI:"+dnirem+"\n   /   \nCEL:"+celularrem+"\n\n");
                        tablaboleto.addCell("\n\n"+benefi+"\n   /   \nDNI:"+dnibenefi+"\n   /   \nCEL:"+celularbenefi+"\n\n");
                        tablaboleto.addCell("\n\n"+direccion+"\n\n");
                        tablaboleto.addCell("\n\n"+correo+"\n\n");
                        tablaboleto.addCell("\n\nCantidad:"+canti+"\n   /   \nCONT:"+contenido+"\n   /   \nClave: "+clave+"\n\n");

                }
                doc.add(tablaboleto);
                
                doc.close();
                archivo.close();
                Desktop.getDesktop().open(file);
        } catch (DocumentException | FileNotFoundException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
