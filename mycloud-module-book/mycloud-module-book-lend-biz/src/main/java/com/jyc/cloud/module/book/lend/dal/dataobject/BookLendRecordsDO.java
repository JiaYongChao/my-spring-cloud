package com.jyc.cloud.module.book.lend.dal.dataobject;

import com.jyc.cloud.framework.mybatis.core.dataobject.BaseDO;
import lombok.Data;

/**
 * @ClassNAME BookLendRecordsDO
 * @Description TODO
 * @Author jiayongchao
 * @Date 2024/1/13 21:13
 * @Version 1.0
 */
@Data
public class BookLendRecordsDO extends BaseDO {

    //借阅id
    private Long id;
    // 图书id
    private Long bookId;
    //用户id
    private Long userId;

    //借阅天数
    private Integer days;


}
