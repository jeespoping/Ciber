/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListenSocket;

import Componente.Boton;
import TalkSocket.Talk;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Master
 */
public class Listen extends Thread {

    private DataInputStream Entrada;
    private String ordenadorListen;
    private JTextPane jTextPane2;
    private JTable jTable1;
    private Socket socket;
    private int fila;

    public Listen(Socket socket, JTable jTable1, int fila, JTextPane jTextPane2) {
        setPriority(MIN_PRIORITY);
        this.jTextPane2=jTextPane2;
        this.jTable1 = jTable1;
        this.socket = socket;
        this.fila = fila;
        cargar();
    }

    @Override
    public void run() {
        while (true) {
            try {
                ordenadorListen = Entrada.readUTF();
                System.out.println(ordenadorListen);
                commandSystem(ordenadorListen);
            } catch (IOException ex) {
                apagar();
                break;
            }
        }
    }

    public String getMessage() {
        return ordenadorListen;
    }

    private void apagar() {
        JLabel ordenador = (JLabel) jTable1.getValueAt(fila, 0);
        ordenador.setName("Apagado");
        ((DefaultTableModel) jTable1.getModel()).fireTableDataChanged();
    }

    private void encender() {
        JLabel ordenador = (JLabel) jTable1.getValueAt(fila, 0);
        ordenador.setName("Encendido");
        ((DefaultTableModel) jTable1.getModel()).fireTableDataChanged();
    }

    private void reActivar() {
        Talk t = new Talk(socket);
        JLabel ordenador = (JLabel) jTable1.getValueAt(fila, 0);
        Boton iniciador = (Boton) jTable1.getValueAt(fila, 3);
        //activamos al equipo
        ordenador.setName("Activo");
        //se envía el primer comando de reusar
        t.sendMessage("$cmd/Reusar");
        System.out.println(iniciador.getTime().toString());
        SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy hh:mm:ss a");
        System.out.println(format.format(iniciador.getTime()));
        t.sendMessage(format.format(iniciador.getTime()));
        
        ((DefaultTableModel) jTable1.getModel()).fireTableDataChanged();
    }

    private void commandSystem(String ordenadorListen) {
        switch (ordenadorListen) {
            case "$cmd/Encender":
                if (((String) jTable1.getValueAt(fila, 1)).equals("")) {
                    encender();
                } else {
                    reActivar();
                }
                break;
            default:
                receptor(ordenadorListen);
                break;
        }
    }

    private void cargar() {
        ordenadorListen = "";
        try {
            Entrada = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            apagar();
        }
    }
    
    private void receptor(String textIngresar) {
        textIngresar = buscarEmoticon(textIngresar);
        String HTML = jTextPane2.getText();
        int ini, fin;
        ini = HTML.indexOf("<body>") + 6;
        fin = HTML.lastIndexOf("</body>");
        String textIni = HTML.substring(0, ini);
        String textfin = HTML.substring(fin);
        String text = HTML.substring(ini, fin); 
        text += createHTML(textIngresar);
        textIni += text + textfin;
         jTextPane2.setText(textIni); 
    }
    
    private String buscarEmoticon(String part2) {
        String[] emoji = {":)", ":(", ":P", ":D", ":O"};
        String part1;
        int t;
        for (int i = 0; i < emoji.length; i++) {
            t = part2.indexOf(emoji[i]);
            if (t != -1) {
                part1 = "";
                while (t > -1) {
                    part1 += part2.substring(0, t);
                    part2 = part2.substring(t + 2);
                    part1 += "<img src='" + getClass().getResource("/chatRoom/Emoji/" + i + ".png") + "'>";
                    t = part2.indexOf(emoji[i]);
                }
                part2 = part1 + part2;
            }
        }
        return part2;
    }

    private String createHTML(String textIngresar) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        String stylesheet = "background-color:#d9edc2;border:1px solid #bfd7a4;padding:1px 5px 1px 5px;";
        return "<table><tr><td align:top><img src='" + getClass().getResource("/chatRoom/Ico/hombre.png") + "'></td><td>"
                + "<div style ='" + stylesheet + "'><table><tr><td><font face='verdana' size=3>"
                + textIngresar + "</font></td></tr><tr><td><font face='verdana' size=1 color='gray'>"
                + format.format(new Date()) + "</font></td></tr></table></div></td></tr></table>\n";
    }
    
}
