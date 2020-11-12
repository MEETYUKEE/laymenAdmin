package com.hy;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/***
 * <p>
 *  HuTool 工具学习类
 * </p>
 * @author hy
 * @date 2020/10/23 17:08
 **/
@SpringBootTest
public class HuToolTest {


    @Test
    public void test() {
        // Convert 中还有很多方法，可使用
        String s = "100";
        Integer integer = Convert.toInt(s);
        Integer toInt = Convert.toInt(s, 10);
        Integer integer1 = Convert.toInt("", 10);
        System.out.println("---");
    }

    @Test
    public void test2() {
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = "2020年09月29日";
        Date date = Convert.toDate(s);
        System.out.println("---:" + sm.format(date));

        String s1 = "2020-09-29";
        Date date1 = Convert.toDate(s1);
        System.out.println("---:" + sm.format(date1));

        String s2 = "2020-09-29 23:59:59";
        Date date2 = Convert.toDate(s2);
        System.out.println("---:" + sm.format(date2));

        String s3 = "2020-9-29";
        Date date3 = Convert.toDate(s3);
        System.out.println("---:" + sm.format(date3));
    }

    @Test
    public void test3() {
        // Convert 中还有很多方法，可使用
        String s = "愿你在我看不到的地方安然无恙";
        String toUnicode = Convert.strToUnicode(s);
        System.out.println("---" + toUnicode);
        System.out.println("---" + Convert.unicodeToStr(toUnicode));
    }

    @Test
    public void test4() {
        // Convert 中还有很多方法，可使用
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println("---" + sm.format(DateUtil.date()));
    }

}
