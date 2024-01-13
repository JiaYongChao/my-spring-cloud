package com.jyc.cloud.module.book.lend.mq.producer;

import com.jyc.cloud.framework.common.core.KeyValue;
import com.jyc.cloud.module.book.lend.mq.message.BookLendMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassNAME BookProducer
 * @Description TODO
 * @Author jiayongchao
 * @Date 2024/1/13 21:39
 * @Version 1.0
 */
@Slf4j
@Component
public class BookLendProducer {
    @Resource
    private KafkaTemplate<Object, Object> kafkaTemplate; // 重点：注入 KafkaTemplate 对象


    public void sendLendBookMessage(Long userId,Long bookId) {
        BookLendMessage message = new BookLendMessage();
        message.setUserId(userId);
        message.setBookId(bookId);
        kafkaTemplate.send(BookLendMessage.TOPIC, message); // 重点：使用 KafkaTemplate 发送消息
    }
}
