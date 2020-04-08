package studentenrolement;

public class Student {

	private String name;
	private String studentNumber;
	private String enrolledCourse = null;
	
	public Student(String name, String studentNumber) {
		super();
		this.name = name;
		this.studentNumber = studentNumber;
	}
	
	// format Book details to a String (useful for printing!)
	public String toString() {
		return String.format("Student Name: %s\nSutdent ID: %s\n", this.name, this.studentNumber);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the studentNumber
	 */
	public String getStudentNumber() {
		return studentNumber;
	}

	/**
	 * @param studentNumber the studentNumber to set
	 */
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	/**
	 * @return the enrolledCourse
	 */
	public String getEnrolledCourse() {
		return enrolledCourse;
	}

	/**
	 * @param enrolledCourse the enrolledCourse to set
	 */
	public void setEnrolledCourse(String enrolledCourse) {
		this.enrolledCourse = enrolledCourse;
	}

}
