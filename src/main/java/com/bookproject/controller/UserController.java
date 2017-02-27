package com.bookproject.controller;

import com.bookproject.model.User;
import com.bookproject.service.user.IUserService;
import com.bookproject.util.IUtil;
import com.bookproject.util.Util;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017/2/25.
 */
@Controller
public class UserController {
    @Autowired
    private IUserService userServiceImpl;

    @RequestMapping(value = "/userAdd",method = RequestMethod.GET)
    public String userAdd(){
        return "user/add";
    }

    @RequestMapping(value = "/userAdd",method = RequestMethod.POST)
    public String userAdd(User user){
        userServiceImpl.add(user);
        return "user/add";
    }

    @RequestMapping(value = "/TestPath")
    public String TestPath(){
        IUtil util=new Util();
        System.out.println(util.getProjectAbsolutePath());
        System.out.println(util.getJavaAbsolutePath());
        System.out.println(util.getWebAbsolutePath());
        return "error/404";
    }
}
