package com.wiesen.parking.controller;

import com.wiesen.parking.constrants.SysConstrants;
import com.wiesen.parking.service.UserService;
import com.wiesen.parking.vo.LoginVO;
import com.wiesen.parking.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public String login(Model model) {
        // 记住用户名/密码等


        return "user/login";
    }


    @RequestMapping(method = RequestMethod.POST, value = "doLogin")
    @ResponseBody
    public Response doLogin(@Validated LoginVO loginVO, HttpServletRequest request) {
//        System.out.println(loginVO.getUsername());
        System.out.println(loginVO.getPassword());
        Long userId = userService.validLoginInfo(loginVO);
        if (null != userId) {
            // 登录成功
            HttpSession session = request.getSession();
            session.setAttribute(SysConstrants.SESSION_KEY, userId);
            session.setMaxInactiveInterval(SysConstrants.LOGIN_EXPIRE_TIME); // 单位: 秒
            return Response.success();
        } else {
            // 登录失败
            return Response.fail(Response.FAIL_CODE, "用户信息错误");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "doRegister")
    @ResponseBody
    public Response doRegister(@Validated LoginVO loginVO) {
//        System.out.println(loginVO.getUsername());
        System.out.println(loginVO.getPassword());

        return null;
    }

    public static void main(String[] asdf) {

        int i = Integer.MAX_VALUE;

    }
}
