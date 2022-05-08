/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcp_con_thread;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author salva
 */
public class Server {

    ServerSocket serverSock;
    Socket socket;
    BufferedReader reader;
    BufferedWriter writer;

    public Server(int porta, int t) {
        try {
            serverSock = new ServerSocket(porta);
            serverSock.setSoTimeout(t*1000);
            serverSock.setReuseAddress(true);
        } catch (SocketTimeoutException ex) {
            System.out.println("Il server non accetta più richieste");
            System.err.print(ex);
        } catch (ConnectException ex) {
            System.err.print(ex);
        } catch (SocketException ex) {
            System.err.print(ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void accetta(int clientTimeout) {
        try {
            socket = serverSock.accept();
            socket.setSoTimeout(clientTimeout * 1000);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("client connesso: " + socket.getInetAddress().getHostAddress());
            ClientHandler handler = new ClientHandler(socket);
            new Thread(handler).start();
        } catch (SocketException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
