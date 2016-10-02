package com.detrraxic.jaxrs.service;

import com.detrraxic.jaxrs.database.DatabaseClass;
import com.detrraxic.jaxrs.model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MessageService {

    private Map<Long, Message> messages = DatabaseClass.getMessages();

    public MessageService() {
        messages.put(1L, new Message(1, "Hello World", "dusan"));
        messages.put(2L, new Message(2, "Hello World", "roberto"));
        messages.put(3L, new Message(3, "Hello World", "agneszka"));
    }

    public List<Message> getAllMessages(){

        return new ArrayList<>(messages.values());
    }

    public Message getMessage(long id){
        return messages.get(id);
    }

    public Message addMessage(Message message) {
        message.setId(messages.size() + 1);
        messages.put(message.getId(), message);
        return message;
    }

    public Message updateMessage(Message message){
        if (message.getId() <= 0) {
            return null;
        }
        messages.put(message.getId(), message);
        return message;
    }

    public Message removeMessage(long id) {
        return messages.remove(id);
    }
}
