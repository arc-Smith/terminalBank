public class Currency{
	public int cents;
	
	/* Accepts no parameter and sets the cents member variable to zero */
	public Currency(){
		this.cents = 0;
	}
	
	/* Accepts one parameter (i.e. cents) which sets the cents member variable to the one parameter */
	public Currency(int cents){
		if(cents>=1){
			this.cents = cents;
		} else{
			this.cents = 0;
		}
	}
	
	/* A getter method for cents variable */
	public int getValue(){
		return this.cents;
	}	
	
	/* Adds two Currency objects together and returns their added amount */
	public int add(Currency rhs){
		return this.cents+rhs.cents;	
	}

	/* Subtracts two Currency objects and returned their subtracted amount */
        public int subtract(Currency rhs){
                return this.cents-rhs.cents;
        }
	
	/* Overridden toString method which prints amount of money in dollars */
	public String toString(){
		return "$"+this.cents;
	}
}


