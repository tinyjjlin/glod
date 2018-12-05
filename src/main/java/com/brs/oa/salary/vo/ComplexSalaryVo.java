package com.brs.oa.salary.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 财务组可以查看员工工资视图数据
 * @author tiny lin
 * @date 2018/12/4
 */
@Data
public class ComplexSalaryVo {
    /**
     * 员工工号
     */
    private Integer empNo;

    /**
     * 日期
     */
    private LocalDate settlementDay;

    /**
     * 基本工资
     */
    private BigDecimal basicSalary;

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
     * 公司缴纳社保
     */
    private BigDecimal socialInsuranceOfCompany;

    /**
     * 公司支出合计
     */
    private BigDecimal expenditure;

    /**
     * 补充说明
     */
    private String description;

    /**
     * 表创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 表修改时间
     */
    private LocalDateTime gmtModified;
}
