package com.chatbot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatbot.model.ChatMessage;
import com.chatbot.model.ChatMessageRequest;
import com.chatbot.service.ChatBotService;

@RestController
@RequestMapping("/chatbot")
@CrossOrigin(origins = "*")
public class ChatBotController {
	@Autowired
	private ChatBotService chatBotService;
	
	@PostMapping
	public ResponseEntity<ChatMessage> sentMessageController(@RequestBody ChatMessageRequest request){
//		String decodedMessage = URLDecoder.decode(message, StandardCharsets.UTF_8);
		return new ResponseEntity<ChatMessage>(chatBotService.sendMessage(request),HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<List<ChatMessage>> getChatHistoryController(@PathVariable Integer userId){
		return new ResponseEntity<List<ChatMessage>>(chatBotService.getChatHistory(userId),HttpStatus.OK);
	}
	
}
