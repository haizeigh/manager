package com.group5.manager.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * @author yl
 * @date 2020-06-19
 */
public class IdUtil {



    /**
     * 获取当前时间的时间戳
     * @return
     * */
    public static String getTimeInMillis() {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        return timeInMillis+"";
    }
    /**
     * 获取位数为7位的随机数
     * @return
     * */
    public static String getRandom() {
        Random random = new Random();
        int nextInt = random.nextInt(9000000);
        nextInt=nextInt+1000000;
        String str=nextInt+"";
        return str;
    }

    /**
     * 输入日期格式，返回格式内的内容，输入格式以-分隔
     * @param dateFormat
     * @return
     **/
    public static String getTimeYearMonthDay(String dateFormat) {
        return new SimpleDateFormat(dateFormat).format(new Date());
    }

    /**
     * 获得21位的主键值，主键值的格式是14位的当前时间加7位的随机数
     * @return
     **/
    public static String getDatePrimaryKey() {
        return getTimeYearMonthDay("yyyyMMddHHmmss")+getRandom();
    }

}
