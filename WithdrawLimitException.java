public class WithdrawLimitException extends Exception{
	public WithdrawLimitException(){
		super("ERROR. The withdraw limit initially set to 6 for the current statement cycle has reached 0");
	}
}

