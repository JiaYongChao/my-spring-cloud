package com.jyc.cloud.module.book.lend.mq.producer;

import com.jyc.cloud.framework.common.core.KeyValue;
import com.jyc.cloud.framework.common.util.json.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String,Object> map = new HashMap<>();
        map.put("bookId",bookId);
        map.put("userId",userId);
        String josnMessage = JsonUtils.toJsonString(map);
        kafkaTemplate.send("BOOK_LEND_TOPIC", josnMessage); // 重点：使用 KafkaTemplate 发送消息
    }
}
