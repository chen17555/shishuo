package com.chenzhiheng.service.impl;

import com.chenzhiheng.dto.BlogReplyDto;
import com.chenzhiheng.dto.BlogSaveDto;
import com.chenzhiheng.enums.StatusEnum;
import com.chenzhiheng.mapper.BlogMapper;
import com.chenzhiheng.mapper.BlogReplyMapper;
import com.chenzhiheng.mapper.BlogTagMapper;
import com.chenzhiheng.mapper.KeymanMapper;
import com.chenzhiheng.model.Blog;
import com.chenzhiheng.model.BlogReply;
import com.chenzhiheng.model.BlogTagKey;
import com.chenzhiheng.model.Keyman;
import com.chenzhiheng.service.BlogService;
import com.chenzhiheng.utils.ClickNumUtil;
import com.chenzhiheng.utils.ResultVOUtil;
import com.chenzhiheng.vo.BlogVO;
import com.chenzhiheng.vo.ResultVO;
import com.chenzhiheng.vo.UserVO;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogMapper blogMapper;

    @Autowired
    BlogReplyMapper blogReplyMapper;

    @Autowired
    BlogTagMapper blogTagMapper;

    @Autowired
    KeymanMapper keymanMapper;

    @Override
    public ResultVO saveBlog(BlogSaveDto blog, UserVO user) {
        try {
            Integer primaryKey = keymanMapper.selectPrimaryKeyByTableName("blog");
            Blog blogSave = new Blog();
            blogSave.setBlogId(primaryKey);
            blogSave.setBlogTitle(blog.getTitle());
            blogSave.setBlogContent(blog.getContent());
            blogSave.setUserId(user.getUserId());
            blogSave.setBlogStatus(StatusEnum.ACTIVE.getCode());
            blogSave.setClickNum(0);
            blogSave.setCreateTime(new Date());
            blogSave.setUpdateTime(new Date());
            blogMapper.insert(blogSave);

            keymanMapper.updatePrimaryKeyByTableName(new Keyman("blog"));

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
        Integer primaryKey = keymanMapper.selectPrimaryKeyByTableName("blog_reply");
        BlogReply reply1Save = new BlogReply();
        reply1Save.setBlogReplyId(primaryKey);
        reply1Save.setUserId(user.getUserId());
        reply1Save.setCreateTime(new Date());
        reply1Save.setReplyContent(reply.getContent());
        reply1Save.setParentId(reply.getParentId());
        reply1Save.setReplyStatus(StatusEnum.ACTIVE.getCode());
        blogReplyMapper.insertSelective(reply1Save);
        keymanMapper.updatePrimaryKeyByTableName(new Keyman("blog_reply"));
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
