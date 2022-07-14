package com.semanareact.myapp.service;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.semanareact.myapp.model.Sale;
import com.semanareact.myapp.repository.SaleRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {

	
	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;
	
	@Autowired
	private SaleRepository repository;

	public void sendSms(Long id) {

		Twilio.init(twilioSid, twilioKey);

		Sale sale = repository.findById(id).get();
		
		
		sale.getDate().getMonth();
		
		StringBuilder msg = new StringBuilder(" O Vendedor: ");
		msg.append(sale.getSellerName());
		msg.append(" Foi Destaque de vendas em ");
		msg.append(sale.getDate().getMonth() +"/"+sale.getDate().getYear());
		
		
		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

		Message message = Message.creator(to, from, msg.toString()).create();

		System.out.println(message.getSid());
	}
	
	
}
