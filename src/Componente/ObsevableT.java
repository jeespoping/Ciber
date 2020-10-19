package Componente;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Master
 */
public class ObsevableT extends Thread {

    private DefaultTableModel tabla;
    private boolean valid;
    private int fila;
    private Date tiempoInicial;
    ObsevableT(DefaultTableModel tabla, int fila) {
        setPriority(MIN_PRIORITY);
        this.valid = true;
        this.tabla = tabla;
        this.fila = fila;
    }
    
    public void detonar() {
        this.valid = false;
    }

    @Override
    @SuppressWarnings({"SleepWhileInLoop", "UnusedAssignment"})
    public void run() {
        SimpleDateFormat hora = new SimpleDateFormat("hh:mm:ss a");
        tiempoInicial = new Date();
        Date tiempoRelativo;
        tabla.setValueAt(hora.format(tiempoInicial), fila, 1);
        while (valid) {
            tiempoRelativo = new Date();
                tabla.setValueAt(tiempoRespuesta(tiempoInicial, tiempoRelativo), fila, 2);
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(ObsevableT.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for (int i = 1; i < tabla.getColumnCount(); i++) {
            if (i != 3) {
                tabla.setValueAt("", fila, i);
            }
        }
    }

    private String tiempoRespuesta(Date tiempoInicial, Date tiempoRelativo) {
        String horas, segundos, minutos,tiempoFrecuene;
        Long second = (tiempoRelativo.getTime() - tiempoInicial.getTime()) / 1000;
        int minute = (int) (second / 60);
        int hour = (int) (minute / 60);
        for (int i = 0; i < minute; i++) {
            second = second - 60;
        }
        for (int i = 0; i < hour; i++) {
            minute = minute - 60;
        }
        if (hour < 10) {
            horas = "0" + hour;
        } else {
            horas = "" + hour;
        }
        if (second < 10) {
            segundos = "0" + second;
        } else {
            segundos = "" + second;
        }
        if (minute < 10) {
            minutos = "0" + minute;
        } else {
            minutos = "" + minute;
        }
        tiempoFrecuene = horas + ":" + minutos + ":" + segundos;
        return tiempoFrecuene;
    }
    
    public Date getTimeInicial(){
        return tiempoInicial;
    }
}
