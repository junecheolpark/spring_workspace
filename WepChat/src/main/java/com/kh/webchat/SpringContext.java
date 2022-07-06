package com.kh.webchat;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContext implements ApplicationContextAware{
/* 스프링 컨테이너가 가동이 되면서 ApplicationContextAware 를 구현한 SpringContext 인스턴스가 생성이 되고
 * 이 클래스의 인스턴스가 생성이 될때 자동적으로 setApplicationContext 메서드가 호출
 * ->context 멤버필드에 지금 생성된 스프링 컨테이너의 주소값을 셋팅하는 작업을 해줌
 * -> ChatEndPoint 에서 getApplicationContext 메서드를 통해 스프링 컨테이너의 주소값을 가져다 쓸 수 있음. */
	private static ApplicationContext context;
	@Override
	public void setApplicationContext(ApplicationContext context) {
		SpringContext.context = context;
	}
	public static ApplicationContext getApplicationContext() {
		return context;
	}
}
