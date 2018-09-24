package com.emrubik.springboot.app.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.emrubik.springboot.app.constant.Constants;
import com.emrubik.springboot.app.service.IUserService;
import com.emrubik.springboot.app.service.IUserTokenBindService;
import com.emrubik.springboot.common.annotation.IgnoreJwtValidation;
import com.emrubik.springboot.common.util.BaseContextHandler;
import com.emrubik.springboot.common.util.JwtHelper;
import com.emrubik.springboot.domain.po.User;
import com.emrubik.springboot.domain.po.UserTokenBind;
import com.emrubik.springboot.domain.to.base.BaseReq;
import com.emrubik.springboot.domain.to.base.BaseResp;
import com.emrubik.springboot.domain.to.payload.login.LoginReq;
import com.emrubik.springboot.domain.to.payload.login.LoginResp;
import com.emrubik.springboot.domain.vo.JwtInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/idm")
public class AuthController {

    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserTokenBindService userTokenBindService;

    @IgnoreJwtValidation
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Validated BaseReq<LoginReq> baseReq) throws Exception {
        LoginReq loginReq = baseReq.getPayloads().get(0);

        //验证用户合法性
        User user = validateUser(loginReq);

        BaseResp<LoginResp> resp = new BaseResp<LoginResp>();

        //用户不存在，返回404，登录失败
        if (user == null) {
            resp.setResultCode(BaseResp.RESULT_FAILED);
            resp.setMessage(Constants.USER_NOT_EXIST);
            return ResponseEntity.ok(resp);
        }

        LoginResp loginResp = new LoginResp();

        //生成token
        String jwtToken = createToken(user);
        loginResp.setToken(jwtToken);
        resp.setPayLoad(loginResp);
        return ResponseEntity.ok(resp);
    }

    private User validateUser(LoginReq loginReq) {
        return userService.selectOne(new EntityWrapper<User>().eq("username", loginReq.getUsername()).eq("password", loginReq.getPassword()));
    }

    private String createToken(User user) throws Exception {
        //生成token
        String jwtToken = jwtHelper.generateToken(createJwtInfo(user));

        //存储token和用户的关系
        insertOrUpdateUserTokenBind(user, jwtToken);
        return jwtToken;
    }

    private JwtInfo createJwtInfo(User user) {
        JwtInfo jwtInfo = new JwtInfo();
        jwtInfo.setUserId(user.getId() + "");
        jwtInfo.setUserName(user.getName());
        jwtInfo.setCurrentTime(System.currentTimeMillis());
        return jwtInfo;
    }

    private void insertOrUpdateUserTokenBind(User user, String jwtToken) {
        UserTokenBind userToken = userTokenBindService.selectOne(new EntityWrapper<UserTokenBind>().eq("user_id", user.getId()));
        UserTokenBind userTokenBind = new UserTokenBind();
        //设置了主键属性，mybatis的insertOrUpdate方法会先根据ID进行更新，如果没有更新到数据，则插入数据
        if (userToken != null) {
            userTokenBind.setId(userToken.getId());
        }
        userTokenBind.setToken(jwtToken);
        userTokenBind.setUserId(user.getId());
        userTokenBind.setExpire(Integer.parseInt(jwtHelper.getExpire()));
        userTokenBind.setTimestamp(new Date());
        userTokenBindService.insertOrUpdate(userTokenBind);
    }

    @GetMapping("/logout")
    public ResponseEntity logout() throws Exception {
        userTokenBindService.delete(new EntityWrapper<UserTokenBind>().eq("user_id", BaseContextHandler.getUserId()));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/token")
    public ResponseEntity refreshToken() throws Exception {
        User user = userService.selectOne(new EntityWrapper<User>().eq("id", BaseContextHandler.getUserId()));
        //生成token
        String jwtToken = createToken(user);
        LoginResp loginResp = new LoginResp();
        loginResp.setToken(jwtToken);
        BaseResp<LoginResp> resp = new BaseResp<LoginResp>();
        resp.setPayLoad(loginResp);
        return ResponseEntity.ok(resp);
    }
}
