package com.brs.oa.permission.mapper;

import com.brs.oa.permission.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-05
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    @Select("select p.permission_no,permission_name,permission_code,p.is_enabled from permission as p\n" +
            "left join role_permission_relation as rpr \n" +
            "on rpr.permission_no = p.permission_no\n" +
            "left join role \n" +
            "on rpr.role_no = role.role_no\n" +
            "left join staff_role_relation as srr \n" +
            "on role.role_no = srr.role_no\n" +
            "where srr.emp_no = #{empNo}")
    List<Permission> queryListByEmpNo(@Param("empNo")Integer empNo);
}
