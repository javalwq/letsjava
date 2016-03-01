package com.alemon.beginer.service;


public interface LifeCycle<T> {
	void start(T p);
	void growup();
	void study();
	void end();
}
