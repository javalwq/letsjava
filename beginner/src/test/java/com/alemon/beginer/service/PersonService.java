package com.alemon.beginer.service;

import com.alemon.beginer.pojo.Person;
import com.alemon.beginer.pojo.annotation.Monitor;

public class PersonService implements LifeCycle<Person>{

	@Monitor("test")
	public void start(Person p) {
		System.out.println("start");
		System.out.println("current person is :" +  p.toString());
		
	}
	
	public void growup() {
		System.out.println("growup");
		
	}

	public void study() {
		System.out.println("study");
		
	}

	public void end() {
		System.out.println("end");
		
	}
	
}
