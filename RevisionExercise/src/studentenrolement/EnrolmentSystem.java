package studentenrolement;

public class EnrolmentSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student phil = new Student ("Phil", "s3666628");
		Student paul = new Student ("Paul", "s7446328");
		Course further = new Course ("Further Programming", "CPT457");
		

//		System.out.print(phil.toString());
//		System.out.print(further.toString());
//		System.out.print(paul.toString());
		further.enrollStudent(paul, 0, "CPT457");
		further.enrollStudent(phil, 1, "CPT457");
		System.out.print(paul.getEnrolledCourse());
		System.out.print(phil.getEnrolledCourse());
		
	}


}
