package com.chenzhiheng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.chenzhiheng.dto.UserLoginDto;
import com.chenzhiheng.model.Tag;
import com.chenzhiheng.service.TagService;
import com.chenzhiheng.service.UserService;
import com.chenzhiheng.utils.ResultVOUtil;
import com.chenzhiheng.vo.BlogVO;
import com.chenzhiheng.vo.QuestionVO;
import com.chenzhiheng.vo.ResultVO;
import com.chenzhiheng.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    TagService tagService;

    @RequestMapping("u/{userId}")
    public ModelAndView info(@PathVariable("userId")Integer userId){
        ModelAndView mv = new ModelAndView("user/user");
        UserVO user = userService.searchUserByUserId(userId);
        mv.addObject("host",user);
        return mv;
    }

    @RequestMapping("login")
    @ResponseBody
    public ResultVO<UserVO> login(UserLoginDto user, HttpServletRequest request,
                                  HttpServletResponse response){
        UserVO userVO = userService.login(user);
        if(userVO != null){
            request.getSession().setAttribute(SessionBean.SESSION_KEY_OF_USER, userVO);
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error(-1,"用户名或密码错误");
    }

    @RequestMapping("logout")
    @ResponseBody
    public ResultVO logout(HttpServletRequest request){
        request.getSession().removeAttribute(SessionBean.SESSION_KEY_OF_USER);
        return ResultVOUtil.success();
    }

    @RequestMapping("follow/tag")
    @ResponseBody
    public ResultVO followTag(Tag tag,HttpServletRequest request){
        UserVO user = (UserVO) request.getSession().getAttribute(SessionBean.SESSION_KEY_OF_USER);
        if(user != null){
            request.getSession().setAttribute(SessionBean.SESSION_KEY_OF_USER, user);
            return userService.userFollowTags(user,tag);
        }
        return ResultVOUtil.error(-1,"请登录");
    }

    @RequestMapping("register")
    @ResponseBody
    public ResultVO<UserVO> register(UserVO user){
        try{
            userService.register(user);
            return ResultVOUtil.success();
        }catch(Exception e){
            return ResultVOUtil.error(-1,e.getMessage());
        }
    }

    @RequestMapping(value = "u/{userId}/question",method = RequestMethod.GET)
    public ModelAndView questionInfo(@PathVariable("userId")Integer userId){
        ModelAndView mv = new ModelAndView("user/user_question");
        UserVO user = userService.searchUserByUserId(userId);
        mv.addObject("host",user);
        return mv;
    }

    @RequestMapping(value = "u/{userId}/question",method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<QuestionVO>  myQuestion(@PathVariable("userId")Integer userId,@RequestParam(value="sort", defaultValue="")String sort,
                                            @RequestParam(value="page", defaultValue="1")int page){
        UserVO user = new UserVO();
        user.setUserId(userId);
        List<QuestionVO>  list = userService.showQuestionListBySort(page,10,sort,user);
        return ResultVOUtil.success(list);
    }

    @RequestMapping(value = "u/{userId}/blog",method = RequestMethod.GET)
    public ModelAndView blogInfo(@PathVariable("userId")Integer userId){
        ModelAndView mv = new ModelAndView("user/user_blog");
        UserVO user = userService.searchUserByUserId(userId);
        mv.addObject("host",user);
        return mv;
    }

    @RequestMapping("u/{userId}/blog")
    @ResponseBody
    public ResultVO<BlogVO>  myBlog(@PathVariable("userId")Integer userId,@RequestParam(value="sort", defaultValue="")String sort,
                                    @RequestParam(value="page", defaultValue="1")int page){
        UserVO user = new UserVO();
        user.setUserId(userId);
        return null;
    }

    @RequestMapping(value = "u/{userId}/history",method = RequestMethod.GET)
    public ModelAndView history(@PathVariable("userId")Integer userId){
        ModelAndView mv = new ModelAndView("user/user_history");
        UserVO user = userService.searchUserByUserId(userId);
        mv.addObject("host",user);
        return mv;
    }

    @RequestMapping(value = "u/{userId}/setting",method = RequestMethod.GET)
    public ModelAndView setting(@PathVariable("userId")Integer userId){
        ModelAndView mv = new ModelAndView("user/user_setting");
        UserVO user = userService.searchUserByUserId(userId);
        return mv;
    }

    @RequestMapping(value="/author", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO author(){
        return null;
    }
}
