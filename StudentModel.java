package assign2;
public class StudentModel {
	
	private int id;
	private String name;
	private String department;
	private double math_mark;
	private double science_mark;
	private double english_mark;
	
	public int getID() {
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public double getMathMark() {
		return math_mark;
	}
	
	public void setMathMark(double math_mark) {
		this.math_mark = math_mark;
	}
	
	public double getScienceMark() {
		return science_mark;
	}
	
	public void setScienceMark(double  science_mark) {
		this.science_mark = science_mark;
	}
	
	public double getEnglishMark() {
		return english_mark;
	}
	
	public void setEnglishMark(double english_mark) {
		this.english_mark = english_mark;
	}

}
