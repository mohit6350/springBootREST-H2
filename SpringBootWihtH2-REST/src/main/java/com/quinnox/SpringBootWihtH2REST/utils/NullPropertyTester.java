package com.quinnox.SpringBootWihtH2REST.utils;

import com.quinnox.SpringBootWihtH2REST.entity.Student;

public class NullPropertyTester {
	public static void main(String[] args) throws Exception {
		Student s1 = new Student();
		s1.setAge(24);
		s1.setName("john snow");
		s1.setBranch("CSE");
		s1.setRoll(123);
		System.err.println(s1);
		Student s2 = new Student();
		s2.setAge(25);
		s2.setRoll(123);
		System.err.println(s2);
		NullAwareBeanUtilsBean nullUtils = new NullAwareBeanUtilsBean();
		nullUtils.copyProperties(s1, s2);
		System.out.println(s1);
	}
}
