package com.wiesen.parking.service;

import com.wiesen.parking.vo.LoginVO;
import com.wiesen.parking.vo.UserVO;

public interface UserService {

    Long validLoginInfo(LoginVO vo);

    UserVO getUserInfo(Long userId);
}
