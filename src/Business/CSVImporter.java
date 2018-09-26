/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author PedroJosé
 */
public class CSVImporter {

    public static void importfromCSV(TicketMap tm, String csvFilename) {
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader(csvFilename));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] splitLine = line.split(csvSplitBy);
                splitLine =  trimAllStrings(splitLine);
                if (splitLine.length == 3) {
                    int ticketId = Integer.parseInt(splitLine[0]);
                    String name = splitLine[1];
                    int contact = Integer.parseInt(splitLine[2]);
                    tm.insertNormalTicket(new Ticket(ticketId, name, contact));
                }
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String[] trimAllStrings(String[] toTrim){
        String[] trimmed = new String[toTrim.length];
        for(int i=0; i<trimmed.length;i++){
            trimmed[i]=toTrim[i].trim();
        }
        return trimmed;
    }
}
