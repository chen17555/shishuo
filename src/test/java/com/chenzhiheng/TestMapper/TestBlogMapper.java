package com.chenzhiheng.TestMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.chenzhiheng.enums.StatusEnum;
import com.chenzhiheng.mapper.BlogMapper;
import com.chenzhiheng.mapper.BlogReplyMapper;
import com.chenzhiheng.mapper.BlogTagMapper;
import com.chenzhiheng.model.Blog;
import com.chenzhiheng.model.BlogReply;
import com.chenzhiheng.model.BlogTagKey;
import com.chenzhiheng.utils.RandDataUtil;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestBlogMapper {

    @Autowired
    BlogMapper blogMapper;

    @Autowired
    BlogReplyMapper blogReplyMapper;

    @Autowired
    BlogTagMapper blogTagMapper;

    @Test
    public void testInsertTestData(){
        for(int i = 0;i < 100;i++){
            Blog blog = new Blog();
            blog.setBlogId(1001 + i);
            blog.setUserId(RandDataUtil.getNum(1000,1999));
            blog.setCreateTime(new Date());
            blog.setUpdateTime(new Date());
            blog.setClickNum(RandDataUtil.getNum(1,100));
            blog.setBlogTitle(RandDataUtil.getEnglishName(15,30));
            blog.setBlogContent(RandDataUtil.getEnglishName(300,500));
            blog.setBlogStatus(StatusEnum.ACTIVE.getCode());
            blogMapper.insert(blog);
        }
    }

    @Test
    public void testInsertReplyData(){
        for(int i = 0;i < 1000;i++){
            BlogReply reply = new BlogReply();
            reply.setBlogReplyId(1000 + i);
            reply.setBlogId(RandDataUtil.getNum(1000,1100));
            reply.setUserId(RandDataUtil.getNum(1000,1999));
            reply.setParentId(null);
            reply.setReplyContent(RandDataUtil.getEnglishName(40,60));
            reply.setCreateTime(new Date());
            reply.setUpdataTime(new Date());
            blogReplyMapper.insertSelective(reply);
        }
    }

    @Test
    public void testInsertTagData(){
        for(int i = 1001;i <= 1100;i++){
            Integer tagId = 0;
            for(int j = 0;j <= i % 2;j++){
                BlogTagKey blogTagKey = new BlogTagKey();
                blogTagKey.setBlogId(i);
                Integer tagIb = RandDataUtil.getNum(100,139);
                if(tagIb != tagId){
                    tagId = tagIb;
                    blogTagKey.setTagId(tagId);
                    blogTagMapper.insert(blogTagKey);
                }
            }
        }
    }
}
