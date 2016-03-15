package com.alemon.beginer;

import org.junit.Test;

import java.util.Arrays;
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
    	String s = "abcdf";
    	String s2 = new String("abcdf");
    	System.out.println(s.getBytes().length);//实际长度5个字符
    	String s1 = "abcdf" + "f";
    	System.out.println(("abcdf" + "f").getBytes().length);//实际长度6个字符
    	System.out.println(s1.indexOf("abd"));//没有返回-1
    	System.out.println(s.substring(1));//bcdf
    	System.out.println(s.substring(2, 4));//cd (len>=2&&len<4 )
    	System.out.println(s == s2);
    	
    	//String 没有reverse方法
    }

    /**
     * StringBuffer s = new StringBuffer();
     * 1.默认分配多少字节 16*2=32Byte
     * 2. append执行原理,达到最大存储空间后如何扩容? 原容量2倍+2 与  所需容量中两者较大值作为新容量
     * 3.delete(int start, int end),是如何执行,伪码描述
     * 4.indexof("abc") 方法是如何执行的?伪码描述
     */
    @Test
    public void testStringBuffer() {
    	char[] cc = new char[16];
    	System.out.println(cc.length);//16
    	StringBuffer s = new StringBuffer();
    	s.append("abc");
    	//扩容前
    	System.out.println(s.capacity());//16 characters
    	System.out.println(s.length());//3
    	//扩容后
    	s.append("ajdlfdklfskldklsdklsqwer");//24
    	System.out.println(s.capacity());//34 characters
    	System.out.println(s.length());//27
    	//继续扩容
    	s.append("asjdfsldfaasjdfsldfaasjdfsldfaasjdfsldfadfsldfa");//47
    	System.out.println(s.capacity());//74 characters (2*34+2=70)
    	System.out.println(s.length());//74
    	
    	//System.out.println(s.toString().getBytes().length);//16
    	Character c = 'A';
    	System.out.println(c.SIZE);//16 bit
    	
    	StringBuffer s1 = new StringBuffer("abc");
    	System.out.println(s1.insert(2, "def"));//abdefc
    	
    	StringBuffer s2 =  new StringBuffer("abcdefghi");
    	System.out.println(s2.delete(2, 5));//abfghi
    	
    	StringBuffer s3 = new StringBuffer("abcdabc");
    	System.out.println(s3.indexOf("cd", 2));//2  找不到返回-1
    	
    	StringBuffer s4 = new StringBuffer("i am a girl");
    	System.out.println(s4.reverse());
    }

    /**
     * StringBuffer s = new StringBuffer();
     * 1.默认分配多少字节 16*2
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
            str = str + "almon"; // 用多少字节：5*2,创建了几次对象.创建了一个StringBuilder对象
            stringBuilder.append("almon"); // 16*2用了多少字节：16*2,进行几次扩容:不扩容

            // StringBuilder sb = new StringBuilder();
            // sb.append(str);
            // sb.append("almon")
            // sb.tostring
            str = str + "almon"; // 用多少字节,创建了几次对象.
//            stringBuilder.append("almon"); // 用了多少字节,进行几次扩容
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
