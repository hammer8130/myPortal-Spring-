package himedia.myportal.exceptions;


//	RuntimeException 보다 구체적인 예외
public class MainControllerException extends RuntimeException {
	
	private static final long serialVersionUID = -1333170868551418713L;
	public MainControllerException() {
		super("mainControllerException occurs !");
	}
	public MainControllerException(String message) {
		super(message);
	}
	
}
