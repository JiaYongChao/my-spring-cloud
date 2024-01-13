package com.jyc.cloud.module.book.dal.mysql.book;

import com.jyc.cloud.framework.common.pojo.PageResult;
import com.jyc.cloud.framework.mybatis.core.mapper.BaseMapperX;
import com.jyc.cloud.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.jyc.cloud.module.book.controller.admin.book.vo.BookPageReqVO;
import com.jyc.cloud.module.book.dal.dataobject.book.BookDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassNAME BookMapper
 * @Description TODO
 * @Author jiayongchao
 * @Date 2024/1/13 18:32
 * @Version 1.0
 */
@Mapper
public interface BookMapper extends BaseMapperX<BookDO> {
    default PageResult<BookDO> selectPage(BookPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BookDO>()
                .likeIfPresent(BookDO::getBookName, reqVO.getBookName())
                .orderByDesc(BookDO::getBookId));
    }
}
