package com.example.gettingstartedwithspringai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    private final ChatClient CHAT_CLIENT;

    public ChatController(ChatClient.Builder chatClient) {
        this.CHAT_CLIENT = chatClient.build();
    }

    @GetMapping
    public String introduction() {

        return CHAT_CLIENT.prompt()
                .user("introduce yourself")
                .call()
                .content();
    }
}
