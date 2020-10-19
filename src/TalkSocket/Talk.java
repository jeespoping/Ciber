/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TalkSocket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Master
 */
public class Talk {
    private DataOutputStream Salida;

    public Talk(Socket socket) {
        try {
            Salida = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Talk.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendMessage(String text){
        try {
            Salida.writeUTF(text);
        } catch (IOException ex) {
            Logger.getLogger(Talk.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
