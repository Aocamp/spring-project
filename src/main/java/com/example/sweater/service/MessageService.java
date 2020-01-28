package com.example.sweater.service;

import com.example.sweater.model.Message;
import com.example.sweater.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    public void save(String text, String tag) {
        messageRepository.save(new Message(text, tag));
    }

    public List<Message> findByTag(String tag) {
        return messageRepository.findByTag(tag);
    }
}
