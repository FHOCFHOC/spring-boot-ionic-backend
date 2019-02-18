package com.corinto.mc.services;

import org.springframework.mail.SimpleMailMessage;

import com.corinto.mc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);

}
