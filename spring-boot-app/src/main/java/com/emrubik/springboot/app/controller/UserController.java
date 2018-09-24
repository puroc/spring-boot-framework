package com.emrubik.springboot.app.controller;


import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.emrubik.springboot.app.service.IOrgService;
import com.emrubik.springboot.app.service.IUserService;
import com.emrubik.springboot.common.util.BaseContextHandler;
import com.emrubik.springboot.domain.po.User;
import com.emrubik.springboot.domain.to.base.BaseReq;
import com.emrubik.springboot.domain.to.base.BaseResp;
import com.emrubik.springboot.domain.to.base.PageResp;
import com.emrubik.springboot.domain.to.org.OrgTree;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
 * @since 2018-03-15
 */
@Controller
@Validated
@RequestMapping("/idm")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IOrgService orgService;


    @GetMapping("/user/{id}")
    public ResponseEntity getUser(@PathVariable String id) {
        User user = userService.getUserInfo(id);
        BaseResp resp = new BaseResp();
        resp.setPayLoad(user);
        return ResponseEntity.ok(resp);
    }

    @DeleteMapping("/user")
    public ResponseEntity
    deleteUserList(@RequestBody BaseReq<User> baseReq) {
        List<String> userIdList = new ArrayList<String>();
        List<User> users = baseReq.getPayloads();
        int size = users.size();
        for (int i = 0; i < size; i++) {
            userIdList.add(users.get(i).getId() + "");
        }
        BaseResp resp = new BaseResp();
        boolean result = userService.deleteBatchIds(userIdList);
        if (!result) {
            resp.fail("删除失败,userIdList:" + userIdList);
        }
        return ResponseEntity.ok(resp);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity deleteUser(@PathVariable String id) {
        boolean result = userService.delete(new EntityWrapper<User>().eq("id", id));
        BaseResp resp = new BaseResp();
        if (!result) {
            resp.fail("用户:" + BaseContextHandler.getUserId() + "删除失败");
        }
        return ResponseEntity.ok(resp);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity updateUser(@RequestBody BaseReq<User> baseReq,@PathVariable String id) {
        User user = baseReq.getPayloads().get(0);
        user.setTimestamp(new Date());
        boolean result = userService.update(user, new EntityWrapper<User>().eq("id", id));
        BaseResp resp = new BaseResp();
        if (!result) {
            resp.fail("用户:" + BaseContextHandler.getUserId() + "修改失败");
        }
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/user")
    public ResponseEntity insertUser(@RequestBody @Validated BaseReq<User> baseReq) {
        User user = baseReq.getPayloads().get(0);
        user.setTimestamp(new Date());
        BaseResp resp = new BaseResp();
        if (userService.selectOne(Condition.create().eq("username", user.getUsername())) != null) {
            resp.fail("用户:" + user.getUsername() + "已经存在，不能添加用户名相同的用户");
        } else {
        }
        boolean result = userService.insert(user);
        if (!result) {
            resp.fail("用户:" + user.getUsername() + " 添加用户失败");
        }
        return ResponseEntity.ok(resp);
    }


    @GetMapping("/org/{orgId}/user")
    public ResponseEntity listUserByOrgId(@PathVariable String orgId,
                                          @RequestParam int current,
                                          @RequestParam int size,
                                          @RequestParam(required = false) String name,
                                          @RequestParam(required = false) String username,
                                          @RequestParam(required = false) String phone,
                                          @RequestParam(required = false) String email) throws Exception {

        //根据当前机构ID查询出机构树，并转换为list
        List<Integer> orgList = getOrgList(orgId);

        Wrapper<User> wrapper = new EntityWrapper<User>().in("org_id", orgList);
        if (!StringUtils.isEmpty(name)) {
            wrapper.like("user.name", name.trim());
        }
        if (!StringUtils.isEmpty(username)) {
            wrapper.like("user.username", username.trim());
        }
        if (!StringUtils.isEmpty(email)) {
            wrapper.like("user.email", email.trim());
        }
        if (!StringUtils.isEmpty(phone)) {
            wrapper.like("user.phone", phone.trim());
        }

        Page<User> userPage = userService.getUserListByOrgId(new Page<User>(current, size), wrapper);
        PageResp<User> baseResp = new PageResp<User>();
        baseResp.setPayloads(userPage.getRecords());
        baseResp.setTotalNum(userPage.getTotal());
        return ResponseEntity.ok(baseResp);
    }

    private List<Integer> getOrgList(@PathVariable String orgId) {
        OrgTree orgTree = orgService.getOrgTree(orgId);
        return orgService.getOrgList(new ArrayList<Integer>(), orgTree);
    }

}

