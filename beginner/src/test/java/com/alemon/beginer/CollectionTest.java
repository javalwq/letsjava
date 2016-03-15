package com.alemon.beginer;

import com.alemon.beginer.pojo.Person;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 集合测试
 * Created by liuwenqiang on 16/3/3.
 */
public class CollectionTest {
	 static final int MAXIMUM_CAPACITY = 1 << 30;
    /**
     * List list = new ArrayList();
     * 默认的容量为多少, 10
     * 如何扩容
     * @throws SecurityException 
     * @throws NoSuchFieldException 
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     */
    @Test
    public void testList() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        ArrayList list = new ArrayList();
        System.out.println(this.getElementLength(list));//0
        list.add("a");//10第一次扩容
        System.out.println(this.getElementLength(list));
        list.add("b");
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("a");
        list.add("a");
        list.add("a");//第二次扩容
        System.out.println(this.getElementLength(list));//15
        list.add("b");
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("b");//第三次扩容
        System.out.println(this.getElementLength(list));//22
        System.out.println(list.size());//16
        
        for(int i=0;i<32;i++) {
            list.add(i); // 进行几次扩容?
            //扩容四次
            //第一次是list.add(0)--->10
            //第二次是list.add(10)--->15
            //第三次是list.add(15)--->22
            //第四次是list.add(22)--->33
        }
    }

    /**
     * Map map = new HashMap();
     * 1. 初始容量多少 (1<<4=16)
     * 2.如何扩容 rehash 当size到阀值threshold时，会扩容，容量变为原容量的两倍
     * 3. 存60个元素,初始容量应该设置多少（是要扩容次数少吗）128
     */
    @Test
    public void testMap() {
    	System.out.println(1<<30);
    	Map map = new HashMap();
    	map.put(null, 555);
    	map.put(null, 666);
    	System.out.println(map.put(null, 777));
    	
    	System.out.println(getInitialCapactity(80));
    	
    	//初始容量为16，扩容因子为0.75时，1~12个元素，当put第13个元素时就需要resize数组将容量扩充到32。
    	//重新计算阀值为32*0.75=24；当put第25个元素时，resize到64，重新计算阀值为64*0.75=48；当put第49个元素时，
    	//resize到128，重新计算阀值为128*0.75=96
    }
    private int getInitialCapactity(int number){
    	return number >= MAXIMUM_CAPACITY
                ? MAXIMUM_CAPACITY
                : (number > 1) ? Integer.highestOneBit((number - 1) << 1) : 1;
    }

    /**
     *
     * 有3个person实例,按照名称相同的去重
     * 重写person的equals和hashcode
     */
    @Test
    public void testSet() {
        List<Person> persons = new ArrayList<Person>(3);
        Person p1 = new Person();
        p1.setName("lew");
        Person p2 = new Person();
        p2.setName("alemon");
        Person p3 = new Person();
        p3.setName("alemon");
       /* System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p3.hashCode());*/
        // todo 打印名称非重复的的person实例
        HashSet<Person> h = new HashSet<Person>();
        h.add(p1);
        h.add(p2);
        h.add(p3);
        Iterator it = h.iterator();
        while(it.hasNext()){
        	System.out.println(it.next());
        }
    }
    
    /**
     * 取得ArrayList 的容量 即 elementData属性的length值
     * @param list
     * @return
     * @throws NoSuchFieldException
     * @throws SecurityException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
   private int getElementLength(List list) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
	   Class clazz = list.getClass();
       Field f = clazz.getDeclaredField("elementData");
       f.setAccessible(true);
       Object o = f.get(list);//从list对象中抽取elementData的值
       Object[] re = (Object[])o;
       return re.length;
   }
}
