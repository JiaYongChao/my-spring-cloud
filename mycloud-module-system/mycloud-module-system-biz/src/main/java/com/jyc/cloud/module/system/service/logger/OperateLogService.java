package com.jyc.cloud.module.system.service.logger;

import com.jyc.cloud.framework.common.pojo.PageResult;
import com.jyc.cloud.module.system.api.logger.dto.OperateLogCreateReqDTO;
import com.jyc.cloud.module.system.controller.admin.logger.vo.operatelog.OperateLogPageReqVO;
import com.jyc.cloud.module.system.dal.dataobject.logger.OperateLogDO;

/**
 * 操作日志 Service 接口
 *
 * @author JiaYongChao
 */
public interface OperateLogService {

    /**
     * 记录操作日志
     *
     * @param createReqDTO 操作日志请求
     */
    void createOperateLog(OperateLogCreateReqDTO createReqDTO);

    /**
     * 获得操作日志分页列表
     *
     * @param pageReqVO 分页条件
     * @return 操作日志分页列表
     */
    PageResult<OperateLogDO> getOperateLogPage(OperateLogPageReqVO pageReqVO);

}
