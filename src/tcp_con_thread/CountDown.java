/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcp_con_thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author salva
 */
public class CountDown extends Thread{
    private int time;
    public CountDown(int t){
        time = t;
    }
    @Override
    public void run(){
        System.out.println("attendo risposta...\n");
        conta();
        System.out.println("connessione chiusa\n");
    }
    public void conta(){
        for(int i=time/1000;i>0;i--){
            try {
                System.out.println(i);
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(CountDown.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
