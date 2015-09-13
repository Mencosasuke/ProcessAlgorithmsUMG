/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package processalgorithms;

/**
 *
 * @author David Mencos
 */
public class Thread2 extends Thread {
    
    boolean eventFlag = Main.gui.getEventFlag();
    
    int dekkerNo = 0;
    int turno = 0;
    
    public void Dekker(int No){
        dekkerNo = No;
        turno = Main.gui.getTurno();
        Main.gui.setEventFlag(true);
        eventFlag = true;
    }
    
    @Override
    public void run() {
       while(true && !this.isInterrupted()) {
           while (eventFlag){
               switch(dekkerNo){
                   case 1:
                       dekker1();
                       break;
                   case 2:
                       break;
                   case 3:
                       break;
                   case 4:
                       break;
                   case 5:
                       break;
                   case 6:
                       break;
                   default:
                       break;
               }
               eventFlag = Main.gui.getEventFlag();
           }
       }
    }
    
    private void dekker1(){
        try{
            // Hace cosas
            Main.gui.setVisibleProgressBarP2("hide");
            Main.gui.updateStatusP2("Haciendo cosas...");
            sleep((int)((Math.random() * 3) + 2) * 1000);
            // Espera a que la región crítica se desocupe
            while (Main.gui.getTurno() == 2) {
                Main.gui.updateStatusP2("Esperando");
                Main.gui.setOperationProgressBarP2("wait");
                Main.gui.setVisibleProgressBarP2("show");
            }
            // Accede a Región Crítica
            Main.gui.setVisibleProgressBarP2("show");
            Main.gui.setOperationProgressBarP2("bussy");
            Main.gui.updateStatusP2("Usando región crítica...");
            sleep((int)((Math.random() * 3) + 2) * 1000);
            // Hace mas cosas
            Main.gui.setVisibleProgressBarP2("hide");
            Main.gui.updateStatusP2("Haciendo mas cosas...");
            sleep((int)((Math.random() * 3) + 2) * 1000);
            Main.gui.setTurno(2);
        }catch(InterruptedException e){}
    }
    
}
