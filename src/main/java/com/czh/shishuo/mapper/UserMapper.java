package com.czh.shishuo.mapper;

import com.czh.shishuo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.czh.shishuo.vo.UserVO;

import java.util.List;

@Mapper
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