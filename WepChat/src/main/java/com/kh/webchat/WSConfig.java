package com.kh.webchat;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

public class WSConfig extends Configurator{
	// modifyHandskake : 서버와 endpoint가 핸드쉐이킹하는 과정에 개입하여 원하는 작업을 수행할 수 있게 해주는 메서드
	// 핸드쉐이킹 과정에 자동으로 실행됨
	@Override
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
		// ServerEndPointConfig : 서버의 endpoint에 전달하고 싶은 데이터가 있다면 이 객체를 활용하여 값을 담아 줄 수 있음
		// httpsession안에 있는 값을 꺼내기 위해 httpsession 먼저 꺼내기.
		HttpSession session = (HttpSession)request.getHttpSession();
		// nickname이라는 key값으로 사용자의 닉네임을 셋팅해줌.
		sec.getUserProperties().put("nickname", session.getAttribute("nickname"));
		super.modifyHandshake(sec, request, response);
	}
}
