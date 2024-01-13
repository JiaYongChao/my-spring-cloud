package com.jyc.cloud.module.system.api.user;

import com.jyc.cloud.framework.common.pojo.CommonResult;
import com.jyc.cloud.framework.common.util.object.BeanUtils;
import com.jyc.cloud.module.system.api.user.dto.AdminUserRespDTO;
import com.jyc.cloud.module.system.dal.dataobject.user.AdminUserDO;
import com.jyc.cloud.module.system.service.user.AdminUserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static com.jyc.cloud.framework.common.pojo.CommonResult.success;

@RestController // 提供 RESTful API 接口，给 Feign 调用
@Validated
public class AdminUserApiImpl implements AdminUserApi {

    @Resource
    private AdminUserService userService;

    @Override
    public CommonResult<AdminUserRespDTO> getUser(Long id) {
        AdminUserDO user = userService.getUser(id);
        return success(BeanUtils.toBean(user, AdminUserRespDTO.class));
    }

    @Override
    public CommonResult<List<AdminUserRespDTO>> getUserList(Collection<Long> ids) {
        List<AdminUserDO> users = userService.getUserList(ids);
        return success(BeanUtils.toBean(users, AdminUserRespDTO.class));
    }

    @Override
    public CommonResult<List<AdminUserRespDTO>> getUserListByDeptIds(Collection<Long> deptIds) {
        List<AdminUserDO> users = userService.getUserListByDeptIds(deptIds);
        return success(BeanUtils.toBean(users, AdminUserRespDTO.class));
    }

    @Override
    public CommonResult<List<AdminUserRespDTO>> getUserListByPostIds(Collection<Long> postIds) {
        List<AdminUserDO> users = userService.getUserListByPostIds(postIds);
        return success(BeanUtils.toBean(users, AdminUserRespDTO.class));
    }

    @Override
    public CommonResult<Boolean> validateUserList(Set<Long> ids) {
        userService.validateUserList(ids);
        return success(true);
    }

}
