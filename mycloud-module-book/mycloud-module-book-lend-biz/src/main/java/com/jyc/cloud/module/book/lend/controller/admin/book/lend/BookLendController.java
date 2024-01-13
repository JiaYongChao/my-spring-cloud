package com.jyc.cloud.module.book.lend.controller.admin.book.lend;

import com.jyc.cloud.framework.common.pojo.CommonResult;
import com.jyc.cloud.module.book.lend.controller.admin.book.lend.vo.BookLendReqVO;
import com.jyc.cloud.module.book.lend.controller.admin.book.lend.vo.BookLendSaveVO;
import com.jyc.cloud.module.book.lend.service.BookLendRecordsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

import static com.jyc.cloud.framework.common.pojo.CommonResult.success;

/**
 * @ClassNAME BookLendController
 * @Description TODO
 * @Author jiayongchao
 * @Date 2024/1/13 22:01
 * @Version 1.0
 */
@Tag(name = "管理后台 - 图书借阅")
@RestController
@RequestMapping("/book/lend")
@Validated
public class BookLendController{

    @Resource
    private BookLendRecordsService bookLendRecordsService;

    @PostMapping("")
    @Operation(summary = "用户借阅图书")
    public CommonResult<Boolean> bookLend(@Valid @RequestBody BookLendSaveVO bookLendSaveVO){
        bookLendRecordsService.userBorrowingBook(bookLendSaveVO);
        return success(true);
    }

    @PostMapping("/return")
    @Operation(summary = "用户归还图书")
    public CommonResult<Boolean> bookLendReturn(@Valid @RequestBody BookLendReqVO bookLendReqVO){
        bookLendRecordsService.userReturnBook(bookLendReqVO);
        return success(true);
    }

    @PostMapping("/bookLendIsOverdue")
    @Operation(summary = "判断用户借阅是否逾期")
    public CommonResult<Boolean> bookLendIsOverdue(@Valid @RequestBody BookLendReqVO bookLendReqVO){
        bookLendRecordsService.bookLendIsOverdue(bookLendReqVO);
        return success(true);
    }
}
