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
                       dekker2();
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
            // Hace cosas
            hacerCosas("");
            // Espera a que la región crítica se desocupe
            while (Main.gui.getTurno() == 1) {
                esperar();
            }
            // Accede a Región Crítica
            regionCritica();
            // Hace mas cosas
            hacerCosas("mas");
            Main.gui.setTurno(1);
    }
    
    private void dekker2(){
        hacerCosas("");
        while(Main.gui.getTurno() == 2){
            esperar();
        }
        Main.gui.setTurno(1);
        regionCritica();
        Main.gui.setTurno(2);
        hacerCosas("mas");
    }
    
    private void hacerCosas(String s){
        Main.gui.setVisibleProgressBarP1("show");
        Main.gui.updateStatusP1("Haciendo " + s + " cosas...");
        Main.gui.setOperationProgressBarP1("working");
    }
    
    private void regionCritica(){
        try{
            Main.gui.setVisibleProgressBarP1("show");
            Main.gui.setOperationProgressBarP1("bussy");
            Main.gui.updateStatusP1("Usando región crítica...");
            sleep((int)((Math.random() * 2) + 2) * 1000);
        }catch(InterruptedException e){}
    }
    
    private void esperar(){
        Main.gui.updateStatusP1("Esperando");
        Main.gui.setOperationProgressBarP1("wait");
        Main.gui.setVisibleProgressBarP1("show");
    }
    
}
