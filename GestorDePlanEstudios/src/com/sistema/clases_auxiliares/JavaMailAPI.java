package com.sistema.clases_auxiliares;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;

/**
 * Claser que implementa la API de correos de Java para enviar correos electronicos adjuntando archvios
 * @author Marco Reveiz
 * @version 1.0
 */

public class JavaMailAPI {
    /**
     *
     * @param nombreEstudiante nombre del estudiante
     * @param email mail del correo a enviar
     * @throws Exception si no puede enviar el correo
     */
    public static void enviarCorreo (String nombreEstudiante, String email) throws Exception{
        Properties properties = new Properties();
        properties.put("mail.smtp.auth",true);
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port",587);
        properties.put("mail.smtp.starttls.enable",true);
        properties.put("mail.transport.protocl","smtp");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("eatsdeliveryapp@gmail.com","Reque2021");
            }
        });
        //Crea mensaje
        Message message = new MimeMessage(session);
        message.setSubject("Plan de Estudios de " + nombreEstudiante);

        //Settea la direccion a la cual se va a enviar el correo
        Address address = new InternetAddress(email);
        message.setRecipient(Message.RecipientType.TO, address);

        //Agrega los archivos adjuntos
        MimeBodyPart attachment = new MimeBodyPart();
        //Busca el path
        File file = new File(System.getProperty("user.dir") + "\\src\\com\\sistema\\pdfs\\"+ "PlanEstudio" + nombreEstudiante.replaceAll("\\s", "") + ".pdf");
        String path = file.getAbsolutePath();
        attachment.attachFile(path);
        MimeBodyPart attachment2 = new MimeBodyPart();
        attachment2.setContent("En el archivo adjunto se encuentra el reporte del plan de estudios del estudiante "+ nombreEstudiante,"text/html");
        MimeMultipart multipart = new MimeMultipart();
        multipart.addBodyPart(attachment);
        multipart.addBodyPart(attachment2);
        message.setContent(multipart);
        //Envio de correo
        Transport.send(message);
        System.out.println("Correo enviado!");

    }




}

