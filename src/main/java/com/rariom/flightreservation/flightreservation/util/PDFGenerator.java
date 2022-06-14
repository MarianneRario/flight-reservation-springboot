package com.rariom.flightreservation.flightreservation.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.rariom.flightreservation.flightreservation.models.Reservation;
import org.springframework.stereotype.Component;
import java.io.FileOutputStream;

@Component // mark a utility class with @Component
public class PDFGenerator {

    public void generateItinerary(Reservation reservation, String filepath){

        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(filepath));
            document.add(generateTable(reservation)); // create a pdf table with 2 columns using a method
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private PdfPTable generateTable(Reservation reservation) {

        PdfPTable table = new PdfPTable(2);

        // create a column one at a time
        PdfPCell cell;

        // title
        cell = new PdfPCell(new Phrase("Flight Itinerary"));
        cell.setColspan(2);
        table.addCell(cell);

        // title for Flight Details
        cell = new PdfPCell(new Phrase("Flight Details"));
        cell.setColspan(2);
        table.addCell(cell);

        // body
        table.addCell("Operating Airline");
        table.addCell(reservation.getFlight().getOperatingAirlines());

        table.addCell("Departure City");
        table.addCell(reservation.getFlight().getDepartureCity());

        table.addCell("Arrival City");
        table.addCell(reservation.getFlight().getArrivalCity());

        table.addCell("Flight Number");
        table.addCell(reservation.getFlight().getFlightNumber());

        table.addCell("Date of Departure");
        table.addCell(reservation.getFlight().getDepartureDate().toString());

        table.addCell("Estimated Departure Time");
        table.addCell(reservation.getFlight().getEstimatedDepartureTime().toString());

        // title for Passenger Details
        cell = new PdfPCell(new Phrase("Passenger Details"));
        cell.setColspan(2);
        table.addCell(cell);

        table.addCell("First Name");
        table.addCell(reservation.getPassenger().getFirstName());

        table.addCell("Last Name");
        table.addCell(reservation.getPassenger().getLastName());

        table.addCell("Email");
        table.addCell(reservation.getPassenger().getEmail());

        table.addCell("Phone");
        table.addCell(reservation.getPassenger().getPhone());

        return null;
    }
}
