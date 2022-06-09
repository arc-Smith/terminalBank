public class WithdrawException extends Exception{
	public WithdrawException(Currency amount){
		super("ERROR. Insufficient funds for withdrawal of $"+amount.cents);
	}
}

