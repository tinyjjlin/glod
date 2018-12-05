package com.brs.oa.permission.service;

import com.brs.oa.permission.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-05
 */
public interface IPermissionService extends IService<Permission> {

    /**
     * 根据员工获取其所有权限信息
     * @param empNo
     * @return
     */
    public List<Permission> getPermissionListByEmpNo(Integer empNo);

}
