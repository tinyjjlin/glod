package com.brs.oa.salary.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brs.oa.comm.annotation.Authentication;
import com.brs.oa.comm.annotation.NeedPermissions;
import com.brs.oa.comm.model.RestfulResult;
import com.brs.oa.salary.service.ISalaryMonthlyService;
import com.brs.oa.salary.vo.ComplexSalaryVo;
import com.brs.oa.util.CommonUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-04
 */
@RestController
@RequestMapping("/api/salary")
public class SalaryMonthlyController {

    @Autowired
    private ISalaryMonthlyService salaryMonthlyService;

    @ApiOperation(value = "分页查看员工每月工资信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", value = "要查看的页数", dataType = "int", defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", name = "size", value = "每页显示的行数", dataType = "int", defaultValue = "10")
    })
    @GetMapping("/list")
    @NeedPermissions("salary:list")
    public RestfulResult list(@RequestParam(required = false,defaultValue = "1") Integer page, @RequestParam(required = false,defaultValue = "1") Integer size){
        JSONArray salaryListJson = salaryMonthlyService.getPageListFilter(new Page<ComplexSalaryVo>(page,size));
        return new RestfulResult(200,"查看所有员工工资",salaryListJson );
    }

    @ApiOperation(value = "查看自己每月的工资信息")
    @GetMapping("/own")
    @Authentication
    public RestfulResult lookOwn(HttpServletRequest request){
        Integer empNo = CommonUtil.getEmployeeNoFromRequest(request);
        JSONObject ownSalaryInfoJson = salaryMonthlyService.getOwnSalaryInfoFilter(empNo);
        return new RestfulResult(200,"查看个人工资条",ownSalaryInfoJson);
    }

}
