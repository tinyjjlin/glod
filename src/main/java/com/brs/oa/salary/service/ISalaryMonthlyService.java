package com.brs.oa.salary.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.brs.oa.salary.entity.SalaryMonthly;
import com.baomidou.mybatisplus.extension.service.IService;
import com.brs.oa.salary.vo.ComplexSalaryVo;
import com.brs.oa.salary.vo.SimpleSalaryVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-04
 */
public interface ISalaryMonthlyService extends IService<SalaryMonthly> {

    /**
     * 获取自己的工资条信息
     * @param empNo
     * @return
     */
    SimpleSalaryVo  getOwnSalaryInfo(Integer empNo);

    /**
     * 按字段权限显示每个人的工资条
     * @param empNo
     * @return
     */
    JSONObject getOwnSalaryInfoFilter(Integer empNo);

    /**
     * 分页获取员工工资信息
     * @param page
     * @return
     */
    public Page<ComplexSalaryVo> getPageList(Page<ComplexSalaryVo> page);

    /**
     * 按字段权限获取员工工资信息
     * @param page
     * @return
     */
    public JSONArray  getPageListFilter(Page<ComplexSalaryVo> page);

}
