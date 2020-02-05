package com.basic.basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Test {

    public static void main(String[] args) throws ParseException {
        String a = " ";
        List<String> strings = Arrays.asList(a.trim().split(","));
        System.out.println(strings);

        System.out.println();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = sdf.parse("2020-02-03 12:12:12");
        boolean today = isToday(parse);
        System.out.println(today);

    }

    public static boolean isToday(Date inputJudgeDate) throws ParseException {
        boolean flag = false;
        //获取当前系统时间
        long longDate = System.currentTimeMillis();
        Date nowDate = new Date(longDate);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(nowDate);
        String subDate = format.substring(0, 10);
        //定义每天的24h时间范围
        String beginTime = subDate + " 00:00:00";
        String endTime = subDate + " 23:59:59";
        Date paseBeginTime = null;
        Date paseEndTime = null;
        paseBeginTime = dateFormat.parse(beginTime);
        paseEndTime = dateFormat.parse(endTime);

        if (inputJudgeDate.after(paseBeginTime) && inputJudgeDate.before(paseEndTime)) {
            flag = true;
        }
        return flag;
    }

}
