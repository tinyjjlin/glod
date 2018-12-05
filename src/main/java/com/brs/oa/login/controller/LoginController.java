package com.brs.oa.login.controller;

import com.brs.oa.comm.annotation.Authentication;
import com.brs.oa.comm.jwt.JwtSupport;
import com.brs.oa.login.dto.LoginDto;
import com.brs.oa.comm.model.RestfulResult;
import com.brs.oa.comm.model.TokenModel;
import com.brs.oa.login.service.ILdapService;
import com.brs.oa.login.service.ITokenService;
import com.brs.oa.util.CommonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

/**
 * @author tiny lin
 * @date 2018/11/29
 */
@RestController
@Api("用户登录接口")
public class LoginController {
    static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private ILdapService ldapService;
    @Autowired
    private ITokenService tokenService;

    @PostMapping("/login")
    @ApiOperation(value = "用户登录",notes = "用户名，密码就是登录计算机账号密码")
    public RestfulResult login(@RequestBody LoginDto loginDto) throws Exception {
        ldapService.authentication(loginDto);
        TokenModel tokenModel = tokenService.generateToken(loginDto.getUserName(),CommonUtil.getEmpNo(loginDto.getUserName()));
        return new RestfulResult(200, "登录成功!", tokenModel);
    }
    @GetMapping("/loginOut")
    @ApiOperation(value = "退出系统")
    @Authentication
    public RestfulResult loginOut(HttpServletRequest request){
        String token =CommonUtil.getTokenFromRequest(request);
        tokenService.deleteToken(JwtSupport.getLoginName(token));
        return new RestfulResult(200, "退出操作成功!");
    }

}