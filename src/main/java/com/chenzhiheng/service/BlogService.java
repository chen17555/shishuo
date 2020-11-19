package com.chenzhiheng.service;

import com.chenzhiheng.vo.BlogVO;
import com.chenzhiheng.dto.BlogReplyDto;
import com.chenzhiheng.dto.BlogSaveDto;
import com.chenzhiheng.vo.ResultVO;
import com.chenzhiheng.vo.UserVO;

import java.util.List;
import java.util.Map;

public interface BlogService {

    ResultVO saveBlog(BlogSaveDto blog, UserVO user);

    ResultVO saveBlogReply(BlogReplyDto reply,UserVO user);

    BlogVO showBlogDetail(int blogId);

    List<BlogVO> showBlogNewData(int pageNum, int pageSize);

    List<BlogVO> showBlogRecommendData(int pageNum, int pageSize);

    List<BlogVO> showBlogByTitleOrUserOrTime(Map<String, Object> map);

    int updateBlogClick(int blogId,int clickNum);


}
