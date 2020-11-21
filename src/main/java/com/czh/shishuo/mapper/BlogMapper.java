package com.czh.shishuo.mapper;

import com.czh.shishuo.model.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.czh.shishuo.vo.BlogVO;

import java.util.List;
import java.util.Map;

@Mapper
public interface BlogMapper {
    int deleteByPrimaryKey(Integer blogId);

    int insert(Blog record);

    int insertSelective(Blog record);

    Blog selectByPrimaryKey(Integer blogId);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKey(Blog record);

    int updateBlogClickByBlogId(@Param("blogId") int blogId,@Param("clickNum") int clickNum);

    List<BlogVO> selectRecommendData();

    List<BlogVO> selectNewData();

    List<BlogVO> selectRecommendDataByTag(int tagId);

    List<BlogVO> selectNewDataByTag(int tagId);

    List<BlogVO> selectQuestionListByUserId(int userId);

    List<BlogVO> selectQuestionListByReplyUserId(int userId);

    List<BlogVO> selectQuestionListByUserCollect(int userId);

    List<BlogVO> selectQuestionListByUserIdOrTitleOrTime(Map<String,Object> map);

    BlogVO selectBlogByBlogId(Integer blogId);
}