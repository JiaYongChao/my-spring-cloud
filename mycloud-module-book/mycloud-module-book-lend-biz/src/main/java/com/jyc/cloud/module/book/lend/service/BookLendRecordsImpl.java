package com.jyc.cloud.module.book.lend.service;

import com.jyc.cloud.framework.common.util.date.DateUtils;
import com.jyc.cloud.framework.common.util.object.BeanUtils;
import com.jyc.cloud.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.jyc.cloud.module.book.lend.controller.admin.book.lend.vo.BookLendReqVO;
import com.jyc.cloud.module.book.lend.controller.admin.book.lend.vo.BookLendSaveVO;
import com.jyc.cloud.module.book.lend.dal.dataobject.BookLendRecordsDO;
import com.jyc.cloud.module.book.lend.dal.mysql.BookLendRecordsMapper;
import com.jyc.cloud.module.book.lend.mq.producer.BookLendProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @ClassNAME BookLendRecordsImpl
 * @Description TODO
 * @Author jiayongchao
 * @Date 2024/1/13 21:14
 * @Version 1.0
 */
@Service
@Slf4j
public class BookLendRecordsImpl implements BookLendRecordsService {

    @Resource
    private BookLendRecordsMapper bookLendRecordsMapper;
    @Resource
    private BookLendProducer bookLendProducer;

    @Override
    public boolean userReturnBook(BookLendReqVO bookLendReqVO) {

        BookLendRecordsDO bookLendRecordsDO = new BookLendRecordsDO();
        bookLendRecordsDO.setUserId(bookLendReqVO.getUserId());
        bookLendRecordsDO.setBookId(bookLendReqVO.getBookId());
        //删除数据库中user_d等于userId,book_id等于bookId的记录
        int n = bookLendRecordsMapper.deleteById(bookLendRecordsDO);
        if (n > 0) return true;
        return false;
    }

    @Override
    public boolean userBorrowingBook(BookLendSaveVO bookLendSaveVO) {
        Long bookId = bookLendSaveVO.getBookId();
        //检查该书是否可借,从借书记录表中查询该书是否已借出
        List<BookLendRecordsDO> list = bookLendRecordsMapper.selectList("bookId", bookId);
        if (list.size() > 0) {
            return false;
        }
        BookLendRecordsDO updateObj = BeanUtils.toBean(bookLendSaveVO, BookLendRecordsDO.class);
        //数据库中增加一条借书记录
        int n = bookLendRecordsMapper.insert(updateObj);
        //生产信息
        bookLendProducer.sendLendBookMessage(bookLendSaveVO.getUserId(), bookLendSaveVO.getBookId());
        if (n > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean bookLendIsOverdue(BookLendReqVO bookLendReqVO) {
        //查询用户的借阅信息，如果借阅借阅时间，加借阅时长 超过了，则判断未逾期
        List<BookLendRecordsDO> bookLendRecordsList =  bookLendRecordsMapper.selectList(new LambdaQueryWrapperX<BookLendRecordsDO>()
                .eqIfPresent(BookLendRecordsDO::getUserId, bookLendReqVO.getUserId())
                .eqIfPresent(BookLendRecordsDO::getBookId, bookLendReqVO.getBookId()));
        if (bookLendRecordsList != null && bookLendRecordsList.size()>0) {
            BookLendRecordsDO bookLendRecords = bookLendRecordsList.get(0);
            int days = bookLendRecords.getDays();
            LocalDateTime lendDateTime = bookLendRecords.getCreateTime();
            LocalDateTime returnDateTime = lendDateTime.plusDays(days);
            Date returnDate = DateUtils.of(returnDateTime);
            boolean isOverdue = DateUtils.isExpired(returnDate);
            return isOverdue;
        }
        return false;
    }
}
