package kh.uml.i05_association_composition;
/* association_composition (합성연관)
 * : 멤버필드로써 다른 클래스 인스턴스를 참조하는 관계
 * 다만 참조하는 클래스의 인스턴스와
 * 참조당하는 클래스의 인스턴스 생명주기가 동일한 관계
 * 실선 + 속이 차있는 마름모로 표현
 * */
public class Character {
	private Watch watch = new Watch();
	private Glasses glasses = new Glasses();

}
