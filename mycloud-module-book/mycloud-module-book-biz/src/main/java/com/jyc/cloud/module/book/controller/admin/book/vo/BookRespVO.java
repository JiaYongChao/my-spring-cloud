package com.jyc.cloud.module.book.controller.admin.book.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @ClassNAME BookRespVO
 * @Description TODO
 * @Author jiayongchao
 * @Date 2024/1/13 20:23
 * @Version 1.0
 */
@Schema(description = "管理后台 - 图书信息 Response VO")
@Data
public class BookRespVO {

    /**
     * 图书ID
     */
    @Schema(description = "图书编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long bookId;

    /**
     * 图书名称
     */
    @Schema(description = "图书名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "小博主")

    private String bookName;
    /**
     * 图书作者
     */
    @Schema(description = "图书作者", requiredMode = Schema.RequiredMode.REQUIRED, example = "小博主")
    private String bookAuthor;

    /**
     * 图书出版社
     */
    @Schema(description = "出版社", requiredMode = Schema.RequiredMode.REQUIRED, example = "凤凰出版社")
    private String bookPublish;

    /**
     * 图书分类
     */
    @Schema(description = "图书分类ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "文学")
    private Integer bookCategory;

    /**
     * 图书分类
     */
    @Schema(description = "图书分类", requiredMode = Schema.RequiredMode.REQUIRED, example = "文学")
    private String bookCategoryName;

    /**
     * 图书价格
     */
    @Schema(description = "图书价格", requiredMode = Schema.RequiredMode.REQUIRED, example = "10.20")
    private Double bookPrice;

    /**
     * 图书介绍
     */
    @Schema(description = "图书介绍", requiredMode = Schema.RequiredMode.REQUIRED, example = "好看")
    private String bookIntroduction;


    /**
     * 图书库存
     */
    @Schema(description = "图书库存", requiredMode = Schema.RequiredMode.REQUIRED, example = "好看")
    private Integer bookStock;

    /**
     * 图书状态（0 未借出 1已借出）
     */
    @Schema(description = "图书状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status;

}
