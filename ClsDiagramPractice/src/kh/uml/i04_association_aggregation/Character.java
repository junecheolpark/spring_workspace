package kh.uml.i04_association_aggregation;
/* association(연관관계)
 * -> aggregation(집합연관)
 * : 멤버필드로 다른 클래스의 인스턴스를 참조하는 관계
 * 해당 클래스의 인스턴스가 생명을 다해도
 * 참조하고 있는 클래스의 인스턴스 생명주기가 영향을 받지 않는 관계
 * 즉 생명주기가 일치하지 않는 연관관계 -> 집합연관
 * 실선 + 속이 비어있는 마름모로 표현
 * */
public class Character {
	private Watch watch;
	private Glasses Glasses;
	public Character() {}
	public Character(Watch watch, kh.uml.i04_association_aggregation.Glasses glasses) {
		super();
		this.watch = watch;
		Glasses = glasses;
	}
	public Watch getWatch() {
		return watch;
	}
	public void setWatch(Watch watch) {
		this.watch = watch;
	}
	public Glasses getGlasses() {
		return Glasses;
	}
	public void setGlasses(Glasses glasses) {
		Glasses = glasses;
	}
	
	
}
