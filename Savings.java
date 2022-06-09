public class Savings extends Account{
	private double rate;	
	private int projection; // Used to project account balance overtime to entice customers to save
	private int withdrawLimit = 6; // Would be reset to 6 once new statement cycle is entered
	
	public Savings(Currency initial, double rate){
		super(initial);
		this.rate = (double)rate/100;
		
		/*
			Principal = the initial amount added into the Savings account
			Rate = the percentage divided by 100
			How Much Interest Is Received In A Given Year = assume a daily compound of interest (i.e. 365)
			Time = assume saving from age 22 to 65 
		*/
		int principal = initial.cents;
		double compoundInterest = principal*(Math.pow(1+(this.rate/365), 365*(65-22)));
		this.projection+=(int)compoundInterest;
	}
		
	public void deposit(Currency amount){
		this.totalBalance.cents+=amount.cents;
	}
	
	public void withdraw(Currency amount) throws Exception{
		if(amount.cents<=this.totalBalance.cents && this.withdrawLimit>0){
			this.totalBalance.cents-=amount.cents;
			withdrawLimit--;
		} else if(!(this.withdrawLimit>0)){
			throw new WithdrawLimitException();
		} else{
			throw new WithdrawException(amount);
		}
	}
	
	public int getBalance(){
		this.totalBalance.cents += this.projection;
		System.out.println(toString());
		return this.totalBalance.cents;
	}
	
	public String toString(){
		return "Total Balance [Savings Account] - $"+this.totalBalance.cents;
	}
}

