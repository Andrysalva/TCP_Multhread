/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcp_con_thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author salva
 */
class ClientHandler implements Runnable{
    private final Socket clientSocket;
    BufferedReader reader;
    BufferedWriter writer;
    
    public ClientHandler(Socket socket)
        {
            this.clientSocket = socket;
        }

    @Override
    public void run() {
        reader = null;
        writer = null;
        scrittura("ciao!");
        chiusuraConnessione();
    }
    
        public void scrittura(String s) {
        try {
            writer.write(s+"\n");
            writer.flush();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String lettura() {
        String msg = null;
        try {
            msg = reader.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msg;
    }
    
    public void chiusuraConnessione() {
        try {
            clientSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
