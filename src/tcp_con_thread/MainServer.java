/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcp_con_thread;

/**
 *
 * @author salva
 */
public class MainServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int PORT = 2000;
        int TIME = 20000;
        
        Server s=new Server(PORT,TIME);
        while(true){
            CountDown timerAttesa = new CountDown(TIME);
            s.attendi();
            s.scrittura("il server sarà in ascolto per: "+(TIME/1000)+" secondi");
            s.scrittura(String.valueOf(TIME));
            timerAttesa.start();
        }
    }
}
