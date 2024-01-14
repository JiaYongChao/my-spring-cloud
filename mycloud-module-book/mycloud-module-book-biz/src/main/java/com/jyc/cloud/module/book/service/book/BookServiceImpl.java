package com.jyc.cloud.module.book.service.book;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.google.common.annotations.VisibleForTesting;
import com.jyc.cloud.framework.common.pojo.PageResult;
import com.jyc.cloud.framework.common.util.object.BeanUtils;
import com.jyc.cloud.module.book.controller.admin.book.vo.BookPageReqVO;
import com.jyc.cloud.module.book.controller.admin.book.vo.BookSaveReqVO;
import com.jyc.cloud.module.book.dal.dataobject.book.BookDO;
import com.jyc.cloud.module.book.dal.mysql.book.BookMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static com.jyc.cloud.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.jyc.cloud.module.system.enums.ErrorCodeConstants.NOTICE_NOT_FOUND;

/**
 * @ClassNAME BookServiceImpl
 * @Description 图书接口实现类
 * @Author jiayongchao
 * @Date 2024/1/13 19:48
 * @Version 1.0
 */
@Service
@Validated
@Slf4j
public class BookServiceImpl implements  BookService {

    @Resource
    private BookMapper bookMapper;
    @Override
    public Long createBook(BookSaveReqVO createReqVO) {
        BookDO bookDO = BeanUtils.toBean(createReqVO, BookDO.class);
        bookMapper.insert(bookDO);
        return bookDO.getBookId();
    }

    @Override
    public void updateBook(BookSaveReqVO reqVO) {
        // 校验是否存在
        validateNoticeExists(reqVO.getBookId());
        // 更新通知公告
        BookDO updateObj = BeanUtils.toBean(reqVO, BookDO.class);
        bookMapper.updateById(updateObj);
    }

    @Override
    public void deleteBook(Long id) {
        // 校验是否存在
        validateNoticeExists(id);
        // 删除通知公告
        bookMapper.deleteById(id);
    }

    @Override
    public PageResult<BookDO> getBookPage(BookPageReqVO reqVO) {

        return bookMapper.selectPage(reqVO);
    }

    @Override
    public BookDO getBook(Long id) {
        return bookMapper.selectById(id);
    }

    @Override
    public boolean updateBookInfo(BookDO bookDO) {

        Long bookId = bookDO.getBookId();
        BookDO oldbookDO = bookMapper.selectOne("book_id",bookId);
        oldbookDO.setBookStock(oldbookDO.getBookStock()-1);
        oldbookDO.setStatus(1);
        // 作为查询条件
        UpdateWrapper<BookDO> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("book_id", bookId);
        bookMapper.update(oldbookDO,updateWrapper);
        return true;
    }

    @VisibleForTesting
    public void validateNoticeExists(Long id) {
        if (id == null) {
            return;
        }
        BookDO bookDO = bookMapper.selectById(id);
        if (bookDO == null) {
            throw exception(NOTICE_NOT_FOUND);
        }
    }
}
