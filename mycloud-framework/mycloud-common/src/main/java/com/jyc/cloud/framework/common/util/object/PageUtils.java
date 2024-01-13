package com.jyc.cloud.framework.common.util.object;

import com.jyc.cloud.framework.common.pojo.PageParam;

/**
 * {@link com.jyc.cloud.framework.common.pojo.PageParam} 工具类
 *
 * @author JiaYongChao
 */
public class PageUtils {

    public static int getStart(PageParam pageParam) {
        return (pageParam.getPageNo() - 1) * pageParam.getPageSize();
    }

}
