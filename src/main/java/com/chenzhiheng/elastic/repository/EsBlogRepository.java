package com.chenzhiheng.elastic.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.chenzhiheng.elastic.es.EsBlog;

public interface EsBlogRepository  {

    Page<EsBlog> findDistinctEsBlogByTitleContainingOrContentContaining(String title, String content, Pageable pageable);
}
