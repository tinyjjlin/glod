package com.brs.oa.staff.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brs.oa.staff.entity.Staff;
import com.baomidou.mybatisplus.extension.service.IService;
import com.brs.oa.staff.vo.SimpleStaffVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-04
 */
public interface IStaffService extends IService<Staff> {

    /**
     * 分页查看员工列表
     * @param page
     * @return
     */
    public Page<SimpleStaffVo> getPageList(Page<SimpleStaffVo> page);

}
