package com.alemon.beginer;

import org.junit.Test;

import java.util.Random;

/**
 *
 * Created by liuwenqiang on 16/3/3.
 */
public class StringTest {

    /**
     * String类的存储结构 工具javap -c 'class' 查看字节码
     * 参考 https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-6.html#jvms-6.5.invokespecial
     * 1. string = 'abcdf'; 占用多少字节
     * 2. string = 'abcdf' + 'f';占用多少字节?
     */
    @Test
    public void testStringMem() {

    }

    /**
     * StringBuffer s = new StringBuffer();
     * 1.默认分配多少字节
     * 2. append执行原理,达到最大存储空间后如何扩容?
     * 3.delete(int start, int end),是如何执行,伪码描述
     * 4.indexof("abc") 方法是如何执行的?伪码描述
     */
    @Test
    public void testStringBuffer() {

    }

    /**
     * StringBuffer s = new StringBuffer();
     * 1.默认分配多少字节
     * 2. append执行原理,达到最大存储空间后如何扩容?
     */
    @Test
    public void testStringBuilder() {

    }

    @Test
    public void testAll() {
        int i = 0;
        String str = "";
        StringBuilder stringBuilder = new StringBuilder();
        while(i<50) {
            i++;
            str = str + "almon"; // 用多少字节,创建了几次对象.
            stringBuilder.append("almon"); // 用了多少字节,进行几次扩容
        }
    }

    /*@Test
    public void testMemleak() {
        int a = 0;
        String str = "";
        while(true) {
            a++;
            str = "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890" + new Random().nextInt(); // 100字节
            // 会内存溢出吗?
        }
    }*/
}
