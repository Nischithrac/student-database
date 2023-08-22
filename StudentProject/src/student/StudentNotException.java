package student;

public class StudentNotException  extends Exception{
	private String message;

	public StudentNotException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {

		return message;
	}


}
