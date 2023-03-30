package com.chatbot.model;

import lombok.Data;

@Data
public class ChatMessageRequest {
	private Integer userId;
	private String message;
}
