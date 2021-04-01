package apllication;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exception.DomainException;

public class Program {
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
			System.out.println("Enter account data ");
			System.out.print("Number: ");
			Integer number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			
			Account ac = new Account(number, holder, balance, withdrawLimit);
			System.out.println();
			System.out.print("Enter amount for withdraw:");
			Double amount = sc.nextDouble();
			
			try {
				ac.withdraw(amount);
				System.out.print("New balance: "+String.format("%.2f", ac.getBalance()));
			}
			
			catch (DomainException e) {
				System.out.print(e.getMessage());
			}
			
			sc.close();
	} 	

}
