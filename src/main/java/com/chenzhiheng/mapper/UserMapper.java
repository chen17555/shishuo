package com.chenzhiheng.mapper;

import com.chenzhiheng.model.User;
import org.apache.ibatis.annotations.Param;
import com.chenzhiheng.vo.UserVO;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    Integer selectByUserNameAndPassword(@Param("username") String username,@Param("password") String password);

    List<UserVO> selectAll();
}