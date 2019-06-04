package com.xiaofei.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * <Description> <br>
 *  进行日期转换
 * @author 小飞<br>
 * @version 1.0<br>
 * @createDate 2019/05/31<br>
 * @see com.xiaofei.ssm.utils <br>
 */
public class DateUtils {
    /**
     * 把日期转换为字符串
     * @param date 传进来的日期
     * @param patt 转换的日期格式
     * @return 返回转换后的字符串日期
     */
    public static String DateToString(Date date,String patt) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patt);
        String format = simpleDateFormat.format(date);
        return format;
    }

    /**
     * 把字符串转换为日期
     * @param date 传入的字符日期
     * @param patt 转换的格式
     * @return 返回转换后的日期
     * @throws ParseException
     */
    public static Date StringTiDate(String date, String patt) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patt);
        Date parse = simpleDateFormat.parse(date);
        return parse;
    }
}
