package com.brs.oa.role.controller;


import com.brs.oa.comm.annotation.NeedPermissions;
import com.brs.oa.comm.model.RestfulResult;
import com.brs.oa.role.entity.Role;
import com.brs.oa.role.service.IRoleService;
import com.brs.oa.role.vo.RoleVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/api/role")
public class RoleController {

    private final static Logger LOGGER = LoggerFactory.getLogger(RoleController.class);
    @Autowired
    private IRoleService roleService;

    @GetMapping("/view")
    @NeedPermissions("role:view")
    public RestfulResult view(){
        List<Role> roleList= roleService.list();
        return new RestfulResult(200,"查看角色信息",roleList );
    }
    @PostMapping("/addOne")
    @NeedPermissions("role:add")
    public RestfulResult add(@RequestBody RoleVo roleVo) {
        // request data verification
        //TODO
        int result =0;
        if(roleVo != null){
            result = roleService.createNewRole(roleVo);
        }
        return result!=0 ? new RestfulResult(200, "添加角色操作成功！") : new RestfulResult(404, "添加角色操作失败！");
    }

    @PostMapping("/editOne")
    @NeedPermissions("role:edit")
    public RestfulResult edit(@RequestBody RoleVo roleVo){
        Boolean result = roleService.updateRoleInfo(roleVo);
        return (result)? new RestfulResult(200, "编辑角色操作成功！"):new RestfulResult(404, "编辑角色操作失败！");
    }
}
