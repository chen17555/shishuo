package com.czh.shishuo.service;

import java.util.List;

public interface ElasticsearchService {


    List goSearch(String words);

    List searchByTitleOrContent(String words);
}
