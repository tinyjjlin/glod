package com.brs.oa.staff.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId
    private Integer id;
    private Integer empNo;

    private String name;

    private Integer deptNo;

    private String email;

    private LocalDate birthday;

    private LocalDate hireDate;

    private String nation;

    private String politicsStatus;

    private String highestDegree;

    private String maritalStatus;

    private String mobile;

    private String currentAddress;

    private String address;

    /**
     * 中华人民共和国身份证号
     */
    private String nationIdcard;

    private String position;

    private Integer gender;

    /**
     * 员工头像
     */
    private String picture;

    /**
     * 表创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 表修改时间
     */
    private LocalDateTime gmtModified;


}
