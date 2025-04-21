package Patrol.utilities;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.*;

public class EmailUtility {

    // sender
    private static final String SENDER_EMAIL = "krishna.jaiswal@legitquest.com";
    private static final String SENDER_PASSWORD = "ehcs rtfm tbpk zfbp";

    // recipients
    private static final List<String> DEFAULT_RECIPIENTS = Arrays.asList("krishnajs100@gmail.com");

    public static void sendEmailWithFileAttachment(String subject, String messageBody, List<String> recipients, List<File> attachments) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SENDER_EMAIL, SENDER_PASSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(SENDER_EMAIL));
            for (String recipient : recipients) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            }
            message.setSubject(subject);

            // Body
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(messageBody, "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            // Attach screenshots
            if (attachments != null && !attachments.isEmpty()) {
                for (File file : attachments) {
                    MimeBodyPart filePart = new MimeBodyPart();
                    filePart.attachFile(file);
                    multipart.addBodyPart(filePart);
                }
            }
            
            message.setContent(multipart);
            Transport.send(message);
            System.out.println("Email Sent Successfully with Screenshot(s)!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Email Sending Failed!");
        }
    }

    public static void sendFailureScreenshots(String subject, String message, List<File> screenshotFiles) throws MessagingException {
        List<String> recipients = DEFAULT_RECIPIENTS;

        StringBuilder emailBody = new StringBuilder();
        emailBody.append("<h2 style='color:red;'>Patrol Automation Failure Report</h2>");
        emailBody.append("<h3> QA : <b>Krishna Jaiswal</b></h3>");
        emailBody.append("<p>").append(message).append("</p>");
        emailBody.append("<br><b>Attached: Failure Screenshot(s)</b><br>");

        sendEmailWithFileAttachment(subject, emailBody.toString(), recipients, screenshotFiles);
    }
}