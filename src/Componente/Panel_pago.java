/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componente;

import TalkSocket.Talk;
import java.awt.Image;
import java.net.Socket;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Master
 */
public class Panel_pago extends javax.swing.JDialog {

    private ObsevableT Cronometro;
    private Boton botonIniciar;
    private JTable tabla;
    private JLabel Ordenador;
    private Socket socket;
    double totalP;

    Panel_pago(ObsevableT reloj, Boton aThis, JTable tabla, int fila, JLabel equipo) {
        initComponents();
        this.Cronometro = reloj;
        this.botonIniciar = aThis;
        this.tabla = tabla;
        this.Ordenador = equipo;
        inicios(fila);
    }

    Panel_pago(ObsevableT reloj, Boton aThis, JTable tabla, int fila, JLabel equipo, Socket socket) {
        initComponents();
        this.socket = socket;
        this.Cronometro = reloj;
        this.botonIniciar = aThis;
        this.tabla = tabla;
        this.Ordenador = equipo;
        inicios(fila);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        horaInicio = new javax.swing.JLabel();
        horaFinal = new javax.swing.JLabel();
        tiempoTranscurrido = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cobroTiempo = new javax.swing.JLabel();
        cobroExtra = new javax.swing.JLabel();
        cobroTotal = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);

        jTextPane1.setEditable(false);
        jTextPane1.setContentType("text/html"); // NOI18N
        jTextPane1.setText("<html>\r\n  <head>\r\n\r\n  </head>\r\n  <body>\r\n\n<div style='height: auto;\n\tmargin: 0px;\n\tpadding: 0px;\n\tfloat: left;\n\tfont-family: Arial, Helvetica, sans-serif;\n\tfont-size: 7px;\n\tfont-style: normal;\n\tline-height: normal;\n\tfont-weight: normal;\n\tfont-variant: normal;\n\ttext-transform: none;\n\tcolor: #000'>\n   \n    --------------------------------<br>\n    nombre de la tienda<br>\n    --------------------------------<br>\n    Sucursal: <br>\n    Fecha: <br>\n    Vendedor:<br>\n    Numero de pedido: <br>\n    Nombre: <br>\n    Direccion: <br>\n    Tel:<br>  \n    <table>\n  <tr>\n    <td>Descripcion</td>\n    <td>P.UNIT</td>\n    <td>Importe</td>\n  </tr>\n      <tr>\n        <td><></td>\n        <td><></td>\n        <td><></td>\n  <td>Total:</td>\n  </tr>\n  </table>\n  <br>\n    </div>\n  </body>\r\n</html>\r\n");
        jScrollPane1.setViewportView(jTextPane1);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información de Tiempo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Semibold", 0, 12))); // NOI18N
        jPanel1.setLayout(null);

        horaInicio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        horaInicio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        horaInicio.setText("jLabel2");
        jPanel1.add(horaInicio);
        horaInicio.setBounds(133, 30, 100, 25);

        horaFinal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        horaFinal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        horaFinal.setText("jLabel3");
        jPanel1.add(horaFinal);
        horaFinal.setBounds(133, 60, 100, 23);

