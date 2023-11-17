package com.fahasa.service;

public interface EmailService {
	boolean sendEmail(String subject, String message, String to);
}
