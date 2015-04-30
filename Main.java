package project;

import java.util.ArrayList;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Main {

	public static void main(String[] args)  {

// public static void Send(final String username, final String password, String recipientEmail, String title, String message) throws AddressException, MessagingException {
//		GoogleMail.Send(username, password, recipientEmail, "", title, message);
//	}
		GoogleMail gm = new GoogleMail();
		try {
			gm.Send("b.madane","309030","bhm9041@rit.edu","This emial fro the our methods","Msseage body cheer and good night you can check" +
					"the documentatio I only add definition of public ");
		} catch (MessagingException e) {
			e.printStackTrace();
		}


//		// Recipient's email ID needs to be mentioned.
//		String to = "b.madane@gmail.com";
//
//		// Sender's email ID needs to be mentioned
//		String from = "b.madane@gmail.com";
//
//		// Assuming you are sending email from localhost
//		String host = "";
//
//		// Get system properties
//		Properties properties = System.getProperties();
//
//		// Setup mail server
//		properties.setProperty("mail.smtp.host", host);
//
//		// Get the default Session object.
//		Session session = Session.getDefaultInstance(properties);
//
//		try{
//			// Create a default MimeMessage object.
//			MimeMessage message = new MimeMessage(session);
//
//			// Set From: header field of the header.
//			message.setFrom(new InternetAddress(from));
//
//			// Set To: header field of the header.
//			message.addRecipient(Message.RecipientType.TO,
//					new InternetAddress(to));
//
//			// Set Subject: header field
//			message.setSubject("This is the Subject Line!");
//
//			// Now set the actual message
//			message.setText("This is actual message");
//
//			// Send message
//			Transport.send(message);
//			System.out.println("Sent message successfully....");
//		}catch (MessagingException mex) {
//			mex.printStackTrace();
//		}






	}



	}


