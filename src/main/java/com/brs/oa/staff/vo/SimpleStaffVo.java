package com.brs.oa.staff.vo;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author tiny lin
 * @date 2018/12/5
 */
@Data
public class SimpleStaffVo {

    private Integer empNo;
    private String name;
    private String email;
    private LocalDate birthday;
    private LocalDate hireDate;
    private String mobile;

    private String position;

    private Integer gender;

    /**
     * 员工头像
     */
    private String picture;

}
