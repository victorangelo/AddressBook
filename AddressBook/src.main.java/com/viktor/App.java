package com.viktor;

import org.apache.log4j.Logger;

import com.viktor.service.AddressBookService;
import com.viktor.service.impl.AddressBookServiceImpl;

/**
 * @author Viktor Angelutsa
 *
 */
public class App {
	
	private static final Logger logger = Logger.getLogger(AddressBookServiceImpl.class);
	
	public static void main(String[] args) {
	      if (args.length < 1) {
	         logger.info("Enter a file to be read.");
	      } else {
	         //args[0]
	    	 AddressBookService service = new AddressBookServiceImpl();
	    	 logger.info("Reading the file with Persons.");
	    	 service.readFileOfAddressBooks(args[0]);
	    	 logger.info("How many males are in the address book? Response : " + service.malesInAddressBook());
	    	 logger.info("Who is the oldest person in the address book? Response : " + service.theOldestPerson());
	    	 logger.info("How many days older is Bill than Paul? Response : " + service.daysOlderByName("Bill", "Paul"));
	      }
	   }
}
