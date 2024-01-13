package com.jyc.cloud.framework.operatelog.core.service;

/**
 * 操作日志 Framework Service 接口
 *
 * @author JiaYongChao
 */
public interface OperateLogFrameworkService {

    /**
     * 记录操作日志
     *
     * @param operateLog 操作日志请求
     */
    void createOperateLog(OperateLog operateLog);

}