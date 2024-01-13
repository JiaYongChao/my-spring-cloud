package com.jyc.cloud.module.book.dal.dataobject.category;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @description: 图书分类
 * @author: JiaYongChao
 * @date: 2024/1/13 18:54
 * @param:
 * @return:
 **/
@Data
@Getter
@Setter
@TableName("cloud-book-category")
public class BookCategoryDO {
    /**
     * 分类id
     */
    private Long bookCategoryId;

    /**
     * 分类名称
     */
    private String bookCategoryName;

}