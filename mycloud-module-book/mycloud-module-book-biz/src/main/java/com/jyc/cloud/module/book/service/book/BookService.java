package com.jyc.cloud.module.book.service.book;

import com.jyc.cloud.framework.common.pojo.PageResult;
import com.jyc.cloud.module.book.controller.admin.book.vo.BookPageReqVO;
import com.jyc.cloud.module.book.controller.admin.book.vo.BookSaveReqVO;
import com.jyc.cloud.module.book.dal.dataobject.book.BookDO;
import com.jyc.cloud.module.book.mq.message.BookLendMessage;

/**
 * @ClassNAME BookService
 * @Description 图书接口类
 * @Author jiayongchao
 * @Date 2024/1/13 19:47
 * @Version 1.0
 */
public interface BookService {

    /**
     * 创建图书
     *
     * @param createReqVO 图书
     * @return 编号
     */
    Long createBook(BookSaveReqVO createReqVO);

    /**
     * 更新图书
     *
     * @param reqVO 图书
     */
    void updateBook(BookSaveReqVO reqVO);

    /**
     * 删除图书
     *
     * @param id 编号
     */
    void deleteBook(Long id);

    /**
     * 获得图书分页列表
     *
     * @param reqVO 分页条件
     * @return 部门分页列表
     */
    PageResult<BookDO> getBookPage(BookPageReqVO reqVO);

    /**
     * 获得图书
     *
     * @param id 编号
     * @return 图书
     */
    BookDO getBook(Long id);

    /**
     * @description: 更新图书信息
     * @author: JiaYongChao
     * @date: 2024/1/13 21:53
     * @param: [message]
     * @return: boolean
     **/
    boolean updateBookInfo(BookLendMessage message);
}
