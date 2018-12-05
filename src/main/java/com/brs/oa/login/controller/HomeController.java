package com.brs.oa.login.controller;


import com.brs.oa.comm.annotation.Authentication;
import com.brs.oa.comm.model.RestfulResult;
import com.brs.oa.util.CommonUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;


/**
 * @author tiny lin
 * @date 2018/11/29
 */

@RestController
@RequestMapping("/api/home")
public class HomeController {

    @GetMapping("/")
    @Authentication
    public RestfulResult home(HttpServletRequest request){
        Integer empNo = CommonUtil.getEmployeeNoFromRequest(request);
        // 获取页面资源（按权限）
        return new RestfulResult(200,"get home info ",null );
    }
}
