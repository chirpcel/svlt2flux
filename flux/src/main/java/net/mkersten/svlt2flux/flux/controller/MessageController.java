package net.mkersten.svlt2flux.flux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import net.mkersten.svlt2flux.flux.entity.Message;
import net.mkersten.svlt2flux.flux.service.MessageService;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/message/{topic}")
    public Mono<String> getMessage(@PathVariable String topic) {
        return messageService.getMessage(topic).map(Message::getValue);
    }

    @PostMapping("/message/{topic}")
    public void postMethodName(@PathVariable String topic, @RequestBody String message) {

    }

}
