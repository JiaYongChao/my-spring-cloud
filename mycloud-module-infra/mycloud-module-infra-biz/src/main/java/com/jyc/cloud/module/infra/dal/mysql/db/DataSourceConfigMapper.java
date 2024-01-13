package com.jyc.cloud.module.infra.dal.mysql.db;

import com.jyc.cloud.framework.mybatis.core.mapper.BaseMapperX;
import com.jyc.cloud.module.infra.dal.dataobject.db.DataSourceConfigDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据源配置 Mapper
 *
 * @author JiaYongChao
 */
@Mapper
public interface DataSourceConfigMapper extends BaseMapperX<DataSourceConfigDO> {
}
