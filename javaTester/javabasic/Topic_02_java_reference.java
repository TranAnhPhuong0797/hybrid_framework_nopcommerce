package javabasic;

public class Topic_02_java_reference {
	public String studenName;
	
	public String getStudenName() {
		return studenName;
	}
	
	public void setStudenName(String studenName) {
		this.studenName = studenName;
	}
	
	private void showStudenName() {
		System.out.println("Studen Name: " + studenName);
	}
	
	public static void main(String[] args) {
		Topic_02_java_reference firstStudent = new Topic_02_java_reference();
		Topic_02_java_reference secondStudent = new Topic_02_java_reference();
		
		firstStudent.setStudenName("Nguyen Van A");
		
		secondStudent.setStudenName("Tran Thi B");
		
		firstStudent.showStudenName();
		secondStudent.showStudenName();
		
		firstStudent = secondStudent;
		
		firstStudent.showStudenName();
		secondStudent.showStudenName();
		
		secondStudent.setStudenName("Lam Anh H");
		
		firstStudent.showStudenName();
		secondStudent.showStudenName();
	}

}
