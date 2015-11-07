/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author PedroJosé
 */
public class TicketComparator implements Comparator<Ticket>, Serializable {

    @Override
    public int compare(Ticket o1, Ticket o2) {
        if (o1.getId() != o2.getId()) {
            return o1.getId() - o2.getId();
        } else if (!(o1.getName().equals(o2.getName()))) {
            return o1.getName().compareTo(o2.getName());
        } else {
            return o1.getContact() - o2.getContact();
        }
    }

}
