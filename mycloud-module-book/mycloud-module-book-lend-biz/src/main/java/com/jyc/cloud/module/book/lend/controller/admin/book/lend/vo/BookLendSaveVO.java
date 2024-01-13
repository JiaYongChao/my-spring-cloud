package com.jyc.cloud.module.book.lend.controller.admin.book.lend.vo;

import com.jyc.cloud.framework.mybatis.core.dataobject.BaseDO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @ClassNAME BookLendSaveVO
 * @Description TODO
 * @Author jiayongchao
 * @Date 2024/1/13 22:27
 * @Version 1.0
 */
@Schema(description = "管理后台 - 图书借阅建/修改 Request VO")
@Data
public class BookLendSaveVO extends BaseDO {

    /**
     * 用户ID
     */
    @Schema(description = "用户ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "用户ID不能为空")
    private Long userId;

    /**
     * 图书ID
     */
    @Schema(description = "图书编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "图书编号不能为空")
    private Long bookId;

    /**
     * 借阅天数
     */
    @Schema(description = "借阅天数", requiredMode = Schema.RequiredMode.REQUIRED, example = "小博主")
    @NotBlank(message = "借阅天数不能为空")
    private Integer days;


}
