public class InvalidAccountException extends Exception{
	public InvalidAccountException(Currency currency, String type){
		super("ERROR. An account of type "+type.toUpperCase()+" is invalid (must be of type SAVINGS or CD or CHECKING)");
	}
	
	public InvalidAccountException(boolean placeholder, String type){
                super("ERROR. An account of type "+type.toUpperCase()+" is invalid (must be of type SAVINGS or CD or CHECKING)");
        }
	
	public InvalidAccountException(String type){
		super("ERROR. An account of type "+type.toUpperCase()+" is invalid (must be of type CHECKING)");
	}
	
	public InvalidAccountException(String type, double rate){
		super("ERROR. An account of type "+type.toUpperCase()+" is invalid (must be of type SAVINGS or CD)");
	}
}
