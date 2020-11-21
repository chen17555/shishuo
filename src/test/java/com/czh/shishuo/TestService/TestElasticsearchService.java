package com.czh.shishuo.TestService;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.czh.shishuo.service.ElasticsearchService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestElasticsearchService {

    @Autowired
    ElasticsearchService elasticsearchService;



}
