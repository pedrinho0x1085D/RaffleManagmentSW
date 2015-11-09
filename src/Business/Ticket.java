/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.io.Serializable;

/**
 *
 * @author Pedro Cunha
 */
public class Ticket implements Serializable{

    private int id;
    private String name;
    private int contact;

    public Ticket(int id, String name, int contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getContact() {
        return contact;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String toString() {
        return new String(this.id + " " + this.name + " " + this.contact);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if ((!(o.getClass().getSimpleName()).equals(this.getClass().getSimpleName())) || o == null) {
            return false;
        } else {
            Ticket t = (Ticket) o;
            return this.id == t.getId() && this.name.equals(t.getName()) && this.contact == t.getContact();
        }
    }
    
    public Ticket clone(){
        return new Ticket(this.id,this.name,this.contact);
    }
}
