package com.czh.shishuo.admin.dao;

import com.czh.shishuo.admin.vo.UserVO;
import com.czh.shishuo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    Integer selectByUserNameAndPassword(@Param("username") String username, @Param("password") String password);

    List<UserVO> selectAll();
}