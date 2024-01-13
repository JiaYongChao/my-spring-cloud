package com.jyc.cloud.module.infra.dal.mysql.file;

import com.jyc.cloud.framework.common.pojo.PageResult;
import com.jyc.cloud.framework.mybatis.core.mapper.BaseMapperX;
import com.jyc.cloud.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.jyc.cloud.module.infra.controller.admin.file.vo.file.FilePageReqVO;
import com.jyc.cloud.module.infra.dal.dataobject.file.FileDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文件操作 Mapper
 *
 * @author JiaYongChao
 */
@Mapper
public interface FileMapper extends BaseMapperX<FileDO> {

    default PageResult<FileDO> selectPage(FilePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<FileDO>()
                .likeIfPresent(FileDO::getPath, reqVO.getPath())
                .likeIfPresent(FileDO::getType, reqVO.getType())
                .betweenIfPresent(FileDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(FileDO::getId));
    }

}
