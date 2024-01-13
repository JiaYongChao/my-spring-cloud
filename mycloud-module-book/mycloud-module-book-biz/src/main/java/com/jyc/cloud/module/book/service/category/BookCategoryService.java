package com.jyc.cloud.module.book.service.category;

import com.jyc.cloud.module.book.controller.admin.book.category.vo.BookCategorySaveReqVO;
import com.jyc.cloud.module.book.dal.dataobject.category.BookCategoryDO;

/**
 * @ClassNAME BookCategoryService
 * @Description TODO
 * @Author jiayongchao
 * @Date 2024/1/13 20:44
 * @Version 1.0
 */
public interface BookCategoryService {
    /**
     * 创建图书分类
     *
     * @param createReqVO 图书分类
     * @return 编号
     */
    Long createBookCategory(BookCategorySaveReqVO createReqVO);

    /**
     * 更新图书分类
     *
     * @param reqVO 图书分类
     */
    void updateBookCategory(BookCategorySaveReqVO reqVO);

    /**
     * 删除图书分类
     *
     * @param id 编号
     */
    void deleteBookCategory(Long id);



    /**
     * 获得图书分类
     *
     * @param id 编号
     * @return 图书分类
     */
    BookCategoryDO getBookCategory(Long id);
}
