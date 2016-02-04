
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

/**
 *
 * @author PedroJosé
 */
public class PDFMaker {

    public PDFMaker(String filename, TicketMap tm, int pr1, int pr2, int pr3) {
        Document doc = new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(filename));
            doc.open();
            doc.add(new Phrase("Cabaz de Natal, Clã Schindler"));
            doc.add(new Paragraph("As seguintes Rifas foram vendidas:"));
            doc.add(new Paragraph("\n"));
            PdfPTable table = new PdfPTable(5);
            for (Ticket t : tm.getFullTickets()) {

                PdfPCell cell = new PdfPCell(new Paragraph(t.getId() + "-" + t.getName()));
                table.addCell(cell);
            }
            doc.add(table);
            doc.add(new Chapter("Vencedores deste ano:", 1));
            doc.add(new Paragraph("1º Prémio. " + tm.getTicket(pr1)));
            doc.add(new Paragraph("2º Prémio. " + tm.getTicket(pr2)));
            doc.add(new Paragraph("3º Prémio. " + tm.getTicket(pr3)));
            doc.close();
        } catch (Exception e) {

        }
    }
}
