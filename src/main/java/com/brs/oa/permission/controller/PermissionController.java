package com.brs.oa.permission.controller;


import com.brs.oa.comm.model.RestfulResult;
import com.brs.oa.permission.entity.Permission;
import com.brs.oa.permission.service.IPermissionService;
import com.brs.oa.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.naming.CommunicationException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-05
 */
@RestController
@RequestMapping("/api/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;
    @GetMapping("/view")
    public RestfulResult getPermission(HttpServletRequest request){
        Integer empNo = CommonUtil.getEmployeeNoFromRequest(request);
        List<Permission> permissionList = permissionService.getPermissionListByEmpNo(empNo);

        return new RestfulResult(200,"获取当前用户所有权限列表！",permissionList );
    }
}
