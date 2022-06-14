package com.kh.intro;

public class BeanFactory {
	public Laptop getBean(String name){
		if(name.equals("lg")) {//lg인스턴스반환
			return new LgLaptop();
		}else if(name.equals("samsung")) {//samsung인스턴스반환
			return new SamsungLaptop();
		}
		return null;
	}
	
}
