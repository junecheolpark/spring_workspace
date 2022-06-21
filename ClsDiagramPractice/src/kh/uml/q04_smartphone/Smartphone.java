package kh.uml.q04_smartphone;

public class Smartphone implements Camera,Telephone,Calculator,MultiMedia{

	public void takePicture() {
		System.out.println("찰칵");
	}
	public void call() {
		System.out.println("전화");
	}
	public void sms() {
		System.out.println("문자");
	}
	public void calcculate() {
		System.out.println("머야?");
	}
	public void youtube() {
		System.out.println("유튜브");
	}
	public void movie(){
		System.out.println("무비");
	}
	
	public void music(){
		System.out.println("노래");
	}
}
