package com.brs.oa.vofield.mapper;

import com.brs.oa.vofield.entity.VoField;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.brs.oa.vofield.vo.FieldVo;
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
public interface VoFieldMapper extends BaseMapper<VoField> {
    /**
     * 获取员工访问Vo 字段信息
     * @param empNo
     * @param VoName
     * @return
     */
    @Select("select vf.field_name,vf.field_desc,vf.field_type,vf.from_vo,rvf.is_enabled   from vo_field as vf\n" +
            "left join role_vo_field as rvf \n" +
            "on rvf.field_no = vf.field_no\n" +
            "left join role as r \n" +
            "on rvf.role_no = r.role_no\n" +
            "left join staff_role_relation as srr \n" +
            "on srr.role_no = r.role_no\n" +
            "where srr.emp_no =#{empNo} and vf.from_vo=#{voName}")
    public List<FieldVo> queryByEmpNoAndVoName(@Param("empNo") Integer empNo, @Param("voName") String VoName);
}
