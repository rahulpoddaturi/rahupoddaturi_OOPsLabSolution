package com.lab.service;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import com.lab.model.Employee;

public class CredentialService {
	Scanner s = new Scanner(System.in);
	public char[] generatePassword(int length)
	{
		  System.out.println("Generating Password");
		  String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	      String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
	      String specialCharacters = "!@#$";
	      String numbers = "1234567890";
	      String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
	      Random random = new Random(10);
	      char[] password = new char[length];

	      password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
	      password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
	      password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
	      password[3] = numbers.charAt(random.nextInt(numbers.length()));
	   
	      for(int i = 4; i< length ; i++) {
	         password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
	      }
	      System.out.println("Password Generated");
	      return password;
		
	}
	public void generateEmailAddress(Employee e)
	{
		
		int options;
		String sDept = "";
		boolean bVal = true;
		do
		{
			System.out.println("Please enter the Department from the following");
			System.out.println("1.Technical");
			System.out.println("2.Admin");
			System.out.println("3.Human Resources");
			System.out.println("4.legal");
		    try
		    {
		    	options = s.nextInt();
		    }
		    catch (InputMismatchException es)
		    {
		    	options = 5;
		    }
		    s.nextLine();
				switch(options)
				{
					case 1 : 
						{
							sDept = "tech";
							bVal = false;
							break;
						}
					case 2 : 
					{
						sDept = "admin";
						bVal = false;
						break;
					}
					case 3 : 
					{
						sDept = "hr";
						bVal = false;
						break;
					}
					case 4 : 
					{
						sDept = "legal";
						bVal = false;
						break;
					}
					default : System.out.println("Please enter a valid Department number");
				}
		}while(bVal);
		if(!bVal)
		{
			System.out.println("Generating Email ID");
			String sEmailId = e.getFirstName().toLowerCase();
				sEmailId += e.getLastName().toLowerCase();
				sEmailId += "@";
				sEmailId+=sDept;
				sEmailId+=".prsolutions.com";
			e.setEmailId(sEmailId);
			System.out.println("Email ID generated");
		}
	}
	
	
	public void showCredentials(Employee e)
	{
		System.out.println("Dear " + e.getFirstName() +" your generated credentials are as follows");
		System.out.println("Email Id --->" +e.getEmailId());
		System.out.println("Password --->" +e.getPassword());
	}

}
