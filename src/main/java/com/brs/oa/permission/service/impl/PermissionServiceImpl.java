package com.brs.oa.permission.service.impl;

import com.brs.oa.permission.entity.Permission;
import com.brs.oa.permission.mapper.PermissionMapper;
import com.brs.oa.permission.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    @Autowired(required = false)
    private PermissionMapper permissionMapper;
    @Override
    public List<Permission> getPermissionListByEmpNo(Integer empNo) {
        return permissionMapper.queryListByEmpNo(empNo);
    }
}
