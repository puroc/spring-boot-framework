package com.emrubik.springboot.app.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.emrubik.springboot.app.service.IRolePermissionBindService;
import com.emrubik.springboot.dao.entity.RolePermissionBind;
import com.emrubik.springboot.dao.mapper.RolePermissionBindMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author puroc123
 * @since 2018-03-20
 */
@Service
public class RolePermissionBindServiceImpl extends ServiceImpl<RolePermissionBindMapper, RolePermissionBind> implements IRolePermissionBindService {

}
