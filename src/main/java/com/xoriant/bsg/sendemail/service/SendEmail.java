package com.xoriant.bsg.sendemail.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class SendEmail {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Value("${spring.mail.username}")
	private String from;
	
	@Value("${mail.subject}")
	private String subject;
	
	@Value("${mail.cc}")
	private String cc;
	
//	@Value("${mail.to}")
//	private String to;
//	
//	@Value("${mail.body}")
//	private String body;

	@Autowired
	private JavaMailSender mailSender;
	
//	@PostConstruct
//	public void init(){
////		sendMail();
//		sendAttachmentMessage();
//	}

//	private void sendMail() {
//		logger.info("Send mail from-[{}] to-[{}] with subject-[{}]",from ,to, subject);
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setSubject(subject);
//		message.setFrom(from);
//		message.setTo(to);
//		message.setText(body);
//		mailSender.send(message);
//		logger.info("Mail sent successfully");
//	}
	
//	public void sendAttachmentMessage() {
//
//		MimeMessage message = mailSender.createMimeMessage();
//
//		MimeMessageHelper helper = null;
//		try {
//			helper = new MimeMessageHelper(message, true);
//			
//			helper.setSubject(subject);
//			helper.setFrom(from);
//			
//			if(StringUtils.isEmpty(to)) {
//				helper.setTo(from);
//			} else {
//				helper.setTo(to.split(","));
//			}
//			
//			helper.setText(body, true);
//			
//		} catch (MessagingException e) {
//			logger.info("Error sending email with attachment.", e);
//		}
//
//		mailSender.send(message);
//		logger.info("Mail sent successfully.");
//	}
	
	public void sendAttachmentMessage(String recipient, String emailBody) {

		MimeMessage message = mailSender.createMimeMessage();

		MimeMessageHelper helper = null;
		try {
			helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setSubject(subject);
			helper.setCc(cc);
			helper.setTo(recipient);			
			helper.setText(emailBody, true);
			
		} catch (MessagingException e) {
			logger.info("sending email to:[{}] failed with error [{}]", recipient, e);
		}
		mailSender.send(message);
		logger.info("Mail sent successfully.to: [{}] with cc: [{}]", recipient, cc);
	}

}
