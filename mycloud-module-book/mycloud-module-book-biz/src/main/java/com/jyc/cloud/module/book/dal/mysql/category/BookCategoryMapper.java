package com.jyc.cloud.module.book.dal.mysql.category;

import com.jyc.cloud.framework.mybatis.core.mapper.BaseMapperX;
import com.jyc.cloud.module.book.dal.dataobject.category.BookCategoryDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassNAME BookMapper
 * @Description TODO
 * @Author jiayongchao
 * @Date 2024/1/13 18:32
 * @Version 1.0
 */
@Mapper
public interface BookCategoryMapper extends BaseMapperX<BookCategoryDO> {
}
