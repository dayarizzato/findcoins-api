package br.com.blockchain.api.service.impl;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import br.com.blockchain.api.service.SendEmailService;

@Service
public class SendEmailServiceImpl implements SendEmailService {
	
	@Value("${gmail.user}")
	private String user;
	
	@Value("${gmail.password}")
	private String password;

	@Override
	public void send(final String email, final String newPassword) throws Exception {
		try {
			Session session = this.getSession( this.getPropertiesHostSmtp());
		    session.setDebug(true);
		    Message message = new MimeMessage(session);
		    message.setFrom(new InternetAddress(user));
		    Address[] toUser = InternetAddress.parse(email);
		    message.setRecipients(Message.RecipientType.TO, toUser);
		    message.setSubject("Recuperação de conta Find'Coins");
		    message.setText(String.format(CORPO_EMAIL, email, newPassword));
		    Transport.send(message);
	     } catch (MessagingException e) {
	        throw new RuntimeException(e);
	    }
	}
	
	private Session getSession(final Properties properties) {
		return Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
	           protected PasswordAuthentication getPasswordAuthentication() {
	                 return new PasswordAuthentication(user, password);
	           }
	      });
	}
	
	private Properties getPropertiesHostSmtp() {
		final Properties props = new Properties();
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.socketFactory.port", "465");
	    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.port", "465");
	    return props;
	}

}
