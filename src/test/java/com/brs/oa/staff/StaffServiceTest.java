package com.brs.oa.staff;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brs.oa.staff.service.IStaffService;
import com.brs.oa.staff.vo.SimpleStaffVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author tiny lin
 * @date 2018/12/5
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StaffServiceTest {

    @Autowired
    private IStaffService staffService;

  @Test
    public void getPageList(){
       List<SimpleStaffVo> list =staffService.getPageList(new Page <>(1,10)).getRecords();
        for (SimpleStaffVo simpleStaffVo : list) {
            System.out.println("staff:"+simpleStaffVo.getEmpNo());
        }
    }
}
