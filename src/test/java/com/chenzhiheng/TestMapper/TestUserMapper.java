package com.chenzhiheng.TestMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.chenzhiheng.enums.UserStatusEnum;
import com.chenzhiheng.mapper.NoticeMapper;
import com.chenzhiheng.mapper.UserInfoMapper;
import com.chenzhiheng.mapper.UserMapper;
import com.chenzhiheng.model.Notice;
import com.chenzhiheng.model.User;
import com.chenzhiheng.model.UserInfo;
import com.chenzhiheng.utils.RandDataUtil;

import java.util.Date;

@EnableTransactionManagement
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserMapper {

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserInfoMapper userInfoMapper;


    @Autowired
    NoticeMapper noticeMapper;

    @Test
    public void test(){
        for(int i = 0;i <= 100;i++){
            Notice notice = new Notice();
            notice.setNoticeId(100 + i);
            notice.setNoticeTitle(RandDataUtil.getEnglishName(10,25));
            notice.setNoticeContent(RandDataUtil.getEnglishName(100,500));
            notice.setCreateTime(new Date());
            notice.setUpdateTime(new Date());
            noticeMapper.insert(notice);
        }
    }

    @Test
    public void testInsert(){
        for(int i = 1; i < 1000; i++){
            User user = new User();
            user.setUserId(1000 + i);
            user.setUserName(RandDataUtil.getEnglishName(6,10));
            user.setUserPwd(RandDataUtil.getEnglishName(8,16));
            user.setUserStatus(UserStatusEnum.ACTIV.getCode());
            user.setCreateTime(new Date());
            int id = userMapper.insert(user);
            System.out.println(id);
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(user.getUserId());
            int sex = (int)Math.random()*10;
            if(sex % 2 == 0){
                userInfo.setUserSex(true);
                userInfo.setUserNickname(RandDataUtil.getChineseName(1));
            }else{
                userInfo.setUserSex(false);
                userInfo.setUserNickname(RandDataUtil.getChineseName(2));
            }
            userInfo.setUserAge(RandDataUtil.getNum(15,55));
            userInfo.setUserPhone(RandDataUtil.getTel());
            userInfo.setUserEmail(RandDataUtil.getEmail(8,10));
            userInfo.setUserDesc("这位童鞋很懒，什么也没有留下～～！");
            userInfo.setUserAvatar("static/avatar/default.jpg");
            userInfo.setCreateTime(new Date());
            userInfoMapper.insert(userInfo);
        }
    }



    @Test
    public void testSelect(){
        System.out.println(userMapper.selectByUserNameAndPassword("admin","admin"));
    }
}
