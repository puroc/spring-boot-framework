package com.emrubik.springboot.dao.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.emrubik.springboot.domain.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author puroc123
 * @since 2018-03-20
 */
public interface UserMapper extends BaseMapper<User> {

    User getUserInfo(String userId);

    List<User> getUserListByOrgId(Page<User> page, @Param("ew") Wrapper<User> wrapper);

}
