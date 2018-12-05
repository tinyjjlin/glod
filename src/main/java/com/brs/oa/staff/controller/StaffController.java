package com.brs.oa.staff.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brs.oa.comm.annotation.Authentication;
import com.brs.oa.comm.model.RestfulResult;
import com.brs.oa.staff.service.IStaffService;
import com.brs.oa.staff.vo.SimpleStaffVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-04
 */
@RestController
@RequestMapping("/api/staff")
@Api("员工管理模块")
public class StaffController {

    @Autowired
    private IStaffService staffService;

    @ApiOperation(value = "分页查看员工信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", value = "要查看的页数", dataType = "int", defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", name = "size", value = "每页显示的数据行数", dataType = "int", defaultValue = "10")
    })
    @GetMapping("/list")
    @Authentication
    public RestfulResult list(@RequestParam(required = false, defaultValue = "1") Integer page, @RequestParam(required = false, defaultValue = "10") Integer size) {
        List <SimpleStaffVo> staffVoList = staffService.getPageList(new Page <>(page, size)).getRecords();
        return new RestfulResult(200, "查看员工列表", staffVoList);
    }
}
