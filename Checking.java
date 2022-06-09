public class Checking extends Account{
	public Checking(Currency initialAmount){
                super(initialAmount);
        }
	
        public void deposit(Currency amount){
		this.totalBalance.cents += amount.cents;
        }

        public void withdraw(Currency amount) throws Exception{
                if(this.totalBalance.cents>=amount.cents){
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
                return "Total Balance [Checking Account] - $"+this.totalBalance.cents;
        }	
}