        tiempoTranscurrido.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tiempoTranscurrido.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tiempoTranscurrido.setText("jLabel4");
        jPanel1.add(tiempoTranscurrido);
        tiempoTranscurrido.setBounds(133, 90, 100, 25);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setText("Hora de Inicio:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 30, 100, 25);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setText("Hora Finalizada");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 60, 100, 23);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel7.setText("Tiempo Utilizado:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(30, 90, 100, 25);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información de Cobro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Semibold", 0, 12))); // NOI18N
        jPanel2.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setText("Extra:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(30, 30, 100, 25);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel10.setText("Tiempo:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(30, 70, 100, 25);

        cobroTiempo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cobroTiempo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(cobroTiempo);
        cobroTiempo.setBounds(130, 70, 100, 25);

        cobroExtra.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cobroExtra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(cobroExtra);
        cobroExtra.setBounds(130, 30, 100, 25);

        cobroTotal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cobroTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(cobroTotal);
        cobroTotal.setBounds(130, 110, 100, 25);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel15.setText("Total:");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(30, 110, 100, 25);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de Pago"));
        jPanel3.setLayout(null);

        jFormattedTextField1.setEditable(false);
        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("$#,##0.00"))));
        jFormattedTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel3.add(jFormattedTextField1);
        jFormattedTextField1.setBounds(30, 90, 210, 25);

        jLabel16.setText("Cambio:");
        jPanel3.add(jLabel16);
        jLabel16.setBounds(30, 70, 90, 20);

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        jPanel3.add(jTextField1);
        jTextField1.setBounds(30, 40, 210, 25);

        jLabel17.setText("Paga con:");
        jPanel3.add(jLabel17);
        jLabel17.setBounds(30, 20, 120, 20);

        jLabel1.setFont(new java.awt.Font("Bungee Inline", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ticket");

        jButton1.setText("Cobrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Continuar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cobrar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        double total;
        if (!jTextField1.getText().equals("")) {
            total = Double.parseDouble(jTextField1.getText()) - totalP;

        } else {
            total = -totalP;
        }
        jFormattedTextField1.setValue(total);
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        char Caracter = evt.getKeyChar();

        if ((Caracter < '0') || (Caracter > '9') && (Caracter != '.')) {

            evt.consume();
        } else {
            if (jTextField1.getText().contains(".") && Caracter == '.') {
                evt.consume();
            }
        }
    }//GEN-LAST:event_jTextField1KeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cobroExtra;
    private javax.swing.JLabel cobroTiempo;
    private javax.swing.JLabel cobroTotal;
    private javax.swing.JLabel horaFinal;
    private javax.swing.JLabel horaInicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel tiempoTranscurrido;
    // End of variables declaration//GEN-END:variables
    
    private void inicios(int fila) {
        SimpleDateFormat formatTime = new SimpleDateFormat("hh:mm:ss a");
        horaFinal.setText(formatTime.format(new Date()));
        horaInicio.setText((String) tabla.getValueAt(fila, 1));
        tiempoTranscurrido.setText((String) tabla.getValueAt(fila, 2));
        generarCosto((String) tabla.getValueAt(fila, 2), fila);
        favicon();
    }
    
    private void generarCosto(String par, int fila) {
        String hour = par.substring(0, par.indexOf(":"));
        DecimalFormat formato = new DecimalFormat("$ #,###.00");
        String minute = par.substring(par.indexOf(":") + 1, par.lastIndexOf(":"));
        double total = 0.0;
        if (Integer.parseInt(minute) <= 30 && Integer.parseInt(minute) > 0) {
            total += 4;
        }
        if (Integer.parseInt(minute) > 30) {
            total += 8;
        }
        if (Integer.parseInt(hour) > 0) {
            for (int i = 0; i < Integer.parseInt(hour); i++) {
                total += 8;
            }
        }
        jFormattedTextField1.setValue(0);
        try {
            double t = Double.parseDouble((String) tabla.getValueAt(fila, 5));
            
            cobroTiempo.setText(formato.format(total));
            total+=t;
            cobroTotal.setText(formato.format(total));
            cobroExtra.setText(formato.format(t));
        } catch (NumberFormatException e) {
            cobroTiempo.setText(formato.format(total));
            cobroTotal.setText(formato.format(total));
            cobroExtra.setText(formato.format(0));
        }
        jTextField1.setText("" + total);
            totalP=total;
    }

    private void favicon() {
        ImageIcon ImageIcon = new ImageIcon(getClass().getResource("/Ico/ticket.png"));
        Image Image = ImageIcon.getImage();
        setIconImage(Image);
    }

    private void cobrar() {
        Cronometro.detonar();
        botonIniciar.setText("Libre");
        if (Ordenador.getName().equals("Activo")) {
            Ordenador.setName("Encendido");
        }
        if (socket != null) {
            Talk talk = new Talk(socket);
            talk.sendMessage("$cmd/Bloquear");
        } else {
        }
        ((DefaultTableModel) tabla.getModel()).fireTableDataChanged();
        dispose();
    }

}
