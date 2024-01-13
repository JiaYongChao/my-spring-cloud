package com.jyc.cloud.module.book.lend.service;

import com.jyc.cloud.module.book.lend.controller.admin.book.lend.vo.BookLendReqVO;
import com.jyc.cloud.module.book.lend.controller.admin.book.lend.vo.BookLendSaveVO;

/**
 * @ClassNAME BookLendRecordsService
 * @Description TODO
 * @Author jiayongchao
 * @Date 2024/1/13 21:13
 * @Version 1.0
 */
public interface BookLendRecordsService {

    /**
     * @description: 用户还书
     * @author: JiaYongChao
     * @date: 2024/1/13 21:17
     * @param: [bookId 图书, bookUserId 书城用户]
     * @return: boolean
     **/
    boolean userReturnBook(BookLendReqVO bookLendReqVO);


    /**
     * @description:用户借书
     * @author: JiaYongChao
     * @date: 2024/1/13 21:18
     * @param: [bookId 图书, bookUserId 书城用户]
     * @return: boolean
     **/
    boolean userBorrowingBook(BookLendSaveVO bookLendSaveVO);


    /**
     * @description:判断用户借阅是否逾期
     * @author: JiaYongChao
     * @date: 2024/1/13 22:25
     * @param: [bookLendReqVO]
     * @return: boolean
     **/
    boolean bookLendIsOverdue(BookLendReqVO bookLendReqVO);

}
