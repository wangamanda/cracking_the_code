package ATMmachine;

public class Test{
	public static void main(String[] args){
		ATM atm = new ATM();
		atm.deposit(50);
		atm.withdraw(100);
		System.out.println(atm.getBalance()+"");
	}
}
