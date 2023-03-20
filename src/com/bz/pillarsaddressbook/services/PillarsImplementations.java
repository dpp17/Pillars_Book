package com.bz.pillarsaddressbook.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.bz.pillarsaddressbook.dao.AddPillarMember;
import com.bz.pillarsaddressbook.exceptions.InvalidFirstNameException;
import com.bz.pillarsaddressbook.exceptions.InvalidPhoneNumberException;
import com.bz.pillarsaddressbook.interfaces.IPillars;
import com.bz.pillarsaddressbook.model.PillarsPojo;
import com.bz.pillarsaddressbook.utility.RegexPillar;

public class PillarsImplementations implements IPillars {

	private static Scanner getDetailInput = new Scanner(System.in);
	
	ArrayList<PillarsPojo> pillarsStore = new ArrayList<PillarsPojo>();
	
	static RegexPillar regex = new RegexPillar();
	
	static AddPillarMember dbcon = new AddPillarMember();
	
	//ADD
	public int add(PillarsPojo person) throws InvalidPhoneNumberException,InvalidFirstNameException{
		if(regex.isNameValid(person.getFirstName())){
			if(regex.isPhoneNumberValid(person.getPhoneNumber())) {
				pillarsStore.add(person);
				try {
					dbcon.add(person);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				show(person);
				
				return 1;
			}	
		}
		return 0;
	}
	
	//REMOVE
	public void remove(String phoneNumber) {
		pillarsStore.removeIf(data-> data.getPhoneNumber().contentEquals(phoneNumber));
	}

	//UPDATE
	public void updateByPhoneNumber(String phoneNumber) {
		pillarsStore.stream().filter(data->data.getPhoneNumber().contentEquals(phoneNumber)).forEach(data->editDetails(data));
	}
	
	//show_All_Pillars
	@Override
	public void showAll() {
		pillarsStore.stream().forEach(data->show(data));
	}
	
	
	
	//Show
	private void show(PillarsPojo person) {
		System.out.println("-----------------------------------------");
		System.out.println("FirstName :: " + person.getFirstName());
		System.out.println("Age :: " + person.getAge());
		System.out.println("PhoneNUmber :: " + person.getPhoneNumber());
		System.out.println("-----------------------------------------"+'\n');
	}
	
	//UPDATE_SUPPORTER
	private void editDetails(PillarsPojo person) {
		byte loopExit = 1; 
			do {
				System.out.println("Choose Option to Update :: " + '\n' + " 1.FirstName " + '\n' + " 2.Age " + '\n' + " 3.PhoneNumber "+ '\n');
				byte option = getDetailInput.nextByte();
				
				switch(option) {
				case 1:
						System.out.println(" FirstName :: "); 
						person.setFirstName(getDetailInput.next());
					break;
				case 2:
						System.out.println(" Age :: ");
						person.setAge(getDetailInput.nextInt());
					break;
				case 3:
						System.out.println(" Address :: ");
						person.setPhoneNumber(getDetailInput.next());
					break;
				default:
					System.out.println(" ****---- Invalid Input ----**** ");
				}
				show(person);
				System.out.println(" Press 1: If you want to update anything else " + '\n' + " Press 0: Exit to Menu ");
				loopExit = getDetailInput.nextByte();
			}while(loopExit != 0);
	}

	
}
