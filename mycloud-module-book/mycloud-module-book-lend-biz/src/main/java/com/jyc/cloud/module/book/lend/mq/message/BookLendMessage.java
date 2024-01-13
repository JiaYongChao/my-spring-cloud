package com.jyc.cloud.module.book.lend.mq.message;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassNAME BookLendMessage
 * @Description TODO
 * @Author jiayongchao
 * @Date 2024/1/13 21:45
 * @Version 1.0
 */
@Data
public class BookLendMessage implements Serializable {
    public static final String TOPIC = "BOOK_LEND_TOPIC"; // 重点：需要增加消息对应的 Topic


    private Long userId;


    private Long bookId;


}
