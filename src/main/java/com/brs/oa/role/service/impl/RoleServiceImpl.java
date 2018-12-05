package com.brs.oa.role.service.impl;

import com.brs.oa.role.entity.Role;
import com.brs.oa.role.mapper.RoleMapper;
import com.brs.oa.role.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brs.oa.role.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-05
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired(required = false)
    private RoleMapper roleMapper;

    @Override
    public int addRoleVo(RoleVo roleVo) {
        return roleMapper.append(roleVo);
    }

    @Override
    public List<Role> getListByEmpNo(Integer empNo) {
        return roleMapper.queryListByEmpo(empNo);
    }

    @Override
    public int createNewRole(RoleVo roleVo) {
        int result =0;
        result = addRoleVo(roleVo);
        if(result == 0){
            return 0;
        }
        result = addRolePermission(roleVo);
        return result;
    }

    @Override
    public int addRolePermission(RoleVo roleVo) {
        return roleMapper.appendRolePermission(roleVo.getRoleNo(), roleVo.getPermissionList());
    }

    @Override
    public Boolean updateRoleInfo(RoleVo roleVo) {
        Boolean flag =true;
        int result1 = updateRoleVo(roleVo);
        int result2 = updateRolePermission(roleVo);

        if(result1<1 || result2<1){
            flag = false;
        }
        return flag;
    }

    @Override
    public int updateRolePermission(RoleVo roleVo) {
        return roleMapper.amendRolePermission(roleVo.getRoleNo(),roleVo.getPermissionList() );
    }

    @Override
    public int updateRoleVo(RoleVo roleVo) {
        return roleMapper.amend(roleVo);
    }
}
