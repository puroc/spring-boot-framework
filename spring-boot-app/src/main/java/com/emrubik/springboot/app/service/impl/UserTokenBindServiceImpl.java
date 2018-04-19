package com.emrubik.springboot.app.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.emrubik.springboot.app.service.IUserTokenBindService;
import com.emrubik.springboot.dao.entity.UserTokenBind;
import com.emrubik.springboot.dao.mapper.UserTokenBindMapper;
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
public class UserTokenBindServiceImpl extends ServiceImpl<UserTokenBindMapper, UserTokenBind> implements IUserTokenBindService {

}
