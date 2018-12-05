package com.brs.oa.role.mapper;

import com.brs.oa.role.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.brs.oa.role.vo.RoleVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-05
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据员工名获取所有角色信息
     * @param empNo
     * @return
     */
    @Select("select br.role_no,br.name,br.description,br.available from brs_role as br \n" +
            "left join brs_user_role as bru \n" +
            "on bru.role_no = br.role_no\n" +
            "where bru.user_emp_no =#{empNo} " )

    List<Role> queryListByEmpo(@Param("empNo")Integer empNo);

    /**
     * 为角色添加权限
     * @param roleNo
     * @param permissionList
     * @return
     */
    @Insert({
            "<script>",
            "insert into brs_role_permission(role_no,permi_no)values",
            "<foreach collection='permissionList' item='item' index='index' separator=','>",
            "(#{roleNo},#{item})",
            "</foreach>",
            "</script>"
    })
    int appendRolePermission(@Param("roleNo")Integer roleNo, @Param("permissionList") List<Integer> permissionList);

    /**
     * 插入新的角色
     * @param roleVo
     */
    @Insert("insert into brs_role(role_no,name,description,available)values(#{roleVo.roleNo},#{roleVo.name},#{roleVo.description},#{roleVo.available})")
    int append(@Param("roleVo") RoleVo roleVo);


    /**
     * 更新角色
     * @param roleVo
     * @return
     */
    @Update("update brs_role set name=#{roleVo.name},description=#{roleVo.description},available=#{roleVo.available} where role_no =#{roleVo.roleNo} ")
    int amend(@Param("roleVo") RoleVo roleVo);

    /**
     * 更新角色权限
     * @param roleNo
     * @param permissionList
     * @return
     */
    @Update({
            "<script>",
            "<foreach collection='permissionList' item='item' index='index' separator=','>",
            "update brs_role_permission",
            "set role_no=#{roleNo},permi_no=#{item}",
            "</foreach>",
            "</script>"
    })
    int amendRolePermission(@Param("roleNo")Integer roleNo, @Param("permissionList") List<Integer> permissionList);
}
