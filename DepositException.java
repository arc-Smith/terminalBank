public class DepositException extends Exception{
	public DepositException(){
		super("ERROR. The CD account type does not allow for deposits following the initial deposit into the account");
	}
}
