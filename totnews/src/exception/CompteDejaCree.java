package exception;

public class CompteDejaCree extends Exception {

	String message;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CompteDejaCree() {
		// TODO Auto-generated constructor stub
		message = "Un compte avec ce pseudonyme LDAP a déjà été créé.";
	}
	
}
