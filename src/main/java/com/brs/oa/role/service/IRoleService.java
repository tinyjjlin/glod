package com.brs.oa.role.service;

import com.brs.oa.role.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.brs.oa.role.vo.RoleVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-05
 */
public interface IRoleService extends IService<Role> {

    /**
     * 根据员工号获取角色列表
     * @param empNo
     * @return
     */
    public List<Role> getListByEmpNo(Integer empNo);
    /**
     * 新建角色，并分配权限
     * @param roleVo
     * @return
     */
    public int createNewRole(RoleVo roleVo);

    /**
     * 添加角色
     * @param roleVo
     * @return
     */
    public int addRoleVo(RoleVo roleVo);
    /**
     * 添加角色权限
     * @return
     */
    public int addRolePermission(RoleVo roleVo);


    /**
     * 更新角色信息（包含其分配的权限资源）
     * @param roleVo
     * @return
     */
    public Boolean  updateRoleInfo(RoleVo roleVo);
    /**
     * 更新角色
     * @param roleVo
     * @return
     */
    public  int updateRoleVo(RoleVo roleVo);

    /**
     * 更新角色权限
     * @param roleVo
     * @return
     */
    public int  updateRolePermission(RoleVo roleVo);

}
