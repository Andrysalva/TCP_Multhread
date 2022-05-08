/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcp_con_thread;

import java.net.*;
import java.io.*;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author salva
 */
public class Client {

    Socket client;
    BufferedReader reader;
    BufferedWriter writer;

    public Client(InetAddress ip, int porta) {
        try {
            client = new Socket(ip, porta);
            reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String lettura() {
        String msg = null;
        try {
            msg = reader.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msg;
    }

    public void scrittura(String testo) {
        try {
            //scrivo al server un testo dato come parametro alla funzione
            writer.write(testo + "\n");
            writer.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void data() {
        try {
            //scrivo la richiesta al server
            writer.write("date\n");
            writer.flush();

            //leggo la richiesta e la mostro in output
            Timestamp time = new Timestamp(Long.parseLong(reader.readLine()));
            System.out.println(time);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void timer(int t) {
        CountDown timer = new CountDown(t);
        timer.start();
    }

    public void chiusura() {
        try {
            client.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
