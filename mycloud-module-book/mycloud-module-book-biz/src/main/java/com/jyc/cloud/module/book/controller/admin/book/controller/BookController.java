package com.jyc.cloud.module.book.controller.admin.book.controller;

import com.jyc.cloud.framework.common.pojo.CommonResult;
import com.jyc.cloud.framework.common.pojo.PageResult;
import com.jyc.cloud.framework.common.util.object.BeanUtils;
import com.jyc.cloud.module.book.controller.admin.book.vo.BookPageReqVO;
import com.jyc.cloud.module.book.controller.admin.book.vo.BookRespVO;
import com.jyc.cloud.module.book.controller.admin.book.vo.BookSaveReqVO;
import com.jyc.cloud.module.book.dal.dataobject.book.BookDO;
import com.jyc.cloud.module.book.service.book.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import static com.jyc.cloud.framework.common.pojo.CommonResult.success;

/**
 * @ClassNAME BookController
 * @Description TODO
 * @Author jiayongchao
 * @Date 2024/1/13 20:53
 * @Version 1.0
 */
@Tag(name = "管理后台 - 图书管理")
@RestController
@RequestMapping("/books")
@Validated
public class BookController {

    @Resource
    private BookService bookService;
    @PostMapping("/create")
    @Operation(summary = "创建图书")

    public CommonResult<Long> createBook(@Valid @RequestBody BookSaveReqVO createReqVO) {
        Long BookId = bookService.createBook(createReqVO);
        return success(BookId);
    }

    @PutMapping("/update")
    @Operation(summary = "修改图书")

    public CommonResult<Boolean> updateBook(@Valid @RequestBody BookSaveReqVO updateReqVO) {
        bookService.updateBook(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除图书")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")

    public CommonResult<Boolean> deleteBook(@RequestParam("id") Long id) {
        bookService.deleteBook(id);
        return success(true);
    }

    @GetMapping("/page")
    @Operation(summary = "获取图书列表")

    public CommonResult<PageResult<BookRespVO>> getBookPage(@Validated BookPageReqVO pageReqVO) {
        PageResult<BookDO> pageResult = bookService.getBookPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, BookRespVO.class));
    }

    @GetMapping("/get")
    @Operation(summary = "获得图书")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")

    public CommonResult<BookRespVO> getBook(@RequestParam("id") Long id) {
        BookDO Book = bookService.getBook(id);
        return success(BeanUtils.toBean(Book, BookRespVO.class));
    }
}
