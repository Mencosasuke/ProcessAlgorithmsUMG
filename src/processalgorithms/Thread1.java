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
public class Thread1 extends Thread{
    
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
            Main.gui.setVisibleProgressBarP1("hide");
            Main.gui.updateStatusP1("Haciendo  cosas...");
            sleep((int)((Math.random() * 3) + 2) * 1000);
            // Espera a que la región crítica se desocupe
            while (Main.gui.getTurno() == 1) {
                Main.gui.updateStatusP1("Esperando");
                Main.gui.setOperationProgressBarP1("wait");
                Main.gui.setVisibleProgressBarP1("show");
            }
            // Accede a Región Crítica
            Main.gui.setVisibleProgressBarP1("show");
            Main.gui.setOperationProgressBarP1("bussy");
            Main.gui.updateStatusP1("Usando región crítica...");
            sleep((int)((Math.random() * 3) + 2) * 1000);
            // Hace mas cosas
            Main.gui.setVisibleProgressBarP1("hide");
            Main.gui.updateStatusP1("Haciendo mas cosas...");
            sleep((int)((Math.random() * 3) + 2) * 1000);
            Main.gui.setTurno(1);
//            sleep(1000);
//            Main.gui.updateStatusP1(String.valueOf(i++));
        }catch(InterruptedException e){}
    }
    
//    int i = 0;
//    
//    public void run(){
//        try{
//            while(eventFlag){
//              Main.gui.updateLable(String.valueOf(i));
//              i++;
//              sleep(1000);
//            }
//        }catch(Exception e){ }
//    }
}
