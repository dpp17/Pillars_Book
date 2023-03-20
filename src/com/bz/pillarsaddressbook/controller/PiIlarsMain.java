package com.bz.pillarsaddressbook.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.bz.pillarsaddressbook.exceptions.InvalidFirstNameException;
import com.bz.pillarsaddressbook.exceptions.InvalidPhoneNumberException;
import com.bz.pillarsaddressbook.interfaces.IPillars;
import com.bz.pillarsaddressbook.model.PillarsPojo;
import com.bz.pillarsaddressbook.services.PillarsImplementations;

public class PiIlarsMain {

	private static Scanner userInput = new Scanner(System.in);
	
	static PillarsPojo getDetails() {
		PillarsPojo pojo = new PillarsPojo();
		
		System.out.println(" Enter FirstName :: ");
		pojo.setFirstName(userInput.next());
		System.out.println(" Enter Age :: ");
		pojo.setAge(userInput.nextInt());
		System.out.println(" Enter PhoneNumber :: ");
		pojo.setPhoneNumber(userInput.next());
		
		return pojo;
	}
	
	public static void main(String[] args) {
		IPillars pillars = new PillarsImplementations();
		try {
		do {
		switch (userInput.nextByte()) {
		case 1:
			pillars.add(getDetails());
			break;
		case 2:
			System.out.println(" Enter PhoneNumber :: ");
			pillars.remove(userInput.next());
			break;
		case 3:
			System.out.println(" Enter PhoneNumebr :: ");
			pillars.updateByPhoneNumber(userInput.next());
			break;
		case 4:
			pillars.showAll();
			break;
		default:
			break;
		}
		System.out.println(" Enter 0 t repeat...");
		}while(userInput.nextByte() == 0);
		}catch (InvalidPhoneNumberException e) {
			System.err.println(e);
		}catch (InvalidFirstNameException e) {
			System.err.println(e);
		}catch (InputMismatchException e) {
			System.err.println(e);
		}catch (Exception e) {
			System.err.println(e);
		}
	}

}
