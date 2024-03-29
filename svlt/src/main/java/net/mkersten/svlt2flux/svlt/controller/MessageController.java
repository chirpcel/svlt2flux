package net.mkersten.svlt2flux.svlt.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import net.mkersten.svlt2flux.svlt.entity.Message;
import net.mkersten.svlt2flux.svlt.service.MessageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/message/{topic}")
    public ResponseEntity<String> getMessage(@PathVariable String topic) {
        Optional<Message> message = messageService.getMessage(topic);
        return message
                .map(m -> ResponseEntity.ok(m.getValue()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/message/{topic}")
    public void postMethodName(@PathVariable String topic, @RequestBody String message) {

    }

}
