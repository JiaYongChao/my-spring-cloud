package com.jyc.cloud.module.book.controller.app;

import com.jyc.cloud.framework.common.pojo.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.jyc.cloud.framework.common.pojo.CommonResult.success;

/**
 * @ClassNAME AppBookTestController
 * @Description 测试
 * @Author jiayongchao
 * @Date 2024/1/13 18:12
 * @Version 1.0
 */
@Tag(name = "用户 App - Test")
@RestController
@RequestMapping("/book/test")
@Validated
public class AppBookTestController {

    @GetMapping("/get")
    @Operation(summary = "获取 test 信息")
    public CommonResult<String> get() {
        return success("true");
    }
}
