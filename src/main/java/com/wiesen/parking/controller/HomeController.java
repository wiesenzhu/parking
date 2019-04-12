package com.wiesen.parking.controller;

import com.wiesen.parking.vo.UserVO;
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

    @RequestMapping("index")
    public String index(Model model) {
        UserVO userVO = new UserVO();
        userVO.setCommunityName("樱花府第");
        userVO.setRealName("祝西华");
        model.addAttribute("user", userVO);
        return "index";
    }

}
