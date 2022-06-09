public class CustomerException extends Exception{
	public CustomerException(String first, String last){
		super("ERROR. "+first+" "+last+" is already a member of bank");
	}
}
