package com.jyc.cloud.module.book.controller.admin.book.category.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @ClassNAME BookRespVO
 * @Description TODO
 * @Author jiayongchao
 * @Date 2024/1/13 20:23
 * @Version 1.0
 */
@Schema(description = "管理后台 - 图书分类信息 Response VO")
@Data
public class BookCategoryRespVO {

    /**
     * 图书分类ID
     */
    @Schema(description = "图书分类编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long bookCategoryId;

    /**
     * 图书分类名称
     */
    @Schema(description = "图书分类名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "小博主")

    private String bookCategoryName;

}
