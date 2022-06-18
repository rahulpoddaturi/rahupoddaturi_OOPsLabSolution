package com.lab.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.lab.model.Employee;
import com.lab.service.CredentialService;

public class DriverClass {

	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			boolean bVal = true;
			do {
				System.out.println("Please Enter the First Name:");
				String FirstName = s.nextLine();
				System.out.println("Please Enter the Last Name:");
				String LastName = s.nextLine();
				
				Employee e = new Employee(FirstName,LastName);
				CredentialService credService = new CredentialService();
				
				credService.generateEmailAddress(e);
				char[] password = credService.generatePassword(14);
				e.setPassword(password.toString());
							
				credService.showCredentials(e);
				System.out.println("Do you want to create credentials for another employee");
				try
				{
					bVal = s.nextBoolean();
				}
				catch(InputMismatchException ex)
				{
					s.nextLine();
					System.out.println("Please enter either true/false");
					bVal = s.nextBoolean();
				}
				s.nextLine();
			}while(bVal);
		}
		System.out.println("Exiting...");
	}

}
