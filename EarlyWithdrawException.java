public class EarlyWithdrawException extends Exception{
	public EarlyWithdrawException(){
		super("ERROR. Attempt of early withdrawal will incur penalties");	
	}
}
