package com.jyc.cloud.module.book.controller.admin.book.vo;

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
@Schema(description = "管理后台 - 图书创建/修改 Request VO")
@Data
public class BookSaveReqVO {
    /**
     * 图书ID
     */
    @Schema(description = "图书编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "102L")
    @NotNull(message = "图书编号不能为空")
    private Long bookId;

    /**
     * 图书名称
     */
    @Schema(description = "图书名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "小博主")
    @NotBlank(message = "图书名称不能为空")
    @Size(max = 50, message = "图书名称不能超过50个字符")
    private String bookName;
    /**
     * 图书作者
     */
    @Schema(description = "图书作者", requiredMode = Schema.RequiredMode.REQUIRED, example = "小博主")
    @NotBlank(message = "图书作者不能为空")
    @Size(max = 50, message = "图书作者不能超过50个字符")
    private String bookAuthor;

    /**
     * 图书出版社
     */
    @Schema(description = "出版社", requiredMode = Schema.RequiredMode.REQUIRED, example = "凤凰出版社")
    @NotBlank(message = "出版社不能为空")
    @Size(max = 100, message = "出版社不能超过100个字符")
    private String bookPublish;

    /**
     * 图书分类
     */
    @Schema(description = "图书分类名称", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer bookCategory;

    /**
     * 图书价格
     */
    @Schema(description = "图书价格", requiredMode = Schema.RequiredMode.REQUIRED, example = "10.20")
    private Double bookPrice;

    /**
     * 图书介绍
     */
    @Schema(description = "图书介绍", requiredMode = Schema.RequiredMode.REQUIRED, example = "好看")
    @NotBlank(message = "图书介绍不能为空")
    private String bookIntroduction;


    /**
     * 图书库存
     */
    @Schema(description = "图书库存", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer bookStock;

    /**
     * 图书状态（0 未借出 1已借出）
     */
    @Schema(description = "图书状态", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer status;

}
