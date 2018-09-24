package com.emrubik.springboot.app.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.emrubik.springboot.app.service.IOrgService;
import com.emrubik.springboot.app.service.IRolePermissionBindService;
import com.emrubik.springboot.app.service.IRoleService;
import com.emrubik.springboot.domain.po.Role;
import com.emrubik.springboot.domain.po.RolePermissionBind;
import com.emrubik.springboot.domain.to.base.BaseReq;
import com.emrubik.springboot.domain.to.base.BaseResp;
import com.emrubik.springboot.domain.to.base.PageResp;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author puroc123
 * @since 2018-03-20
 */
@Controller
@Validated
@RequestMapping("/idm/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IOrgService orgService;

    @Autowired
    private IRolePermissionBindService rolePermissionBindService;

    @PostMapping
    public ResponseEntity insertRole(@RequestBody @Validated BaseReq<Role> baseReq) {
        Role role = baseReq.getPayloads().get(0);
        role.setTimestamp(new Date());
        boolean result = roleService.insert(role);
        BaseResp baseResp = new BaseResp();
        if (!result) {
            baseResp.fail("角色添加失败，roleName：" + role.getName());
        }
        return ResponseEntity.ok(baseResp);
    }

    @DeleteMapping("/{id}")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity deleteRole(@PathVariable String id) {
        BaseResp resp = new BaseResp();
        //如果有用户绑定了这个角色，则不允许删除
        boolean binded = roleService.isRoleBinded(id);
        if (binded) {
            resp.fail("有用户绑定了该角色，不允许删除，roleId:" + id);
            return ResponseEntity.ok(resp);
        }

        //先删除角色与权限的绑定关系
        boolean result = rolePermissionBindService.delete(new EntityWrapper<RolePermissionBind>().eq("role_id", id));
        if (!result) {
            resp.fail("角色与权限的绑定关系删除失败，roleId:" + id);
            return ResponseEntity.ok(resp);
        }

        //删除角色
        result = roleService.delete(new EntityWrapper<Role>().eq("id", id));
        if (!result) {
            resp.fail("角色删除失败，roleId:" + id);
        }
        return ResponseEntity.ok(resp);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateRole(@PathVariable String id, @RequestBody @Validated BaseReq<Role> baseReq) {
        Role role = baseReq.getPayloads().get(0);
        role.setTimestamp(new Date());
        boolean result = roleService.update(role, new EntityWrapper<Role>().eq("id", id));
        BaseResp baseResp = new BaseResp();
        if (!result) {
            baseResp.fail("更新角色失败，roleId:" + id);
            return ResponseEntity.ok(baseResp);
        }
        return ResponseEntity.ok(baseResp);
    }

    @GetMapping("/{id}")
    public ResponseEntity getRole(@PathVariable String id) {
        Role role = roleService.getRoleInfo(id);
        BaseResp<Role> baseResp = new BaseResp<Role>();
        baseResp.setPayLoad(role);
        return ResponseEntity.ok(baseResp);
    }

    @DeleteMapping
    public ResponseEntity
    deleteRoleList(@RequestBody BaseReq<Role> baseReq) {
        List<String> roleIdList = new ArrayList<String>();
        BaseResp resp = new BaseResp();
        List<Role> roles = baseReq.getPayloads();
        int size = roles.size();
        for (int i = 0; i < size; i++) {
            String roleId = roles.get(i).getId() + "";
            boolean binded = roleService.isRoleBinded(roleId);
            if (binded) {
                resp.fail("有用户绑定了该角色，不允许删除，roleId:" + roleId);
                return ResponseEntity.ok(resp);
            }
            roleIdList.add(roleId);
        }

        boolean result = roleService.deleteBatchIds(roleIdList);
        if (!result) {
            resp.fail("删除失败,roleIdList:" + roleIdList);
        }
        return ResponseEntity.ok(resp);
    }

    @GetMapping
    public ResponseEntity listRoleByOrgId(@RequestParam String orgId,
                                             @RequestParam(required = false) int current,
                                             @RequestParam(required = false) int size,
                                             @RequestParam(required = false) String name) {
        //根据当前机构获取其上级所有机构（包括当前机构）
        List<Integer> upperOrgList = orgService.getUpperOrgList(orgId);

        Wrapper<Role> wrapper = new EntityWrapper<Role>().in("org_id", upperOrgList);
        if (!StringUtils.isEmpty(name)) {
            wrapper.like("role.name", name.trim());
        }
        BaseResp<Role> baseResp = null;
        if (current == 0 && size == 0) {
            List<Role> roles = roleService.selectList(wrapper);
            baseResp = new BaseResp<Role>();
            baseResp.setPayloads(roles);
        } else {

            Page<Role> rolePage = roleService.getRoleListByOrgId(new Page<Role>(current, size), wrapper);
            baseResp = new PageResp<Role>();
            baseResp.setPayloads(rolePage.getRecords());
            ((PageResp<Role>)baseResp).setTotalNum(rolePage.getTotal());
        }
        return ResponseEntity.ok(baseResp);
    }

}

