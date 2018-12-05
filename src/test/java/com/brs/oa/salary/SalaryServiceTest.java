package com.brs.oa.salary;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brs.oa.salary.service.impl.SalaryMonthlyServiceImpl;
import com.brs.oa.salary.vo.ComplexSalaryVo;
import com.brs.oa.salary.vo.SimpleSalaryVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author tiny lin
 * @date 2018/12/4
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SalaryServiceTest {

    @Autowired
    private SalaryMonthlyServiceImpl salaryMonthlyService;

    @Test
    public void getOwnSalary(){
       SimpleSalaryVo simpleSalaryVo =  salaryMonthlyService.getOwnSalaryInfo(100057);
       System.out.println("test............."+simpleSalaryVo);
    }
    @Test
    public void getList(){
        Page<ComplexSalaryVo> page = salaryMonthlyService.getPageList(new Page <>(1,10));
        List<ComplexSalaryVo> list = page.getRecords();
//        for (ComplexSalaryVo complexSalaryVo : list) {
//            System.out.println("complexSalaryVo:"+complexSalaryVo.getPayment());
//        }
    }
}
