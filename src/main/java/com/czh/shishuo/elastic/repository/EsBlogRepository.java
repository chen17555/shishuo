package com.czh.shishuo.elastic.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.czh.shishuo.elastic.es.EsBlog;

public interface EsBlogRepository  {

    Page<EsBlog> findDistinctEsBlogByTitleContainingOrContentContaining(String title, String content, Pageable pageable);
}
