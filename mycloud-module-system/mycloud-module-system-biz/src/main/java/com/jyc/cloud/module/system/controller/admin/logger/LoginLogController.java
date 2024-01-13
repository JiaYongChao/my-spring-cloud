package com.jyc.cloud.module.system.controller.admin.logger;

import com.jyc.cloud.framework.common.pojo.CommonResult;
import com.jyc.cloud.framework.common.pojo.PageParam;
import com.jyc.cloud.framework.common.pojo.PageResult;
import com.jyc.cloud.framework.common.util.object.BeanUtils;
import com.jyc.cloud.framework.excel.core.util.ExcelUtils;
import com.jyc.cloud.framework.operatelog.core.annotations.OperateLog;
import com.jyc.cloud.module.system.controller.admin.logger.vo.loginlog.LoginLogPageReqVO;
import com.jyc.cloud.module.system.controller.admin.logger.vo.loginlog.LoginLogRespVO;
import com.jyc.cloud.module.system.dal.dataobject.logger.LoginLogDO;
import com.jyc.cloud.module.system.service.logger.LoginLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

import static com.jyc.cloud.framework.common.pojo.CommonResult.success;
import static com.jyc.cloud.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;

@Tag(name = "管理后台 - 登录日志")
@RestController
@RequestMapping("/system/login-log")
@Validated
public class LoginLogController {

    @Resource
    private LoginLogService loginLogService;

    @GetMapping("/page")
    @Operation(summary = "获得登录日志分页列表")
    @PreAuthorize("@ss.hasPermission('system:login-log:query')")
    public CommonResult<PageResult<LoginLogRespVO>> getLoginLogPage(@Valid LoginLogPageReqVO pageReqVO) {
        PageResult<LoginLogDO> pageResult = loginLogService.getLoginLogPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, LoginLogRespVO.class));
    }

    @GetMapping("/export")
    @Operation(summary = "导出登录日志 Excel")
    @PreAuthorize("@ss.hasPermission('system:login-log:export')")
    @OperateLog(type = EXPORT)
    public void exportLoginLog(HttpServletResponse response, @Valid LoginLogPageReqVO exportReqVO) throws IOException {
        exportReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<LoginLogDO> list = loginLogService.getLoginLogPage(exportReqVO).getList();
        // 输出
        ExcelUtils.write(response, "登录日志.xls", "数据列表", LoginLogRespVO.class,
                BeanUtils.toBean(list, LoginLogRespVO.class));
    }

}