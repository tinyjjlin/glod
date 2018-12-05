package com.brs.oa.role.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

/**
 * @author tiny lin
 * @date 2018/11/29
 */

@Data
public class RoleVo {

    private Integer roleNo;

    private String description;

    private Integer available;

    private String name;

    private List<Integer> permissionList;
}
