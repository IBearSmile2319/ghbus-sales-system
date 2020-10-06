/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import Controlador.GananciasCTD;
import Modelo.Ganancias;
import alertas.principal.AWTUtilities;
import alertas.principal.ErrorAlert;
import alertas.principal.SuccessAlert;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;

/**
 *
 * @author Rojeru San
 */
public class ModaBoletoM extends javax.swing.JDialog {
    GananciasCTD gnctd=new GananciasCTD();
    Ganancias gn=new Ganancias();
    Timer timer = null;
    TimerTask task;
    int i = 32;

    /**
     * Creates new form ModalProducto
     */
    public ModaBoletoM(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        AWTUtilities.setOpaque(this, false);
        Ubicar(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        jPanel2 = new javax.swing.JPanel();
        cerrar = new principal.MaterialButton();
        titulo = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        TotalGananciasDelDia = new app.bolivia.swing.JCTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPrecioTotal = new app.bolivia.swing.JCTextField();
        jLabel7 = new javax.swing.JLabel();
        porcentaje = new app.bolivia.swing.JCTextField();
        jPanel3 = new javax.swing.JPanel();
        registrar = new principal.MaterialButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alertas/img/fondo.png"))); // NOI18N
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("TITULO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(cerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        panel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 10, 458, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        jPanel4.setBorder(dropShadowBorder1);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/productos/campo-tipo.png"))); // NOI18N
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        TotalGananciasDelDia.setEditable(false);
        TotalGananciasDelDia.setBorder(null);
        TotalGananciasDelDia.setForeground(new java.awt.Color(58, 159, 171));
        TotalGananciasDelDia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TotalGananciasDelDia.setPlaceholder("GANANCIAS DEL DIA");
        jPanel4.add(TotalGananciasDelDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 240, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventas/campo-precio.png"))); // NOI18N
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, -1));

        txtPrecioTotal.setEditable(false);
        txtPrecioTotal.setBorder(null);
        txtPrecioTotal.setForeground(new java.awt.Color(58, 159, 171));
        txtPrecioTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPrecioTotal.setPlaceholder("PRECIO TOTAL");
        jPanel4.add(txtPrecioTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 240, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/productos/campo_stock.png"))); // NOI18N
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        porcentaje.setBorder(null);
        porcentaje.setForeground(new java.awt.Color(58, 159, 171));
        porcentaje.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        porcentaje.setPlaceholder("PORCENTAJE");
        porcentaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                porcentajeKeyPressed(evt);
            }
        });
        jPanel4.add(porcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 240, 30));

        panel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 420, 370));

        jPanel3.setBackground(new java.awt.Color(58, 159, 171));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        registrar.setBackground(new java.awt.Color(255, 255, 255));
        registrar.setForeground(new java.awt.Color(58, 159, 171));
        registrar.setText("GUARDAR");
        registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        registrar.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });
        registrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                registrarKeyTyped(evt);
            }
        });
        jPanel3.add(registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 170, 50));

        panel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 340, 459, 200));

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 476, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    public void post_ventas(){
        gn.setVenta_b_e("Boletos");
        gn.setValordeldia(Double.parseDouble(txtPrecioTotal.getText()));
        gn.setPorcentaje(Integer.parseInt(porcentaje.getText()));
        gn.setGanancias(Double.parseDouble(TotalGananciasDelDia.getText()));
        gnctd.ganancias_post(gn);
        
    }
    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        if(!"".equals(porcentaje.getText())){
            post_ventas();
            SuccessAlert sa = new SuccessAlert(new JFrame(), true);
            sa.titulo.setText("¡HECHO!");
            sa.msj.setText("SE HA GUARDADO LAS");
            sa.msj1.setText("GANANCIAS DEL DIA");
            sa.setVisible(true);
        }else{
            ErrorAlert er = new ErrorAlert(new JFrame(), true);
            er.titulo.setText("OOPS...");
            er.msj.setText("EL CAMPO PORCENTAJE");
            er.msj1.setText("ESTAN VACIOS");
            er.setVisible(true);
        }
    }//GEN-LAST:event_registrarActionPerformed

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

    private void registrarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_registrarKeyTyped
        if ((evt.getKeyChar() == KeyEvent.VK_ENTER)) {
            
        }
    }//GEN-LAST:event_registrarKeyTyped
    float porc;
    private void porcentajeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_porcentajeKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){ 
            if(!"".equals(porcentaje.getText())){
                porc=(float) (Double.parseDouble(txtPrecioTotal.getText())*Double.parseDouble(porcentaje.getText())/100);
                TotalGananciasDelDia.setText(String.valueOf(porc));
            }else{
                ErrorAlert er = new ErrorAlert(new JFrame(), true);
                er.titulo.setText("OOPS...");
                er.msj.setText("EL CAMPO PORCENTAJE ESTA");
                er.msj1.setText("VACIO!");
                er.setVisible(true);
            }
        }
    }//GEN-LAST:event_porcentajeKeyPressed

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
            java.util.logging.Logger.getLogger(ModaBoletoM.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModaBoletoM.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModaBoletoM.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModaBoletoM.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModaBoletoM dialog = new ModaBoletoM(new javax.swing.JFrame(), true);
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
    public static app.bolivia.swing.JCTextField TotalGananciasDelDia;
    private principal.MaterialButton cerrar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private org.edisoncor.gui.panel.Panel panel1;
    public static app.bolivia.swing.JCTextField porcentaje;
    public static principal.MaterialButton registrar;
    public static javax.swing.JLabel titulo;
    public static app.bolivia.swing.JCTextField txtPrecioTotal;
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
        this.setLocation(603, y - 200);
    }
}
