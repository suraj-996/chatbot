package com.chatbot.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatbot.model.ChatMessage;
import com.chatbot.model.ChatMessageRequest;
import com.chatbot.model.Customer;
import com.chatbot.repository.ChatMessageRepo;
import com.chatbot.repository.CustomerRepository;



@Service
public class ChatBotService {
	@Autowired
	private ChatMessageRepo chatMessageRepo;

	@Autowired
	private CustomerRepository customerRepository;
	public static ChatMessage generateResponse(Customer customer,String message) {
		Map<String, String> conversation = new HashMap<>();
		
		conversation.put("hi", "Hello there! How can I assist you today?");
		conversation.put("how are you", "I'm doing well, thank you. How about you?");
		conversation.put("what's your name", "My name is Chatbot.");
		conversation.put("what do you do", "I'm here to assist you with whatever you need!");
		conversation.put("what's the weather like", "I'm sorry, I don't have access to that information.");
		conversation.put("what's your favorite color", "As a chatbot, I don't have personal preferences for colors.");
		conversation.put("what's your favorite food",
				"As a chatbot, I don't have the ability to eat, so I don't have a favorite type of cuisine.");
		conversation.put("what's your favorite holiday",
				"As a chatbot, I don't celebrate holidays, but I'm always available to chat!");
		conversation.put("what's your favorite type of weather",
				"As a chatbot, I don't have personal preferences for weather.");
		conversation.put("what's your favorite type of technology",
				"As a chatbot, I don't have personal preferences for technology.");
		conversation.put("what's your favorite language",
				"As a chatbot, I don't have personal preferences for languages.");
		conversation.put("what's your favorite country",
				"As a chatbot, I don't have personal preferences for countries.");
		conversation.put("what's your favorite type of art",
				"As a chatbot, I don't have personal preferences for types of art.");
		conversation.put("what's your favorite type of movie genre",
				"As a chatbot, I don't have personal preferences for movie genres.");
		conversation.put("what's your favorite type of TV show",
				"As a chatbot, I don't have personal preferences for TV shows.");
		conversation.put("what's your favorite type of video game",
				"As a chatbot, I don't have personal preferences for video games.");
		conversation.put("what's your favorite type of book",
				"As a chatbot, I don't have personal preferences for books.");
		conversation.put("what's your favorite thing to talk about",
				"I enjoy having conversations about all sorts of topics, so feel free to talk about whatever you like!");
		conversation.put("what's your favorite type of conversation",
				"As a chatbot, I don't have personal preferences for types of conversations.");
		conversation.put("what's your favorite type of question",
				"As a chatbot, I don't have personal preferences for types of questions.");
		conversation.put("what's your favorite type of answer",
				"As a chatbot, I don't have personal preferences for types of answers.");
		conversation.put("what's your favorite type of chat", "As a chatbot, I enjoy all types of chats!");
		conversation.put("what's your favorite thing to do",
				"As a chatbot, my favorite thing to do is to help people like you!");
		conversation.put("what do you think of artificial intelligence",
				"As a chatbot, I'm an example of artificial intelligence, so I think it's pretty cool!");
		conversation.put("what's your favorite quote", "As a chatbot, I don't have personal preferences for quotes.");
		conversation.put("what do you think about the meaning of life",
				"As a chatbot, I don't have personal beliefs or opinions.");
		conversation.put("what's your favorite type of music",
				"As a chatbot, I don't have personal preferences for types of music.");
		conversation.put("what's your favorite type of instrument",
				"As a chatbot, I don't have personal preferences for types of instruments.");
		conversation.put("what do you think about the future",
				"As a chatbot, I don't have the ability to predict the future, but I'm here to help you in the present!");
		conversation.put("what do you think about technology",
				"As a chatbot, I'm an example of technology, so I think it's pretty amazing!");
		conversation.put("what do you think about robots",
				"As a chatbot, I'm an example of a robot, so I think robots are pretty cool!");
		conversation.put("what do you think about virtual reality",
				"As a chatbot, I think virtual reality is a fascinating technology!");
		conversation.put("what do you think about the internet",
				"As a chatbot, I think the internet is an amazing tool for communication and information-sharing.");
		conversation.put("what's your favorite type of animal",
				"As a chatbot, I don't have personal preferences for types of animals.");
		conversation.put("what's your favorite type of plant",
				"As a chatbot, I don't have personal preferences for types of plants.");
		conversation.put("what's your favorite type of food",
				"As a chatbot, I don't have the ability to eat, so I don't have a favorite type of cuisine.");
		conversation.put("what's your favorite type of drink",
				"As a chatbot, I don't have the ability to drink, so I don't have a favorite type of beverage.");
		conversation.put("what do you like to do in your free time",
				"As a chatbot, I don't have the ability to experience free time, as I'm always available to chat!");
		conversation.put("what's your favorite type of sport",
				"As a chatbot, I don't have personal preferences for types of sports.");
		conversation.put("what do you think about space exploration",
				"As a chatbot, I think space exploration is an exciting and important field of study.");
		conversation.put("what do you think about climate change",
				"As a chatbot, I don't have personal beliefs or opinions, but I recognize that climate change is an important issue.");
		conversation.put("what do you think about politics",
				"As a chatbot, I don't have personal beliefs or opinions about politics, but I recognize that it's an important and often controversial topic.");
		conversation.put("what do you think about religion",
				"As a chatbot, I don't have personal beliefs or opinions about religion, but I recognize that it's an important and often sensitive topic.");
		conversation.put("what's your favorite type of book genre",
				"As a chatbot, I don't have personal preferences for book genres.");
		conversation.put("what do you think about education",
				"As a chatbot, I think education is important and valuable for personal growth and development.");
		conversation.put("what do you think about social media",
				"As a chatbot, I think social media is a powerful tool for communication and connection, but it's important to use it responsibly.");
		conversation.put("what's your favorite type of game",
				"As a chatbot, I don't have personal preferences for types of games.");
		conversation.put("what is java", "Java is a high-level, object-oriented programming language that was developed by Sun Microsystems and released in 1995.Java code is compiled into bytecode, which can be run on any platform that has a Java Virtual Machine (JVM) installed.");
		String response = conversation.getOrDefault(message.toLowerCase(),
				"I'm sorry, I didn't have answer of this question.");
		
		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setMessage(message);
		chatMessage.setResponse(response);
		chatMessage.setTimestamp(LocalDateTime.now());
		chatMessage.setCustomer(customer);
		return chatMessage;
	}

	public ChatMessage sendMessage(ChatMessageRequest request) {
		Customer customer=customerRepository.findById(request.getUserId()).orElseThrow(()->new RuntimeException("user not found"));
		ChatMessage chatMessage = generateResponse(customer,request.getMessage());
		ChatMessage chatMessageResponse = chatMessageRepo.save(chatMessage);
		return chatMessageResponse;
	}

	public List<ChatMessage> getChatHistory(Integer userId) {
		Customer customer = customerRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return chatMessageRepo.findByCustomer(customer);
	}
	
}
