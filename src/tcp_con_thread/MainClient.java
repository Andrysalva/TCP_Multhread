/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcp_con_thread;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author salva
 */
public class MainClient {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        int TIME = 0;
        int PORT = 2000;
        try {
            InetAddress IP = InetAddress.getLocalHost();
            Client c = new Client(IP, PORT);
            System.out.println(c.lettura());
            TIME = Integer.parseInt(c.lettura());
            CountDown timer = new CountDown(TIME);
            timer.start();
            c.chiusura();
        } catch (UnknownHostException ex) {
            Logger.getLogger(MainClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
