public class NoncustomerException extends Exception{
	public NoncustomerException(){
		super("ERROR. YOU are not a member of this bank");
	}
	public NoncustomerException(String first, String last){
		super("ERROR. "+first+" "+last+" is not a member of bank");
	}
}
