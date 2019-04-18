package com.wiesen.parking.controller;

import com.wiesen.parking.filter.UserHolder;
import com.wiesen.parking.service.RecordService;
import com.wiesen.parking.vo.RecordAddVO;
import com.wiesen.parking.vo.Response;
import com.wiesen.parking.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("record")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @RequestMapping("/add")
    public String add() {
        return "record/add";
    }

    @RequestMapping("/doAdd")
    @ResponseBody
    public Response doAdd(@Validated RecordAddVO vo) {
        UserVO userVO = UserHolder.gerCurrentUser();
        recordService.add(vo, userVO);
        return Response.success();
    }

    @RequestMapping("list")
    public String list(String val, Model model) {
        String trimed = StringUtils.trimWhitespace(val);
        model.addAttribute("list", recordService.list(trimed, UserHolder.gerCurrentUser()));
        return "record/list";
    }

    public static void main(String[] asf) {
        String s = StringUtils.trimWhitespace("  as  adf  ");
        String s1 = StringUtils.trimAllWhitespace("  as  adf  ");
        System.out.println("111" + s + "222");
        System.out.println("111" + s1 + "222");
    }


}
