public class AccountExistsException extends Exception{
	public AccountExistsException(String type, String first, String last, int balance){
		super("ERROR. There already exists a "+type.toUpperCase()+" account for "+first+" "+last+" with a balance of $"+balance);
	}
}
	
