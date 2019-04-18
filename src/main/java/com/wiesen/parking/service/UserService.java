package com.wiesen.parking.service;

import com.wiesen.parking.vo.LoginVO;
import com.wiesen.parking.vo.RegisterVO;
import com.wiesen.parking.vo.UserVO;

public interface UserService {

    UserVO validLoginInfo(LoginVO vo);

    void mUserRegister(RegisterVO vo);

    UserVO getUserInfo(Long userId);
}
