package com.hy;

import com.hy.plus.factory.abstracts.AbstractFactory;
import com.hy.plus.factory.abstracts.FastFactory;
import com.hy.plus.factory.abstracts.HtmlDocument;
import com.hy.plus.factory.abstracts.WordDocument;
import com.hy.plus.factory.method.NumberFactory;
import com.hy.plus.util.SpringContextHolder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Paths;

/***
 * <p>
 *  设计模式测试类
 * </p>
 * @author hy
 * @date 2020/11/2 16:51
 **/
@SpringBootTest
public class FactoryTest {

    /***
     * 工厂方法
     */
    @Test
    public void factoryMethodTest(){
        NumberFactory numberFactory = NumberFactory.getFactory();
        Number number = numberFactory.parse("99.22355");
        System.out.println("---:" + number);
    }

















    /***
     * 抽象方法
     */
    @Test
    public void factoryAbstractTest() throws IOException {
        // 创建AbstractFactory，实际类型是FastFactory:
        AbstractFactory factory = new FastFactory();
        // 生成Html文档:
        HtmlDocument html = factory.createHtml("#Hello\nHello, world!");
        html.save(Paths.get(".", "fast.html"));
        // 生成Word文档:
        WordDocument word = factory.createWord("#Hello\nHello, world!");
        word.save(Paths.get(".", "fast.doc"));
    }

}
