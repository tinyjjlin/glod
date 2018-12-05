package com.brs.oa.salary.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brs.oa.salary.entity.SalaryMonthly;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.brs.oa.salary.vo.ComplexSalaryVo;
import com.brs.oa.salary.vo.SimpleSalaryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-04
 */
@Mapper
public interface SalaryMonthlyMapper extends BaseMapper<SalaryMonthly> {

    /**
     * 查看自己的工资条信息（受限）
     * @param ownEmpNo
     * @return
     */
    @Select("select basic_Salary,job_allowance,travel_allowance,meal_allowance,social_insurance_of_staff,tax_of_staff,payment_in_hand,commission," +
            "deduction,settlement_day,description,emp_no from salary_monthly where emp_no =#{empNo}")
    public SimpleSalaryVo queryOwnByEmpNo(@Param("empNo") Integer ownEmpNo);

    /**
     * 查看所有员工工资信息（不受限）
     * @return
     */
    @Select("select basic_Salary,job_allowance,travel_allowance,meal_allowance,social_insurance_of_staff,tax_of_staff,payment_in_hand,commission," +
            "deduction,settlement_day,description,emp_no from salary_monthly")
    public List<ComplexSalaryVo> queryList(Page<ComplexSalaryVo> page);
    /**
     * 根据员工号查看其工资信息
     * @param empNo
     * @return
     */
    @Select("")
    public ComplexSalaryVo queryByEmpno(Integer empNo);
}
