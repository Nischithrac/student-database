package student;

public class InvlidChoiceExcption  extends Exception{
private String message;
public InvlidChoiceExcption(String message) {
	
	this.message = message;
}
@Override
public String toString() {
	return message;
}
}
