public abstract class Account{
	protected Currency totalBalance;
	
	/* Adds a certain amount of cents to the total account  balance */
	public Account(Currency initialAmount){
		this.totalBalance = new Currency(initialAmount.cents);
	}	

	/* Abstract methods to be defined by subclasses  */
	public abstract void withdraw(Currency money) throws Exception;
	public abstract void deposit(Currency money) throws Exception;
	public abstract int getBalance();
}
