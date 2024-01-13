package com.jyc.cloud.module.infra.dal.mysql.file;

import com.jyc.cloud.framework.common.pojo.PageResult;
import com.jyc.cloud.framework.mybatis.core.mapper.BaseMapperX;
import com.jyc.cloud.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.jyc.cloud.module.infra.controller.admin.file.vo.config.FileConfigPageReqVO;
import com.jyc.cloud.module.infra.dal.dataobject.file.FileConfigDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileConfigMapper extends BaseMapperX<FileConfigDO> {

    default PageResult<FileConfigDO> selectPage(FileConfigPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<FileConfigDO>()
                .likeIfPresent(FileConfigDO::getName, reqVO.getName())
                .eqIfPresent(FileConfigDO::getStorage, reqVO.getStorage())
                .betweenIfPresent(FileConfigDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(FileConfigDO::getId));
    }

    default FileConfigDO selectByMaster() {
        return selectOne(FileConfigDO::getMaster, true);
    }

}
