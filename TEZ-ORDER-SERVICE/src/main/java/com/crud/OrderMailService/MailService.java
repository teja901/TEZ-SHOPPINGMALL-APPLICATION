package com.crud.OrderMailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	@Autowired
	private JavaMailSender sender;
	
	public void sendMail(String to,String subject,String body) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(to);
		message.setText(subject);
		message.setText(body);
		sender.send(message);
	}
}
