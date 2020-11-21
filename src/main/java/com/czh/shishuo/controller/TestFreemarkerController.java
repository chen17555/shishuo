package com.czh.shishuo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class TestFreemarkerController {

    @RequestMapping(value = "/test")
    public String testList(Map<String,Object> model){
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < 5;i++){
            list.add(i);
        }
        model.put("list",list);
        return "test";
    }

}
