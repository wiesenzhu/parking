package com.wiesen.parking.controller;

import com.wiesen.parking.vo.LoginVO;
import com.wiesen.parking.vo.Response;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("login")
    public String login(Model model) {
        // 记住用户名/密码等
        return "user/login";
    }



    @RequestMapping(method = RequestMethod.POST, value = "doLogin")
    @ResponseBody
    public Response doLogin(@Validated LoginVO loginVO) {
        System.out.println(loginVO.getUsername());
        System.out.println(loginVO.getPassword());


        return null;
    }

    @RequestMapping(method = RequestMethod.POST, value = "doRegister")
    @ResponseBody
    public Response doRegister(@Validated LoginVO loginVO) {
        System.out.println(loginVO.getUsername());
        System.out.println(loginVO.getPassword());

        return null;
    }
}
