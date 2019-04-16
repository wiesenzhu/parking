package com.wiesen.parking.controller;

import com.wiesen.parking.filter.UserHolder;
import com.wiesen.parking.service.UserService;
import com.wiesen.parking.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @auther wiesen
 * @create 2019-04-11 17:29
 */
@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("index")
    public String index(Model model) throws Exception {
        UserVO userVO = UserHolder.gerCurrentUser();
        System.out.println(userVO);
        model.addAttribute("user", userVO);
        if (1 == 1) {
            throw new Exception("asdfsaddf");
        }
        return "index";
    }

}
