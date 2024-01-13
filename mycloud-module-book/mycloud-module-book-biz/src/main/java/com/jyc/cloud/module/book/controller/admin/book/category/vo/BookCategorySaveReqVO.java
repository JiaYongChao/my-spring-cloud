package com.jyc.cloud.module.book.controller.admin.book.category.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @ClassNAME BookSaveReqVO
 * @Description TODO
 * @Author jiayongchao
 * @Date 2024/1/13 20:16
 * @Version 1.0
 */
@Schema(description = "管理后台 - 图书分类创建/修改 Request VO")
@Data
public class BookCategorySaveReqVO {
    /**
     * 图书分类ID
     */
    @Schema(description = "图书分类编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "图书分类编号不能为空")
    private Long bookCategoryId;

    /**
     * 图书分类名称
     */
    @Schema(description = "图书分类名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "小博主")
    @NotBlank(message = "图书分类名称不能为空")
    @Size(max = 50, message = "图书分类名称不能超过50个字符")
    private String bookCategoryName;


}
