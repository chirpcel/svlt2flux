package net.mkersten.svlt2flux.svlt.repository;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.mkersten.svlt2flux.svlt.entity.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, String> {

    @Query("SELECT * FROM message WHERE topic = :topic LIMIT 1 ORDER BY timestamp DESC")
    Optional<Message> findFirstByTopic(String topic);

}
