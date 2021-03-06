package com.emrubik.springboot.domain.po.extension;

import com.baomidou.mybatisplus.annotations.TableField;
import com.emrubik.springboot.domain.po.Role;
import com.emrubik.springboot.domain.po.User;
import lombok.Data;

import java.util.List;

@Data
public class UserExt extends User{

    @TableField(exist = false)
    private List<Role> roles;
}
