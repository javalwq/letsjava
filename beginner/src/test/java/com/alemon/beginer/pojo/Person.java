package com.alemon.beginer.pojo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class Person {
	private Long id;
	private String name;
	private Integer age;
	private City city;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age
				+ ", city=" + city + "]";
	}
	/**
	 * 重写person的equals方法
	 */
	@Override
	public boolean equals(Object obj) {
		if(((Person)obj).getName().equals(getName())){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		//方法一：用反射使用hashmap的hash方法求hashcode
		Class c = HashMap.class;
		try {
			@SuppressWarnings("unchecked")
			Method m = c.getDeclaredMethod("hash", new Class[]{Object.class});
			m.setAccessible(true);
			return (Integer) m.invoke(c.newInstance(), getName());
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		//方法二：用String的hashCode方法
	/*	int result = getName().hashCode();  
	     return result;*/
	}
}
