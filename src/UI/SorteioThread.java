/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PedroJosé
 */
public class SorteioThread implements Runnable{
    private SorteioGUI map;
    private FullSorteioGUI fsg;
    public SorteioThread(SorteioGUI sgui,FullSorteioGUI fsg){
        this.map=sgui;
        this.fsg=fsg;
    }
    
    public void run(){
        int last;
        String winner;
        ArrayList<Integer> idents = this.map.map.getFullIdArray();
        Random rng = new Random();
        fsg.jLabel1.setText("1");
        fsg.jLabel1.setVisible(true);
        for (int i = 0; i < 15; i++) {
            fsg.jLabel1.setText(idents.get(rng.nextInt(idents.size() - 1)) + "");
        }
        for (int i = 0; i < 10; i++) {
            fsg.jLabel1.setText(idents.get(rng.nextInt(idents.size() - 1)) + "");
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                Logger.getLogger(FullSorteioGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for (int i = 0; i < 5; i++) {
            fsg.jLabel1.setText(idents.get(rng.nextInt(idents.size() - 1)) + "");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(FullSorteioGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for( int i=0;i<2;i++){
            fsg.jLabel1.setText(idents.get(rng.nextInt(idents.size()-1))+"");
            try {
                Thread.sleep(750);
            } catch (InterruptedException ex) {
                Logger.getLogger(FullSorteioGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        fsg.jLabel2.setVisible(true);
        for(int i=0;i<3;i++){
            fsg.jLabel1.setVisible(false);
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                Logger.getLogger(FullSorteioGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            fsg.jLabel1.setVisible(true);
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                Logger.getLogger(FullSorteioGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            fsg.jLabel1.setForeground(Color.green);
        last=Integer.parseInt(fsg.jLabel1.getText());
        winner=this.map.map.getTicket(last).getName();
        fsg.jLabel3.setText(winner);
        fsg.jLabel3.setVisible(true);
        fsg.jButton2.setEnabled(true);
    }
    
}
