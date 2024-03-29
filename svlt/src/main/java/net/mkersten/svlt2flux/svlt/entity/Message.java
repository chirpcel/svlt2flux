package net.mkersten.svlt2flux.svlt.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table("svlt_message")
public class Message {

    @Id
    private String id;

    private String topic;

    private String value;

    private final Long timestamp = System.currentTimeMillis();

}
