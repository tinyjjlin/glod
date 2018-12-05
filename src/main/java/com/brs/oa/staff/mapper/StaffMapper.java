package com.brs.oa.staff.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.brs.oa.staff.entity.Staff;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.brs.oa.staff.vo.SimpleStaffVo;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-04
 */
public interface StaffMapper extends BaseMapper<Staff> {

    /**
     * 分页查询 用户列表
     *
     * @param page
     * @return
     */
    @Select("select staff.emp_no,staff.name,staff.email,staff.picture,staff.gender,staff.position,staff.mobile from staff")
    List <SimpleStaffVo> queryList(Page<SimpleStaffVo> page);



}
