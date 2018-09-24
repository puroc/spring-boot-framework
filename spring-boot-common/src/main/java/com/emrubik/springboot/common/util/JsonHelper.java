package com.emrubik.springboot.common.util;

import com.alibaba.fastjson.JSON;
import com.emrubik.springboot.domain.po.Permission;
import com.emrubik.springboot.domain.po.Role;
import com.emrubik.springboot.domain.po.extension.RoleExt;
import com.emrubik.springboot.domain.po.extension.UserExt;

import java.util.ArrayList;

public class JsonHelper {

    public static String toJson(Object obj){
        return JSON.toJSONString(obj);
    }

    public static <T> T toObj(String json, Class<T> clazz){
        return JSON.parseObject(json,clazz);
    }

    public static void main(String[] args) {
        UserExt user = new UserExt();
        user.setId(1);
        user.setName("pud");
        user.setEmail("471049931@qq.com");
        ArrayList<Role> roles = new ArrayList<Role>();
        RoleExt role = new RoleExt();
        ArrayList<Permission> permissions = new ArrayList<>();
        Permission permission = new Permission();
        permission.setId(1);
        permission.setName("permission1");
        permissions.add(permission);
        role.setPermissions(permissions);
        roles.add(role);
        user.setRoles(roles);
        System.out.println(toJson(user));

    }

}
