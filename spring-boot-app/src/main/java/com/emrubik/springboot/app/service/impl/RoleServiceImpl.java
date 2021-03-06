package com.emrubik.springboot.app.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.emrubik.springboot.app.service.IRoleService;
import com.emrubik.springboot.app.service.IUserRoleBindService;
import com.emrubik.springboot.dao.mapper.RoleMapper;
import com.emrubik.springboot.domain.po.Role;
import com.emrubik.springboot.domain.po.UserRoleBind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author puroc123
 * @since 2018-03-20
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    private IUserRoleBindService userRoleBindService;

    @Override
    public Role getRoleInfo(String id) {
        return baseMapper.getRoleInfo(id);
    }

    @Override
    public Page<Role> getRoleListByOrgId(Page<Role> page, Wrapper<Role> wrapper) {
        page.setRecords(baseMapper.getRoleListByOrgId(page,wrapper));
        return page;
    }

    @Override
    public boolean isRoleBinded(String roleId) {
        List<UserRoleBind> permissionBindList = userRoleBindService.selectList(new EntityWrapper<UserRoleBind>().eq("role_id", roleId));
        return !permissionBindList.isEmpty();
    }


}
