package com.brs.oa.staff.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brs.oa.staff.entity.Staff;
import com.brs.oa.staff.mapper.StaffMapper;
import com.brs.oa.staff.service.IStaffService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brs.oa.staff.vo.SimpleStaffVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-04
 */
@Service
public class StaffServiceImpl extends ServiceImpl <StaffMapper, Staff> implements IStaffService {

    @Autowired(required = false)
    private StaffMapper staffMapper;

    @Override
    public Page <SimpleStaffVo> getPageList(Page <SimpleStaffVo> page) {
        return page.setRecords(staffMapper.queryList(page));
    }
}
