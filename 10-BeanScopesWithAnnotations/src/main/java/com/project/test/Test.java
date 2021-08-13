package com.project.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.model.Associate;
import com.project.model.Member;

public class Test {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext configurableApplicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		
		Member singletonMember1 = configurableApplicationContext.getBean("member", Member.class);
		Member singletonMember2 = configurableApplicationContext.getBean("member", Member.class);
		
		Associate prototypeAssociate1 = configurableApplicationContext.getBean("associate", Associate.class);
		Associate prototypeAssociate2 = configurableApplicationContext.getBean("associate", Associate.class);
		
		System.out.println("Is singletonMember1 equals singletonMember2: " + (singletonMember1 == singletonMember2));
		
		System.out.println("Reference of singletonMember1: " + singletonMember1);
		System.out.println("Reference of singletonMember2: " + singletonMember2);
		
		System.out.println("Is prototypeAssociate1 equals prototypeAssociate2: " + (prototypeAssociate1 == prototypeAssociate2));
		
		System.out.println("Reference of prototypeMember1: " + prototypeAssociate1);
		System.out.println("Reference of prototypeMember2: " + prototypeAssociate2);
		
		configurableApplicationContext.close();
		
	}

}
