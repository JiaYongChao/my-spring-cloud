package com.jyc.cloud.module.system.dal.mysql.notice;

import com.jyc.cloud.framework.common.pojo.PageResult;
import com.jyc.cloud.framework.mybatis.core.mapper.BaseMapperX;
import com.jyc.cloud.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.jyc.cloud.module.system.controller.admin.notice.vo.NoticePageReqVO;
import com.jyc.cloud.module.system.dal.dataobject.notice.NoticeDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeMapper extends BaseMapperX<NoticeDO> {

    default PageResult<NoticeDO> selectPage(NoticePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<NoticeDO>()
                .likeIfPresent(NoticeDO::getTitle, reqVO.getTitle())
                .eqIfPresent(NoticeDO::getStatus, reqVO.getStatus())
                .orderByDesc(NoticeDO::getId));
    }

}
