package com.kh.intro;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Run {
	public static void main(String[] args) {
		// 우리회사가 samsung 계약
		// laptop 생산
//				SamsungLaptop samsung = new SamsungLaptop();
//				samsung.powerOn();
//				samsung.powerOff();
//				samsung.volumeUp();
//				samsung.volumeDown();
//				
//				//삼성이 아닌 lg랑 계약
//				//latop 생산
//				LgLaptop lg = new LgLaptop();
//				lg.powerOn();
//				lg.powerOff();
//				lg.volumeUp();
//				lg.volumeDown();

		// 다형성 : 부모 클래스 참조변수가 자식 클래스 인스턴스를 담을 수 있는 성질
//		Laptop laptop = new SamsungLaptop();
//		laptop.powerOn();
//		laptop.powerOff();
//		laptop.volumeUp();
//		laptop.volumeDown();

		//팩토리 패턴(factory):공장
		//인스턴스의 생성은 팩토리 클래스가 담당하고, 개발자인 우리는 어떤인스턴스를
		//생성할지에 대한 값만 넘겨서 인스턴스를 반환받는 형식
//		BeanFactory factory = new BeanFactory();
//		Laptop  laptop = factory.getBean("lg");
//		laptop.powerOn();
//		laptop.powerOff();
//		laptop.volumeUp();
//		laptop.volumeDown();
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		/*bean(인스턴스) 사용법
		 * DL (Dependency Lookup): t스프링 컨테이너에서 알아서 생성해준 인스턴스들을 가져다 사용하는 것
		 * */
		
		SamsungLaptop laptop1 = (SamsungLaptop)factory.getBean("samsung");
		System.out.println(laptop1.getPrice());
//		laptop1.powerOn();
//		laptop1.powerOff();
//		laptop1.volumeUp();
//		laptop1.volumeDown();
		Laptop laptop2 = (Laptop)factory.getBean("samsung");
	
	
		
		
	}

}
