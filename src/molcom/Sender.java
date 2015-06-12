package molcom;

import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Sender {

	private String username;
	private String password;
	private Properties props;
	private String fromEmail;


	public Sender() {

		this.username = "molcom/onec";
		this.password = "y330kxv";
		this.fromEmail = "1c@molcom.ru";

		props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "mail.molcom.ru");
		props.put("mail.smtp.port", "25");

	}

	public void send(String subject, String text, ArrayList<String> toEmails) {
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			//session.setDebug(true);
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(this.fromEmail));
			InternetAddress[] address = new InternetAddress[toEmails.size()];
			for (int i = 0; i <= toEmails.size() - 1; i++) {
				address[i] = new InternetAddress(toEmails.get(i));
			}
			message.setRecipients(Message.RecipientType.TO, address);
			message.setSubject(subject);
			message.setText(text);

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}