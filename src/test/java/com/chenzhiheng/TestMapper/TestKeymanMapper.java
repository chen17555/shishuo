package com.chenzhiheng.TestMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.chenzhiheng.mapper.KeymanMapper;
import com.chenzhiheng.model.Keyman;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestKeymanMapper {

    @Autowired
    KeymanMapper keymanMapper;

    @Test
    public void test(){
        keymanMapper.updatePrimaryKeyByTableName(new Keyman("question"));
        System.out.println(keymanMapper.selectPrimaryKeyByTableName("question"));
    }

}
