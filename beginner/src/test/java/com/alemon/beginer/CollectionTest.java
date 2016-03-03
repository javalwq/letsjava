package com.alemon.beginer;

import com.alemon.beginer.pojo.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 集合测试
 * Created by liuwenqiang on 16/3/3.
 */
public class CollectionTest {

    /**
     * List list = new ArrayList();
     * 默认的容量为多少,
     * 如何扩容
     */
    @Test
    public void testList() {
        List list = new ArrayList();
        for(int i=0;i<32;i++) {
            list.add(i); // 进行几次扩容?
        }
    }

    /**
     * Map map = new HashMap();
     * 1. 初始容量多少
     * 2.如何扩容 rehash
     * 3. 存60个元素,初始容量应该设置多少
     */
    @Test
    public void testMap() {

    }

    /**
     *
     * 有3个person实例,按照名称相同的去重
     */
    @Test
    public void testSet() {
        List<Person> persons = new ArrayList<Person>(3);
        Person p1 = new Person();
        p1.setName("lew");
        Person p2 = new Person();
        p1.setName("alemon");
        Person p3 = new Person();
        p1.setName("alemon");
        // todo 打印名称非重复的的person实例
    }
}
