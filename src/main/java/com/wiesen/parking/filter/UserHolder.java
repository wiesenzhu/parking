package com.wiesen.parking.filter;

import com.wiesen.parking.vo.UserVO;

/**
 * @Description
 * @auther wiesen
 * @create 2019-04-14 11:40
 */
public class UserHolder {

    private static final ThreadLocal<UserVO> userHolder = new ThreadLocal<>();

    public static void add(UserVO userVO) {
        userHolder.set(userVO);
    }

    public static UserVO gerCurrentUser() {
        return userHolder.get();
    }

    public static void remove() {
        userHolder.remove();
    }

}
