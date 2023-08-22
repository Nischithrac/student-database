package student;

public class InvaildChoicException extends Exception {
	private String message;
	InvaildChoicException(String message){
		this.message=message;
	}
	@Override
	public String getMessage() {
		return message;
	}
}
