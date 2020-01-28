package com.example.sweater.controller;

import com.example.sweater.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/greeting")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        model.put("messages", messageService.getAll());
        return "main";
    }

    @PostMapping("/main")
    public String addMessage(
            @RequestParam String text,
            @RequestParam String tag) {
        messageService.save(text, tag);
        return "main";
    }

    @PostMapping("filter")
    public String filter(
            @RequestParam String tag,
            Map<String, Object> model
    ) {
        model.put("messages", messageService.findByTag(tag));
        return "main";
    }

}
