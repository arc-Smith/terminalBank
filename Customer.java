import java.util.*;

public class Customer{
	private int accountTotal = 0;
	private ArrayList<Account> accounts = new ArrayList<Account>();
	private int oneChecking = 0;
	private int oneSavings = 0;
	private int oneCD = 0;
	private int index = 0;
	private String first;
        private String last;

	private int checkingIndex;
	private int savingsIndex;
	private int cdIndex;
		
	public Customer(String first, String last){
		this.first = first;
		this.last = last;
	}
	
	public String getFirstName(){
                return this.first;
        }

        public String getLastName(){
                return this.last;
        }
							
	/* Add account specifically for savings and cd account */	
	public void addAccount(Currency currency, String type, double rate) throws Exception{
		type = type.toLowerCase();
		if(type.equals("savings") || type.equals("cd")){
			if(type.equals("savings") && oneSavings!=1){
                        	Account mySavings = new Savings(currency, rate);
                        	this.accounts.add(mySavings);
                        	this.oneSavings++;
                        	this.accountTotal++;
                        	this.savingsIndex = this.index++;
				return;
                	} else if(type.equals("cd") && oneCD!=1){
                        	Account myCD = new CD(currency, rate);
                        	this.accounts.add(myCD);
                        	this.oneCD++;
                        	this.accountTotal++;
                        	this.cdIndex = this.index++;
				return;
                	} else{
                        	if(type.equals("savings")){
                         	       throw new AccountExistsException(type, this.first, this.last, this.accounts.get(savingsIndex).getBalance());
                        	}
                        	throw new AccountExistsException(type, this.first, this.last, this.accounts.get(cdIndex).getBalance());
                	}		
		}
		throw new InvalidAccountException(type, rate);
	}
		
	/* Add account specifically for checking account */
	public void addAccount(Currency currency, String type) throws Exception{
		type = type.toLowerCase();
		if(!(type.equals("checking"))){
			throw new InvalidAccountException(type);
                } else if(oneChecking!=1){
			Account myChecking = new Checking(currency);
			this.accounts.add(myChecking);
			this.oneChecking++;
			this.accountTotal++;	
			this.checkingIndex = this.index++;
			return;
		} else{
			throw new AccountExistsException(type, this.first, this.last, this.accounts.get(checkingIndex).getBalance());
		}
	}
	
	public void deposit(Currency money, String type) throws Exception{	
		type = type.toLowerCase();
		if(type.equals("savings") || type.equals("cd") || type.equals("checking")){
			if(type.equals("savings") && oneSavings==1){
                        	for(Account account : this.accounts)
                                	if(account instanceof Savings){
                                        	account.deposit(money);
						return;
					}
                	} else if(type.equals("cd") && oneCD==1){
                        	for(Account account : this.accounts)
                                	if(account instanceof CD){
                                        	account.deposit(money);
						return;
					}
			} else if(type.equals("checking") && oneChecking==1){
                        	for(Account account : this.accounts)
                                	if(account instanceof Checking){
                                        	account.deposit(money);
						return;
					}
                	} else{
				throw new UnavailableTypeException(type, this.first, this. last);
			}
		}
		throw new InvalidAccountException(money, type);
	}
	
	public void withdraw(Currency money, String type) throws Exception{
		type = type.toLowerCase();
		if(type.equals("savings") || type.equals("cd") || type.equals("checking")){
			if(type.equals("savings") && oneSavings==1){
                        	for(Account account : this.accounts)
                                	if(account instanceof Savings){
                                        	account.withdraw(money);
						return;
					}
                	} else if(type.equals("cd") && oneCD==1){
                        	for(Account account : this.accounts)
                                	if(account instanceof CD){
                                        	account.withdraw(money);
						return;	
					}
			} else if(type.equals("checking") && oneChecking==1){
                        	for(Account account : this.accounts)
                                	if(account instanceof Checking){
                                        	account.withdraw(money);
						return;
					}
                	} else{
				throw new UnavailableTypeException(type, this.first, this.last);
			}
		}
		throw new InvalidAccountException(money, type);
        }
	
	public void balance(String type) throws Exception{
		boolean placeholder = true; // boolean created to serve as parameter of a overloaded method
		type = type.toLowerCase();
		if(type.equals("savings") || type.equals("cd") || type.equals("checking")){
                	if(type.equals("savings") && oneSavings==1){
                        	for(Account account : this.accounts)
                                	if(account instanceof Savings){
						account.getBalance();
						return;
					}
                	} else if(type.equals("cd") && oneCD==1){
                        	for(Account account : this.accounts)
                                	if(account instanceof CD){
						account.getBalance();
						return;
					}
                	} else if(type.equals("checking") && oneChecking==1){
                        	for(Account account : this.accounts)
                                	if(account instanceof Checking){
						account.getBalance();
						return;
					}
             		} else{
				throw new UnavailableTypeException(type, this.first, this.last);
                	}
		}
		throw new InvalidAccountException(placeholder, type);
	}	
	
	/* Equals method to compare the content of two Customer objects */
	public boolean equals(Object obj){
		boolean isCustomer = obj instanceof Customer;
		if(!isCustomer){
			return false;	
		}
		Customer aCustomer = (Customer)obj;
		return this.first.equals(aCustomer.first) && this.last.equals(aCustomer.last);
	}
}
