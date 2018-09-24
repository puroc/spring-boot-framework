package com.emrubik.springboot.app.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.emrubik.springboot.app.service.IRolePermissionBindService;
import com.emrubik.springboot.domain.po.RolePermissionBind;
import com.emrubik.springboot.domain.to.base.BaseReq;
import com.emrubik.springboot.domain.to.base.BaseResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author puroc123
 * @since 2018-09-23
 */
@Controller
@RequestMapping("/idm/rolePermissionBind")
public class RolePermissionBindController {

    @Autowired
    private IRolePermissionBindService rolePermissionBindService;

    @PostMapping("/{id}/permission")
    public ResponseEntity insertRolePermissionBind(@PathVariable String id, @RequestBody @Validated BaseReq<RolePermissionBind> baseReq) {
        List<RolePermissionBind> permissionBinds = baseReq.getPayloads();
        boolean result = rolePermissionBindService.insertBatch(permissionBinds);
        BaseResp baseResp = new BaseResp();
        if (!result) {
            baseResp.fail("角色和权限绑定关系添加失败,roleId:" + id);
        }
        return ResponseEntity.ok(baseResp);
    }

    @Transactional(rollbackFor = Exception.class)
    @PutMapping("/{id}/permission")
    public ResponseEntity updateRolePermissionBind(@PathVariable String id, @RequestBody @Validated BaseReq<RolePermissionBind> baseReq) {
        //先删除原有角色和权限的绑定关系，再添加新的绑定关系
        boolean result = rolePermissionBindService.delete(new EntityWrapper<RolePermissionBind>().eq("role_id", id));
        BaseResp resp = new BaseResp();
        if (!result) {
            resp.fail("删除角色和权限绑定关系失败，roleId:" + id);
        }
        List<RolePermissionBind> permissionBinds = baseReq.getPayloads();
        result = rolePermissionBindService.insertBatch(permissionBinds);
        BaseResp baseResp = new BaseResp();
        if (!result) {
            baseResp.fail("角色和权限绑定关系添加失败,roleId:" + id);
        }
        return ResponseEntity.ok(resp);
    }

}

