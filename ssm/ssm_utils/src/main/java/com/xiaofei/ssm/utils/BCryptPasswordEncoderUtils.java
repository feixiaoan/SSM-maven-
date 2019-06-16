package com.xiaofei.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * <Description> <br>
 * 对用户密码进行加密
 * @author 小飞<br>
 * @version 1.0<br>
 * @createDate 2019/06/06<br>
 * @see com.xiaofei.ssm.utils <br>
 */
public class BCryptPasswordEncoderUtils {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    /**
     * 对用户密码进行加密
     * @param password
     * @return 返回加密后的密码
     */
    public static String encodePassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }


    public static void main(String[] args) {
        String password ="admin";
        String s = encodePassword(password);
        System.out.println(s);
    }
}
