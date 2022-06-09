import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		ArrayList<Customer> bank = new ArrayList<Customer>();
		
		
		Scanner sc = new Scanner(System.in);
		
		menu(bank, sc);
		
		sc.close(); 		
	}
	
	public static void menu(ArrayList<Customer> bank, Scanner sc) throws Exception{
		System.out.println("Type 1) to become a member of bank");
                System.out.println("Type 2) to open an account");
		System.out.println("Type 3) to display account balance");
                System.out.println("Type 4) to deposit money");
		System.out.println("Type 5) to withdraw money");
                System.out.println("Type 6) to exit");
                System.out.println();

		int choice = Integer.parseInt(sc.nextLine());

                while(choice!=6){
                        if(choice==1){
				System.out.println();
                                System.out.println("Enter first name");
                                String first = sc.nextLine();
				System.out.println();
                                System.out.println("Enter last name");
                                String last = sc.nextLine();
				System.out.println();
				for(Customer customer : bank){
                                        if(customer.getFirstName().equals(first) && customer.getLastName().equals(last)){
						throw new CustomerException(first, last);
                                        }
                                }
                                Customer a = new Customer(first,last);
				bank.add(a);
                        } else if(choice==2){
				if(bank.size()==0){
					throw new NoncustomerException();
				}
				boolean isMember = false;
				System.out.println();
                                System.out.println("Enter first name");
                                String first = sc.nextLine();
				System.out.println();
                                System.out.println("Enter last name");
                                String last = sc.nextLine();
				System.out.println();
				int i = 0;
				for(Customer customer : bank){
					if(customer.getFirstName().equals(first) && customer.getLastName().equals(last)){
						isMember = true;
                                        }
					if(i==bank.size()-1 && !isMember){
						throw new NoncustomerException(first, last);
					}
					i++;
				}	
				System.out.println("Enter account type (checking / savings / cd)");
                                String type = sc.nextLine();
				type = type.toLowerCase();
				System.out.println();
				System.out.println("Enter initial deposit amount");
                                int amount = Integer.parseInt(sc.nextLine());
				System.out.println();
				if(type.equals("savings") || type.equals("cd")){
					System.out.println("Enter account rate (as a percent / %)");
                                	double rate = Double.parseDouble(sc.nextLine());
                                	System.out.println();
					for(Customer customer : bank){
                                        	if(customer.getFirstName().equals(first) && customer.getLastName().equals(last)){
                                                	Currency money = new Currency(amount);
                                                	customer.addAccount(money, type, rate);
							isMember = true;
                                        	}
                                	}
					if(!isMember){
						throw new NoncustomerException(first, last);
					}
				} else{
					for(Customer customer : bank){
                        	                if(customer.getFirstName().equals(first) && customer.getLastName().equals(last)){
                	                                Currency money = new Currency(amount);
                                	                customer.addAccount(money, type);
        	                  			isMember = true;
						}
	                                }	
					if(!isMember){
                                        	throw new NoncustomerException(first, last);
                                        }
				}
			} else if(choice==3){
				if(bank.size()==0){
                                        throw new NoncustomerException();
                                }
				boolean isMember = false;
				System.out.println();
                                System.out.println("Enter first name");
                                String first = sc.nextLine();
				System.out.println();
                                System.out.println("Enter last name");
                                String last = sc.nextLine();
				System.out.println();
				int i = 0;
                                for(Customer customer : bank){
                                        if(customer.getFirstName().equals(first) && customer.getLastName().equals(last)){
                                                isMember = true;
                                        }
                                        if(i==bank.size()-1 && !isMember){
                                                throw new NoncustomerException(first, last);
                                        }
                                        i++;
                                }
				System.out.println("Enter account type (checking / savings / cd)");
                                String type = sc.nextLine();
				System.out.println();
				for(Customer customer : bank){
					if(customer.getFirstName().equals(first) && customer.getLastName().equals(last)){
						customer.balance(type);
						System.out.println();
						isMember = true;
					}
				}
				if(!isMember){
                                	throw new NoncustomerException(first, last);
                               	}
			} else if(choice==5){
				if(bank.size()==0){
                                        throw new NoncustomerException();
                                }
				boolean isMember = false;
				System.out.println();
                                System.out.println("Enter first name");
                                String first = sc.nextLine();
				System.out.println();
                                System.out.println("Enter last name");
                                String last = sc.nextLine();
				System.out.println();
				int i = 0;
                                for(Customer customer : bank){
                                        if(customer.getFirstName().equals(first) && customer.getLastName().equals(last)){
                                                isMember = true;
                                        }
                                        if(i==bank.size()-1 && !isMember){
                                                throw new NoncustomerException(first, last);
                                        }
                                        i++;
                                }
				System.out.println("Enter account type (checking / savings / cd)");
                                String type = sc.nextLine();
				System.out.println();
				System.out.println("Enter withdraw amount");
                                int amount = Integer.parseInt(sc.nextLine());
				System.out.println();
                                for(Customer customer : bank){
					if(customer.getFirstName().equals(first) && customer.getLastName().equals(last)){
						Currency money = new Currency(amount);
						customer.withdraw(money, type);
                                        	isMember = true;
					}
                                }
				if(!isMember){
                                	throw new NoncustomerException(first, last);
                                }
			} else if(choice==4){
				if(bank.size()==0){
                                        throw new NoncustomerException();
                                }
				boolean isMember = false;
				System.out.println();
                                System.out.println("Enter first name");
                                String first = sc.nextLine();
				System.out.println();
                                System.out.println("Enter last name");
				String last = sc.nextLine();
				System.out.println();	
				int i = 0;
                                for(Customer customer : bank){
                                        if(customer.getFirstName().equals(first) && customer.getLastName().equals(last)){
                                                isMember = true;
                                        }
                                        if(i==bank.size()-1 && !isMember){
                                                throw new NoncustomerException(first, last);
                                        }
                                        i++;
                                }
				System.out.println("Enter account type (checking / savings / cd)");
                                String type = sc.nextLine();
				System.out.println();
                                System.out.println("Enter deposit amount");
                                int amount = Integer.parseInt(sc.nextLine());
				System.out.println();
                                for(Customer customer : bank){
					if(customer.getFirstName().equals(first) && customer.getLastName().equals(last)){
                                                Currency money = new Currency(amount);
                                                customer.deposit(money, type);
                                        	isMember = true;
					}
                                }
				if(!isMember){
                                        throw new NoncustomerException(first, last);
                                }
			}
			System.out.println("Type 1) to become a member of bank");
                	System.out.println("Type 2) to open an account");
                	System.out.println("Type 3) to display account balance");
                	System.out.println("Type 4) to deposit money");
                	System.out.println("Type 5) to withdraw money");
                	System.out.println("Type 6) to exit");
                	System.out.println();
                	choice = Integer.parseInt(sc.nextLine());
			System.out.println();
                }
		sc.close();
	}
}
