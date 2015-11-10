/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PedroJosé
 */
public class Countdown implements Runnable {

    private CountDownGUI countdown;

    public Countdown(CountDownGUI cdgui) {
        this.countdown = cdgui;
    }

    @Override
    public void run() {
        while (this.countdown.getTimer().isOn()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Countdown.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.countdown.getTimer().decrementSecond();
            this.countdown.updateTimer();

        }
        this.countdown.enableSorteio();
    }

}
