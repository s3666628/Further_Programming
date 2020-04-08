package studentenrolement;

public class Course {

	private String courseName;
	private String courseID;
	private int numberEnrolled;
	// array for storing students
	private Student students [] = new Student[4];
	
	public Course(String courseName, String courseID) {
		super();
		this.courseName = courseName;
		this.courseID = courseID;
		this.numberEnrolled = 0;
	}
	// format Book details to a String (useful for printing!)
	public String toString() {
		return String.format("Course Name: %s\nCourse ID: %s\n", this.courseName, this.courseID);
	}
	public void enrollStudent(Student student, int location, String courseID) {
		students[location] = student;
		student.setEnrolledCourse(courseID);
		System.out.println("Enrolling student on course");
		System.out.print(student.toString());
		
	}
	
	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/**
	 * @return the numberEnrolled
	 */
	public int getNumberEnrolled() {
		return numberEnrolled;
	}
	/**
	 * @param numberEnrolled the numberEnrolled to set
	 */
	public void setNumberEnrolled(int numberEnrolled) {
		this.numberEnrolled = numberEnrolled;
	}
}
