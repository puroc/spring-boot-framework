package com.emrubik.springboot.app.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.emrubik.springboot.domain.po.Role;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author puroc123
 * @since 2018-03-20
 */
public interface IRoleService extends IService<Role> {

    Role getRoleInfo(String id);

    Page<Role> getRoleListByOrgId(Page<Role> page, @Param("ew") Wrapper<Role> wrapper);

    boolean isRoleBinded(String roleId);

}
