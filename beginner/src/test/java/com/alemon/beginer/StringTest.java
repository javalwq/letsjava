package com.alemon.beginer;

import org.junit.Test;

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
//        StringBuilder stringBuilder = new StringBuilder();
        while(i<50) {
            i++;
            // StringBuilder sb = new StringBuilder();
            // sb.append(str);
            // sb.append("almon")
            // sb.tostring
            str = str + "almon"; // 用多少字节,创建了几次对象.
//            stringBuilder.append("almon"); // 用了多少字节,进行几次扩容
        }

        StringBuilder stringBuilder = new StringBuilder(1002); //501
        while(i<50) {
            i++;
            stringBuilder.append("almon");
        }

        System.out.println("");

        String str1 = new String("lew");
        String str2 = "almon";
        String str3 = str2 + str1;
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

    @Test
    public void testEqual() {
        String str1 = "almon";
        String str2 = "a";
        String str3 = "lmon";
        String str4 = "a" + "lmon";
        String str5 = str2 + str3;
        System.out.print(str5 == str4);
//        String str2 = "almon";
//        System.out.println(str1 == str2);
//        System.out.println("b" == "a");
//        System.out.println("a".equals("a"));
       //String str1 = new String("a");
//        StringBuilder sb = new StringBuilder("a");
          //String str2 = new String(("a"));
         // String str3 = "bb" + str1;
//        System.out.println(str1 == str2);
////        System.out.println(str1.equals(str2));
    }
}
