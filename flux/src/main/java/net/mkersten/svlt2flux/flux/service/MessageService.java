package net.mkersten.svlt2flux.flux.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.mkersten.svlt2flux.flux.entity.Message;
import net.mkersten.svlt2flux.flux.repository.MessageRepository;
import reactor.core.publisher.Mono;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Transactional
    public void createMessage(String topic, String value) {
        UUID uuid = UUID.randomUUID();
        Message message = Message.builder()
                .id(uuid.toString())
                .topic(topic)
                .value(value)
                .build();
        messageRepository.save(message);
    }

    @Transactional
    public Mono<Message> getMessage(String topic) {
        return messageRepository.findFirstByTopic(topic)
                .doOnNext(m -> messageRepository.deleteById(m.getId()));
    }

}
