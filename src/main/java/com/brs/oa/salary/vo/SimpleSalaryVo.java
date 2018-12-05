package com.brs.oa.salary.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 个人工资条视图数据
 * @author tiny lin
 * @date 2018/12/4
 */
@Data
public class SimpleSalaryVo {
    /**
     * 中华人民共和国身份证号
     */
    private String nationIdcard;

    /**
     * 电话（手机号）
     */
    private String mobile;

    /**
     * 基本工资
     */
    private BigDecimal basicSalary;

    /**
     * 岗位津贴
     */
    private BigDecimal jobAllowance;

    /**
     * 交通补贴
     */
    private BigDecimal travelAllowance;

    /**
     * 餐费补贴
     */
    private BigDecimal  mealAllowance;


    /**
     * 个人税前工资
     */
    private BigDecimal payment;

    /**
     * 个人缴纳社保
     */
    private BigDecimal socialInsuranceOfStaff;

    /**
     * 个人所得税
     */
    private BigDecimal taxOfStaff;

    /**
     * 个人税后工资（到手）
     */
    private BigDecimal paymentInHand;


    /**
     * 浮动工资
     */
    private BigDecimal bonusSalary;


    /**
     * 提成
     */
    private BigDecimal commission;

    /**
     * 事假扣除
     */
    private BigDecimal deduction;


    /**
     * 员工工号
     */
    private Integer empNo;

    /**
     * 日期
     */
    private LocalDate settlementDay;


    /**
     * 补充说明
     */
    private String description;


}
