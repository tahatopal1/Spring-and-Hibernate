package com.project.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.model.Member;

public class Test {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext configurableApplicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		
		Member singletonMember1 = configurableApplicationContext.getBean("singletonMemberBean", Member.class);
		Member singletonMember2 = configurableApplicationContext.getBean("singletonMemberBean", Member.class);
		
		Member prototypeMember1 = configurableApplicationContext.getBean("prototypeMemberBean", Member.class);
		Member prototypeMember2 = configurableApplicationContext.getBean("prototypeMemberBean", Member.class);
		
		System.out.println("Is singletonMember1 equals singletonMember2: " + (singletonMember1 == singletonMember2));
		
		System.out.println("Reference of singletonMember1: " + singletonMember1);
		System.out.println("Reference of singletonMember2: " + singletonMember2);
		
		System.out.println("Is prototypeMember1 equals prototypeMember2: " + (prototypeMember1 == prototypeMember2));
		
		System.out.println("Reference of prototypeMember1: " + prototypeMember1);
		System.out.println("Reference of prototypeMember2: " + prototypeMember2);
		
		configurableApplicationContext.close();
		
	}

}
