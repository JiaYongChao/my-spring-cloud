package com.jyc.cloud.module.book.mq.consumer;

import com.jyc.cloud.module.book.mq.message.BookLendMessage;
import com.jyc.cloud.module.book.service.book.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassNAME BookLendConsumer
 * @Description TODO
 * @Author jiayongchao
 * @Date 2024/1/13 21:47
 * @Version 1.0
 */
@Component
@Slf4j
public class BookLendConsumer {

    @Resource
    private BookService bookService;

    @KafkaListener(topics = BookLendMessage.TOPIC, // 重点：添加 @KafkaListener 注解，实现消息的消费
            groupId = BookLendMessage.TOPIC + "_CONSUMER")
    public void onMessage(BookLendMessage message) {
        log.info("[onMessage][消息内容({})]", message);
        bookService.updateBookInfo(message);
    }
}
