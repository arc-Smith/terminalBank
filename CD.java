public class CD extends Account{
	private double rate;
	private boolean earlyPenalty = true; // Will be changed to false in 2 years			
	
        public CD(Currency initialAmount, double rate){
                super(initialAmount);
                this.rate = (double)rate/100;
        }
		
	public void deposit(Currency amount) throws Exception{
		throw new DepositException();
	}

        public void withdraw(Currency amount) throws Exception{
		if(this.earlyPenalty){
			throw new EarlyWithdrawException();
		} else if(this.totalBalance.cents>=amount.cents){
			this.totalBalance.cents-=amount.cents;
                } else{
			throw new WithdrawException(amount);
                }
        }
		
	public int getBalance(){
                System.out.println(toString());
		return this.totalBalance.cents;
        }

        public String toString(){
                return "Total Balance [CD Account] - $"+this.totalBalance.cents;
        }
}
