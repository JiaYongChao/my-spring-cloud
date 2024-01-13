package com.jyc.cloud.module.book.controller.admin.book.vo;

import com.jyc.cloud.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassNAME BookPageReqVO
 * @Description 书籍vo
 * @Author jiayongchao
 * @Date 2024/1/13 19:42
 * @Version 1.0
 */
@Schema(description = "后台 - 图书管理分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class BookPageReqVO extends PageParam {

    @Schema(description = "图书名称，模糊匹配", example = "悲惨世界")
    private  String bookName;
}
