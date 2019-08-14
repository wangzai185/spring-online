package com.xqtc.web.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Test.class
 *
 * @author suntf
 * @date 2019/08/08
 */
public class Test {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH/mm/ss");
    public static void main(String[] args) {
        Date date = new Date();
        String format = sdf.format(date);
        System.out.println(format);
    }
}
