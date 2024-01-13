package com.jyc.cloud.module.book.service.category;

import com.jyc.cloud.framework.common.util.object.BeanUtils;
import com.jyc.cloud.module.book.controller.admin.book.category.vo.BookCategorySaveReqVO;
import com.jyc.cloud.module.book.dal.dataobject.book.BookDO;
import com.jyc.cloud.module.book.dal.dataobject.category.BookCategoryDO;
import com.jyc.cloud.module.book.dal.mysql.category.BookCategoryMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

/**
 * @ClassNAME BookCategoryServiceImpl
 * @Description TODO
 * @Author jiayongchao
 * @Date 2024/1/13 20:44
 * @Version 1.0
 */
@Service
@Slf4j
public class BookCategoryServiceImpl implements  BookCategoryService{

    @Resource
    private BookCategoryMapper bookCategoryMapper;
    @Override
    public Long createBookCategory(BookCategorySaveReqVO createReqVO) {
        BookCategoryDO bookCategoryDO = BeanUtils.toBean(createReqVO, BookCategoryDO.class);
        bookCategoryMapper.insert(bookCategoryDO);
        return bookCategoryDO.getBookCategoryId();

    }

    @Override
    public void updateBookCategory(BookCategorySaveReqVO reqVO) {
        // 更新通知公告
        BookCategoryDO updateObj = BeanUtils.toBean(reqVO, BookCategoryDO.class);
        bookCategoryMapper.updateById(updateObj);
    }

    @Override
    public void deleteBookCategory(Long id) {
        bookCategoryMapper.deleteById(id);
    }

    @Override
    public BookCategoryDO getBookCategory(Long id) {
        return bookCategoryMapper.selectById(id);
    }
}
