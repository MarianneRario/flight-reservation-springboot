package com.rariom.flightreservation.flightreservation.util;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component // mark a utility class with @Component
public class EmailUtil {

    // inject the java mail sender to send email
    @Autowired
    private JavaMailSender sender;
    /**
     * @param address
     * @param filepath path the generated itinerary (PDFGenerator) generates
     */
    public void sendItinerary(String address, String filepath){
        // MIME - Multipurpose Internet Mail Extension
        MimeMessage message = sender.createMimeMessage();

        try {
            // create the body inside the createMimeMessage using MimeMessageHelper
            // since we have attachments we need to emphasize that multipart is "true"
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(address);
            helper.setSubject("Itinerary for your Flight");
            helper.setText("Please find your itinerary attached.");
            helper.addAttachment("Itinerary", new File(filepath)); // part of "multipart"; won't be seen by the client
            sender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

}
