package com.czh.shishuo.admin.service.impl;

import com.czh.shishuo.admin.dao.BlogMapper;
import com.czh.shishuo.admin.dao.BlogReplyMapper;
import com.czh.shishuo.admin.dao.BlogTagMapper;
import com.czh.shishuo.admin.dto.BlogReplyDto;
import com.czh.shishuo.admin.dto.BlogSaveDto;
import com.czh.shishuo.admin.service.BlogService;
import com.czh.shishuo.admin.vo.BlogVO;
import com.czh.shishuo.admin.vo.UserVO;
import com.czh.shishuo.enums.StatusEnum;
import com.czh.shishuo.model.Blog;
import com.czh.shishuo.model.BlogReply;
import com.czh.shishuo.model.BlogTagKey;
import com.czh.shishuo.model.Keyman;
import com.czh.shishuo.utils.ClickNumUtil;
import com.czh.shishuo.utils.ResultVOUtil;
import com.czh.shishuo.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl implements BlogService {

    @Resource
    BlogMapper blogMapper;

    @Resource
    BlogReplyMapper blogReplyMapper;

    @Resource
    BlogTagMapper blogTagMapper;


    @Override
    public ResultVO saveBlog(BlogSaveDto blog, UserVO user) {
        try {
            Blog blogSave = new Blog();
            blogSave.setBlogTitle(blog.getTitle());
            blogSave.setBlogContent(blog.getContent());
            blogSave.setUserId(user.getUserId());
            blogSave.setBlogStatus(StatusEnum.ACTIVE.getCode());
            blogSave.setClickNum(0);
            blogSave.setCreateTime(new Date());
            blogSave.setUpdateTime(new Date());
            blogMapper.insert(blogSave);

            String[] tags = blog.getTags().split(",");
            for(int i = 0;i < tags.length;i++){
                BlogTagKey tag = new BlogTagKey();
                tag.setTagId(Integer.valueOf(tags[i]));
                tag.setBlogId(blogSave.getBlogId());
                blogTagMapper.insert(tag);
            }
        }catch (RuntimeException e) {
            e.printStackTrace();
            return ResultVOUtil.error(-1,e.getMessage());
        }
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO saveBlogReply(BlogReplyDto reply, UserVO user) {
        BlogReply reply1Save = new BlogReply();
        reply1Save.setUserId(user.getUserId());
        reply1Save.setCreateTime(new Date());
        reply1Save.setReplyContent(reply.getContent());
        reply1Save.setParentId(reply.getParentId());
        reply1Save.setReplyStatus(StatusEnum.ACTIVE.getCode());
        blogReplyMapper.insertSelective(reply1Save);
        return ResultVOUtil.success();
    }


    @Override
    public BlogVO showBlogDetail(int blogId) {
        return blogMapper.selectBlogByBlogId(blogId);
    }

    @Override
    public List<BlogVO> showBlogNewData(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return blogMapper.selectNewData();
    }

    @Override
    public List<BlogVO> showBlogRecommendData(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return blogMapper.selectRecommendData();
    }

    @Override
    public List<BlogVO> showBlogByTitleOrUserOrTime(Map<String, Object> map) {
        
        return null;
    }

    @Override
    public int updateBlogClick(int blogId, int clickNum) {
        clickNum = ClickNumUtil.getLuckClick();
        return blogMapper.updateBlogClickByBlogId(blogId,clickNum);
    }
}
