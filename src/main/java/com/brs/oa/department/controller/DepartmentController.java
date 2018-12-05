package com.brs.oa.department.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.brs.oa.comm.annotation.Authentication;
import com.brs.oa.comm.annotation.NeedPermissions;
import com.brs.oa.comm.model.RestfulResult;
import com.brs.oa.department.entity.Department;
import com.brs.oa.department.service.IDepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
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
@RequestMapping("/api/department")
@Api(value = "DepartmentController|部门管理的控制器")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    private final static Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @GetMapping("/view")
    @Authentication
    @ApiOperation(value = "查看公司所有部门信息")
    @ApiResponse(code = 200,message = "查看部门信息",response = List.class)
    public RestfulResult view(){
        List<Department> departmentList= departmentService.list();
        return new RestfulResult(200,"查看部门信息",departmentList );
    }
    @PostMapping("/addOne")
    @NeedPermissions(value = {"department:add"})
    @ApiOperation(value = "管理员添加一个新的部门")
    public RestfulResult add(@RequestBody Department department) {
        // request data verification
        //TODO
        Boolean result =false;
        if(department != null){
            result = departmentService.save(department);
        }
        return result ? new RestfulResult(200, "添加部门操作成功！") : new RestfulResult(404, "添加部门操作失败！");
    }

    @PostMapping("/addMulti")
    @NeedPermissions(value = {"department:add"})
    @ApiOperation(value = "管理员添加多个新的部门")
    public RestfulResult addMutil(@RequestBody List <Department> departmentList) {
        Boolean result = false;
        if (departmentList != null) {
            result = departmentService.saveBatch(departmentList);
        }
        return result ? new RestfulResult(200, "添加部门操作成功！") : new RestfulResult(404, "添加部门操作失败！");
    }

    @PostMapping("/deleteOne")
    @NeedPermissions(value = {"department:delete"})
    @ApiOperation(value = "管理员删除一个部门")
    public RestfulResult delete(@RequestParam("deptNo")Integer deptNo){
        // request param verification
        QueryWrapper<Department> departmentQueryWrapper = new QueryWrapper <>();
        departmentQueryWrapper.eq("dept_no", deptNo);
        Boolean result = departmentService.remove(departmentQueryWrapper);
        return new RestfulResult(200,"删除部门操作成功！" );
    }

    @PostMapping("/deleteMulti")
    @NeedPermissions(value = {"department:delete"})
    @ApiOperation(value = "管理员一次删除多个部门")
    public RestfulResult deleteMulti(@RequestBody List<Integer> deptNoSet){
        // request param verification
        //TODO
        return new RestfulResult(200,"删除多个部门操作成功！" );
    }

    @PostMapping("/editOne")
    @NeedPermissions(value = {"department:edit"})
    @ApiOperation(value = "管理员修改部门信息")
    public RestfulResult editOne(@RequestBody Department department){
        // request param verification
        QueryWrapper<Department> departmentQueryWrapper = new QueryWrapper <>();
        departmentQueryWrapper.eq("dept_no", department.getDeptNo());
        departmentService.update(department, departmentQueryWrapper);

        return new RestfulResult(200,"编辑部门操作成功！" );
    }
}
