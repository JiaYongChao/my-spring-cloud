package com.jyc.cloud.module.book.dal.dataobject.book;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jyc.cloud.framework.mybatis.core.dataobject.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @ClassNAME BookDO
 * @Description 图书对象
 * @Author jiayongchao
 * @Date 2024/1/13 18:32
 * @Version 1.0
 */
@Data
@Getter
@Setter
@TableName("cloud_book")
@EqualsAndHashCode(callSuper = true)
public class BookDO extends BaseDO {
    /**
     * 图书ID
     */
    private Long bookId;

    /**
     * 图书名称
     */
    private String bookName;
    /**
     * 图书作者
     */
    private String bookAuthor;

    /**
     * 图书发布人
     */
    private String bookPublish;

    /**
     * 图书分类
     */
    private Integer bookCategory;

    /**
     * 图书价格
     */
    private Double bookPrice;

    /**
     * 图书介绍
     */
    private String bookIntroduction;

    /**
     * 图书库存
     */
    private Integer bookStock;

    /**
     * 图书状态（0 未借出 1已借出）
     */
    private Integer status;
}
