package excexoes;

public class NaoEhPoupanca extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NaoEhPoupanca(int n) {
		super("A conta de n�mero " + n + " N�o � poupan�a ");
	}
}
