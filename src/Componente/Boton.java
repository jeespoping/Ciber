/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componente;

import TalkSocket.Talk;
import java.net.Socket;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Master
 */
public class Boton extends JButton {

    private ObsevableT reloj;
    private JTable tabla;
    private int fila;

    public Boton(String string, JTable tabla, int fila) {
        super(string);
        this.tabla = tabla;
        this.fila = fila;
    }

    @SuppressWarnings("UnusedAssignment")
    public void jButtonActionPerformed(Socket socket) {
        Talk talk = new Talk(socket);
        JLabel equipo;
        if (getText().equals("Libre")) {
            setText("En uso");
            reloj = new ObsevableT(((DefaultTableModel) tabla.getModel()), fila);
            equipo = (JLabel) ((DefaultTableModel) tabla.getModel()).getValueAt(fila, 0);
            if (equipo.getName().equals("Encendido")) {
                equipo.setName("Activo");
            }
            talk.sendMessage("$cmd/Usar");
            reloj.start();
        } else if (getText().equals("En uso")) {
            equipo = (JLabel) ((DefaultTableModel) tabla.getModel()).getValueAt(fila, 0);
            Panel_pago pago = new Panel_pago(reloj, this, tabla, fila, equipo, socket);
            pago.setLocationRelativeTo(tabla);
            pago.setTitle("Tickt → [ Ordenador " + (fila + 1) + " ]");
            pago.setVisible(true);
        }
        ((DefaultTableModel) tabla.getModel()).fireTableDataChanged();
    }
    
    public void jButtonActionPerformed() {
        JLabel equipo;
        if (getText().equals("Libre")) {
            setText("En uso");
            reloj = new ObsevableT(((DefaultTableModel) tabla.getModel()), fila);
            equipo = (JLabel) ((DefaultTableModel) tabla.getModel()).getValueAt(fila, 0);
            if (equipo.getName().equals("Encendido")) {
                equipo.setName("Activo");
            }
            reloj.start();
        } else if (getText().equals("En uso")) {
            equipo = (JLabel) ((DefaultTableModel) tabla.getModel()).getValueAt(fila, 0);
            Panel_pago pago = new Panel_pago(reloj, this, tabla, fila, equipo);
            pago.setLocationRelativeTo(tabla);
            pago.setTitle("Tickt → [ Ordenador " + (fila + 1) + " ]");
            pago.setVisible(true);
        }
        ((DefaultTableModel) tabla.getModel()).fireTableDataChanged();
    }
    
    public Date getTime(){
        Date tiempo = reloj.getTimeInicial();
        return tiempo;
    }

}
