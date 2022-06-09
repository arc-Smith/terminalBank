public class UnavailableTypeException extends Exception{
	public UnavailableTypeException(String type, String first, String last){
		super("ERROR. There does not exist a "+type.toUpperCase()+" account for "+first+" "+last+" in the system");
	}
}

