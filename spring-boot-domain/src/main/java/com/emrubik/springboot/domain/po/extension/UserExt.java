package com.emrubik.springboot.domain.po.extension;

import com.baomidou.mybatisplus.annotations.TableField;
import com.emrubik.springboot.domain.po.Role;
import com.emrubik.springboot.domain.po.User;

import javax.validation.Valid;
import java.util.List;

public class UserExt extends User {

    @TableField(exist = false)
    private List<Role> roleList;

}
