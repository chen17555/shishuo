package com.czh.shishuo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.czh.shishuo.service.ElasticsearchService;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class SearchController {

    @Resource
    ElasticsearchService elasticsearchService;

    @GetMapping("search")
    public ModelAndView searchIndex(){
        ModelAndView mv = new ModelAndView("search");
        return mv;
    }

    @GetMapping("search/")
    public ModelAndView searchList(String words){
        ModelAndView mv = new ModelAndView("search");
        List result = elasticsearchService.searchByTitleOrContent(words);
        mv.addObject("result",result);
        return mv;
    }

    @PostMapping("search")
    public List search(String words){
        return elasticsearchService.goSearch(words);
    }

}
