package com.emrubik.springboot.domain.po.extension;

import com.baomidou.mybatisplus.annotations.TableField;
import com.emrubik.springboot.domain.po.Permission;
import com.emrubik.springboot.domain.po.Role;
import lombok.Data;

import java.util.List;

@Data
public class RoleExt extends Role {

    @TableField(exist = false)
    private List<Permission> permissions;
}
