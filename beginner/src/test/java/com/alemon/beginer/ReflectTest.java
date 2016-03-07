package com.alemon.beginer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

import org.junit.Test;

import com.alemon.beginer.pojo.Person;
import com.alemon.beginer.pojo.annotation.Monitor;
import com.alemon.beginer.service.LifeCycle;
import com.alemon.beginer.service.PersonService;

public class ReflectTest {
	/**
	 * 1、获取Person类的所有属性信息
	 * 2、改变一个实例的值。
	 * Person p = new Person();
	 * p.setName("lew");
	 * 将变量p的值通过反射方式改为alemon
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	@Test
	public void testField() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Class clazz = Person.class;
		Class clazz1 = Class.forName("com.alemon.beginer.pojo.Person");
		Class clazz2 = new Person().getClass();
		System.out.println("类名：" + clazz.getName());
		System.out.println("包名：" + clazz.getPackage().getName());
		//1.Person的所有属性信息
		Field[] fields0 = clazz.getFields();//取得public属性
		Field[] fields = clazz.getDeclaredFields();//所有声明的属性
		System.out.println("属性名：");
		for(int i =0;i<fields.length; i++){
			System.out.println(fields[i].getName() + "--" + Modifier.toString(fields[i].getModifiers()));
		}
		//2.改变实例的值
		Person p = (Person) clazz.newInstance();
		p.setName("lew");
		System.out.println("name init = " + p.getName());
		Field nameField = clazz.getDeclaredField("name");
		nameField.setAccessible(true);//private属性需要设置
		nameField.set(p, "alemon");
		nameField.setAccessible(false);//再改回原来的可访问性
		System.out.println("name change = " + p.getName());
	}
	
	/**
	 * 获取PersionService的所有方法，同过反射调用start方法
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	@Test
	public void testMethod() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Person p = new Person();
		p.setName("alemon");
		Class clazz = PersonService.class;
		Method method = clazz.getDeclaredMethod("start", Person.class);
		Method mm = clazz.getDeclaredMethod("end", null);
		mm.invoke(clazz.newInstance(), null);
		method.invoke(clazz.newInstance(), p);
	}
	
	/**
	 * 获取personservice中start方法的annotation
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	@Test
	public void testAnnotation() throws NoSuchMethodException, SecurityException {
		Class clazz = PersonService.class;
		Method method = clazz.getDeclaredMethod("start", Person.class);
		Annotation[] anos = method.getAnnotations();
		for(Annotation ano: anos){
			System.out.println(ano.toString());
			System.out.println(ano.annotationType());
		}
	}
	
	@Test
	public void testType() {
		
	}
	
	/**
	 * 对lifecycle接口生成代理类，当有Monitor注解的时候，打印monitoring
	 */
	@Test
	public void testProxy() {
		final Person p = new Person();
		p.setName("dogdog");
		final LifeCycle l = new PersonService();
		LifeCycle proxyl = (LifeCycle) Proxy.newProxyInstance(LifeCycle.class.getClassLoader(), l.getClass().getInterfaces(), new InvocationHandler(){

			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				
				Object o = method.invoke(l, args);
				Class[] params = new Class[args.length];
				for(int i = 0; i<args.length;i++){
					params[i] = args[i].getClass();
				}
				Method m = l.getClass().getDeclaredMethod(method.getName(), params);
				Annotation[] as= m.getAnnotations();
				System.out.println(as.length);
				for(Annotation a : as){
					if(a instanceof Monitor){
						System.out.println("monitoring");
					}
				}
				/*System.out.println(method.getName());
				System.out.println(args[0].toString());
				System.out.println(proxy.getClass().getName());
				System.out.println(String.valueOf(o));*/
				return o;
			}
			
		});
		proxyl.start(p);
		//proxyl.end();
	}
	
	
}
