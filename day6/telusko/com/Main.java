package telusko.com;

public class Main {

	public static void main(String[] args) {
		 Class<Employee> myClass = Employee.class;
	        JavaDeveloper annotation = myClass.getAnnotation(JavaDeveloper.class);
	        
	        if (annotation != null) {
	            int value = annotation.experience();
	            System.out.println("Experience value: " + value);
	        }
	}

}
