/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Pedro Cunha
 */
public class Timer {

    int seconds;

    public Timer(int hours, int minutes, int seconds) {
        this.seconds = seconds + (minutes * 60) + (hours * 3600);
    }

    public Timer(int seconds) {
        this.seconds = seconds;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public void decrementSecond() {
        this.seconds--;
    }

    public int getHours() {
        return this.seconds / 3600;
    }

    public int getMinutes() {
        return (this.seconds - (this.getHours() * 3600)) / 60;
    }

    public int getRealSeconds() {
        return (this.seconds - (this.getMinutes() * 60));
    }

    public boolean isOn() {
        return this.seconds != 0;
    }

    public String toString() {
        return this.getHours() + ":" + this.getMinutes() + ":" + this.getRealSeconds();
    }
}
