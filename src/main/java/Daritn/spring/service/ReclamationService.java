package Daritn.spring.service;

import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Daritn.spring.entity.Reclamation;
import Daritn.spring.repository.ReclamationRepository;

@Service
public class ReclamationService implements IReclamationService {

		@Autowired
		ReclamationRepository ReclamationRepo;
		
		public List<Object> retrieveAllReclamation() {
			return ReclamationRepo.groupReclamations();
		}

		@Override
		public Reclamation addReclamation(Reclamation c) {
			mailling("imen.mansouri@esprit.tn","Votre reclamation a ete envoyer nous repondorons après 72hrs" );
			return ReclamationRepo.save(c); 
		}

		@Override
		public String deleteReclamation(Integer id) {
			if(ReclamationRepo.findById(id).orElse(null) != null) {
				ReclamationRepo.deleteById(id);
				return "Reclamation removed successfully!";
			}
			else return "Reclamation id not found!";
		}

		@Override
		public Reclamation updateidReclamation(Reclamation c) {
			return ReclamationRepo.save(c);
		}

		

		@Override
		public Reclamation retrieveidReclamation(int idR) {
			return ReclamationRepo.findById(idR).orElse(null);
		}

		public void mailling(String mail,String message) {
		    final String username = "noreplypidev4@gmail.com";
		    final String password = "Pidev123456";
		    String fromEmail = "noreplypidev4@gmail.com";
		    Properties properties = new Properties();
		    properties.put("mail.smtp.auth", "true");
		    properties.put("mail.smtp.starttls.enable", "true");
		    properties.put("mail.smtp.host", "smtp.gmail.com");
		    properties.put("mail.smtp.port", "587");
		    Session session = Session.getInstance(properties,new Authenticator() {
		        @Override
		        protected PasswordAuthentication getPasswordAuthentication() {
		            return new PasswordAuthentication(username,password);
		        }
		    });
		    MimeMessage msg = new MimeMessage(session);
		    try {
		        msg.setFrom(new InternetAddress(username));
		        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));
		        msg.setSubject("Reclamation");
		        Multipart emailContent = new MimeMultipart();
		        MimeBodyPart textBodyPart = new MimeBodyPart();
		        textBodyPart.setText(message);
		        emailContent.addBodyPart(textBodyPart);
		        msg.setContent(emailContent);
		        Transport.send(msg);
		        System.out.println("Sent message");
		    } catch (MessagingException e) {
		        e.printStackTrace();
		    }
		}

	
}
