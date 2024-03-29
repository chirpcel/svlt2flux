package net.mkersten.svlt2flux.svlt.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.mkersten.svlt2flux.svlt.entity.Message;
import net.mkersten.svlt2flux.svlt.repository.MessageRepository;

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
    public Optional<Message> getMessage(String topic) {
        var message = messageRepository.findFirstByTopic(topic);
        message.ifPresent(m -> messageRepository.deleteById(m.getId()));
        return message;
    }

}
