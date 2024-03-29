package net.mkersten.svlt2flux.flux.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import net.mkersten.svlt2flux.flux.entity.Message;
import reactor.core.publisher.Mono;

@Repository
public interface MessageRepository extends ReactiveCrudRepository<Message, String> {

    @Query("SELECT * FROM message WHERE topic = :topic LIMIT 1 ORDER BY timestamp DESC")
    Mono<Message> findFirstByTopic(String topic);

}
