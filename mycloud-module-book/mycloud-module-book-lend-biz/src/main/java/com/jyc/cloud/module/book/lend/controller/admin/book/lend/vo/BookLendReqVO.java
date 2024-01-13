package com.jyc.cloud.module.book.lend.controller.admin.book.lend.vo;

import com.jyc.cloud.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @ClassNAME BookLendReqVO
 * @Description TODO
 * @Author jiayongchao
 * @Date 2024/1/13 22:08
 * @Version 1.0
 */
@Schema(description = "管理后台 - 借阅查询 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class BookLendReqVO extends PageParam {

    private Long userId;

    private Long bookId;
}
