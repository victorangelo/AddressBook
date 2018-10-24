package com.viktor.service;

import com.viktor.bean.Person;

/**
 * @author Viktor Angelutsa
 *
 */
public interface AddressBookService {

	public void readFileOfAddressBooks(String fileName);
	
	public int malesInAddressBook();
	
	public Person theOldestPerson();
	
	public int daysOlderByName(String name1, String name2);
}
