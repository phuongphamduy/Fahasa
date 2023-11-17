package com.fahasa.service.impl;

import java.util.Properties;

import org.springframework.stereotype.Service;

import com.fahasa.service.EmailService;

import jakarta.mail.*;
import jakarta.mail.internet.*;

@Service
public class EmailServiceImpl implements EmailService {
	@Override
	public boolean sendEmail(String subject, String message, String to) {
		boolean f = false;
		String from = "thth1732003@gmail.com";

		String host = "smtp.gmail.com";

		Properties properties = System.getProperties();
		System.out.println("Properties " + properties);

		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(properties, new Authenticator() {
		    @Override
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication("thth1732003@gmail.com", "ogenqvwzwywiercl");
		    }
		});

		session.setDebug(true);

		MimeMessage m = new MimeMessage(session);

		try {
			m.setFrom(from);

			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			m.setSubject(subject);

			m.setText(message);

			Transport.send(m);
			
			f = true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return f;
	}

}
