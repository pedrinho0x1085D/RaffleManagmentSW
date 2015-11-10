/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

/**
 *
 * @author Pedro Cunha
 */
public class TicketMap implements Serializable{

    private HashMap<Integer, Ticket> fullMap;
    private HashMap<Integer, Ticket> dinnerMap;

    public TicketMap() {
        this.fullMap = new HashMap<>();
        this.dinnerMap = new HashMap<>();
    }

    public HashMap<Integer, Ticket> getFullMap() {
        HashMap<Integer, Ticket> res = new HashMap<>();
        for (Ticket t : this.fullMap.values()) {
            res.put(t.getId(), t.clone());
        }
        return res;
    }

    public HashMap<Integer, Ticket> getDinnerMap() {
        HashMap<Integer, Ticket> res = new HashMap<>();
        for (Ticket t : this.dinnerMap.values()) {
            res.put(t.getId(), t.clone());
        }
        return res;
    }

    public void insertNormalTicket(Ticket t) throws ExistingIDException {
        if (this.fullMap.containsKey(t.getId())) {
            throw new ExistingIDException(t.getId());
        } else {
            this.fullMap.put(t.getId(), t.clone());
        }
    }

    public void insertDinnerTicket(Ticket t) throws ExistingIDException {
        if (this.dinnerMap.containsKey(t.getId()) || this.fullMap.containsKey(t.getId())) {
            throw new ExistingIDException(t.getId());
        } else {
            this.dinnerMap.put(t.getId(), t.clone());
            this.fullMap.put(t.getId(), t.clone());
        }

    }

    public ArrayList<Integer> getDinnerIdArray() {
        ArrayList<Integer> res = new ArrayList<>();
        for (Ticket t : this.dinnerMap.values()) {
            res.add(t.getId());
        }
        return res;
    }

    public ArrayList<Integer> getFullIdArray() {
        ArrayList<Integer> res = new ArrayList<>();
        for (Ticket t : this.fullMap.values()) {
            res.add(t.getId());
        }
        return res;
    }

    public Ticket getTicket(int id) {
        return this.fullMap.get(id);
    }

    public void saveFile() throws FileNotFoundException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.obj"));
        oos.writeObject(this);
    }

    public TreeSet<Ticket> getFullTickets(){
        TreeSet<Ticket> res = new TreeSet<>(new TicketComparator());
        for(Ticket t:this.fullMap.values())
            res.add(t.clone());
        return res;
    }

    
    public TreeSet<Ticket> getDinnerTickets(){
        TreeSet<Ticket> res = new TreeSet<>(new TicketComparator());
        for(Ticket t:this.dinnerMap.values())
            res.add(t.clone());
        return res;
    }
    
    public void nullifyNormalTicket(int id){
        this.fullMap.remove(id);
    }
    public void nullifyDinnerTicket(int id){
        this.fullMap.remove(id);
        this.dinnerMap.remove(id);
    }
    
    public static TicketMap loadFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.obj"));
        TicketMap tm = (TicketMap) ois.readObject();
        return tm;
    }
}
