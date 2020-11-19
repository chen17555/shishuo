package com.chenzhiheng.TestMapper;

import com.chenzhiheng.mapper.ReportTypeMapper;
import com.chenzhiheng.model.ReportType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestReportTypeMapper {

    @Autowired
    ReportTypeMapper reportTypeMapper;

    @Test
    public void TestAdd(){
        String[] reportTypes = {"广告或垃圾信息","辱骂","摄政或违法信息","抄袭","不合适内容"};
        for(int i = 0;i < reportTypes.length;i++){
            ReportType reportType = new ReportType();
            reportType.setReportTypeId(i);
            reportType.setReportTypeName(reportTypes[i]);
            reportType.setCreateTime(new Date());
            reportTypeMapper.insertSelective(reportType);
        }
    }
}
