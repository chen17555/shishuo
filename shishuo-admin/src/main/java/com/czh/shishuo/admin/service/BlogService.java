package com.czh.shishuo.admin.service;


import com.czh.shishuo.admin.dto.BlogReplyDto;
import com.czh.shishuo.admin.dto.BlogSaveDto;
import com.czh.shishuo.admin.vo.BlogVO;
import com.czh.shishuo.admin.vo.UserVO;
import com.czh.shishuo.vo.ResultVO;

import java.util.List;
import java.util.Map;

public interface BlogService {

    ResultVO saveBlog(BlogSaveDto blog, UserVO user);

    ResultVO saveBlogReply(BlogReplyDto reply, UserVO user);

    BlogVO showBlogDetail(int blogId);

    List<BlogVO> showBlogNewData(int pageNum, int pageSize);

    List<BlogVO> showBlogRecommendData(int pageNum, int pageSize);

    List<BlogVO> showBlogByTitleOrUserOrTime(Map<String, Object> map);

    int updateBlogClick(int blogId, int clickNum);


}
