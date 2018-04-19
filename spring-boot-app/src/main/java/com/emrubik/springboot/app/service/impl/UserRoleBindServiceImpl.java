package com.emrubik.springboot.app.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.emrubik.springboot.app.service.IUserRoleBindService;
import com.emrubik.springboot.dao.entity.UserRoleBind;
import com.emrubik.springboot.dao.mapper.UserRoleBindMapper;
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
public class UserRoleBindServiceImpl extends ServiceImpl<UserRoleBindMapper, UserRoleBind> implements IUserRoleBindService {

}
