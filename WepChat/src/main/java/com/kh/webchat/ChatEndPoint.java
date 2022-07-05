package com.kh.webchat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/chat")
public class ChatEndPoint {
	// ws 의 Session은 HttpSession 과 다름.
	private static List<Session> clients = Collections.synchronizedList(new ArrayList<>());
	
	// 클라이언트가 웹소켓 통신에 대한 요청을 처음 보낸 때를 캐치하는 메서드)처음 접속한 순간 = 웹
	// 클라이언트의 웹소켓 첫 접속이 이뤄진 순간 자동으로 실행되는 메서드
	@OnOpen
	//지금 접속한 클라이언트의 session 값을 매개변수로 받음.
	public void onOpen(Session session) { 
		System.out.println("접속됨");
		clients.add(session);//멤버필드list에 새로 접속한 클라이언트 새션 추가
		for(Session client : clients) {
			System.out.println(client);
		}
	}
	
	//클라이언트가 웹소켓을 통해 서버와 연결되어있는 도안 send 라는 함수를 사용했을때 실행되는 메서드
	@OnMessage
	public void onMessage(Session session, String message) {
		System.out.println("message:" + message);
		try {
			// 여러명의 메세지를 주고받는상황
			//(clients 리스트를 참조해 for문을 돌리는 도중에 접속이 늫기는 경우)
			// concurrentModificationException 발생할 수있음(동시성 오류)
			
			// 만약 아래의 for문을 수행하는 도중 client를 참조화는 다른 작업이 생긴다면
			//이 for문을 모두 수행할때까지 다른 작업은 대기하게끔 만드는 작업.
			synchronized (clients){
				for(Session client : clients) {
					if(session != client) {//나에게는 메세지 다시보내지 않음
						//접속된 모든 클라이언트들에게 메세지 보내기
						// getBasicRemote() 앤드포인트+클라이언트 사이의 스트림 주소값을 아낼수 있는 메서드
						client.getBasicRemote().sendText(message);	
					}
			}
			
					
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@OnClose // 연결이 끊어지면 이 어노테이션 붙은 메서드가 실행됨
	public void onClose(Session session) {
		clients.remove(session);
		System.out.println("클라이언트의 접속이 끊어졌슴");
		
	}
}
