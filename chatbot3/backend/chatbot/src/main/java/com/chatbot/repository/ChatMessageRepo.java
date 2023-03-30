package com.chatbot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chatbot.model.ChatMessage;
import com.chatbot.model.Customer;



public interface ChatMessageRepo extends JpaRepository<ChatMessage, Integer>{
	List<ChatMessage> findByCustomer(Customer customer);
}
