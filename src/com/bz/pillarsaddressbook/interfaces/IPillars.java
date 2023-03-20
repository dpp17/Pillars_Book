package com.bz.pillarsaddressbook.interfaces;

import com.bz.pillarsaddressbook.model.PillarsPojo;

public interface IPillars {

	int add(PillarsPojo person);
	void remove(String phoneNumber);
	void updateByPhoneNumber(String phoneNumber);
	void showAll();
}
