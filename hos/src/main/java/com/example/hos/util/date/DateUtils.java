package com.example.hos.util.date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String formatDate(Date date) {
        // 定义输出的日期格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年M月d日");
//        System.out.println(formatter.format(date));
        // 格式化日期
        return formatter.format(date);
    }
    public static Date parseDate(String dateStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年M月d日");
        try {
            return formatter.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
