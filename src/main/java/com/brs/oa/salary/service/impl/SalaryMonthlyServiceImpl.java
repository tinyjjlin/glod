package com.brs.oa.salary.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brs.oa.comm.annotation.QueryFilter;
import com.brs.oa.salary.entity.SalaryMonthly;
import com.brs.oa.salary.mapper.SalaryMonthlyMapper;
import com.brs.oa.salary.service.ISalaryMonthlyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brs.oa.salary.vo.ComplexSalaryVo;
import com.brs.oa.salary.vo.SimpleSalaryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-04
 */
@Service
public class SalaryMonthlyServiceImpl extends ServiceImpl<SalaryMonthlyMapper, SalaryMonthly> implements ISalaryMonthlyService {

    @Autowired(required = false)
    private SalaryMonthlyMapper salaryMonthlyMapper;
    @Override
    public SimpleSalaryVo getOwnSalaryInfo(Integer empNo) {
        return salaryMonthlyMapper.queryOwnByEmpNo(empNo);
    }

    @Override
    public Page<ComplexSalaryVo> getPageList(Page <ComplexSalaryVo> page) {
        return  page.setRecords(salaryMonthlyMapper.queryList(page));
    }

    @Override
    @QueryFilter(voName = "SimpleSalaryVo")
    public JSONObject getOwnSalaryInfoFilter(Integer empNo) {
        return (JSONObject) JSONObject.toJSON(getOwnSalaryInfo(empNo));
    }

    @Override
    @QueryFilter(voName = "ComplexSalaryVo")
    public JSONArray getPageListFilter(Page <ComplexSalaryVo> page) {
       return (JSONArray) JSONArray.toJSON(getPageList(page).getRecords());
    }
}
