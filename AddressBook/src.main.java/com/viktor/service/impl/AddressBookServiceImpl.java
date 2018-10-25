package com.viktor.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Days;

import com.viktor.bean.Person;
import com.viktor.service.AddressBookService;

/**
 * @author Viktor Angelutsa
 *
 */
public class AddressBookServiceImpl implements AddressBookService {

	private static final Logger logger = Logger.getLogger(AddressBookServiceImpl.class);
	
	private List<Person> addressBook;

	@Override
	public void readFileOfAddressBooks(String fileName) {
		String line = null;

		try {
			FileReader fileReader = new FileReader(fileName);
			this.addressBook = new ArrayList<Person>();
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				String[] params = line.split(" ");
				Date birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(removeComma(params[3]));
				this.addressBook.add(new Person(removeComma(params[0]), removeComma(params[1]), removeComma(params[2]), birthDate));
			}

			bufferedReader.close();
		} catch (ParseException ex){
			logger.error(ex);
		} catch (FileNotFoundException ex) {
			logger.error(ex);
			ex.printStackTrace();
		} catch (IOException ex) {
			logger.error(ex);
		}
	}

	public String removeComma(String str) {
	    if (str != null && str.length() > 0 && str.charAt(str.length() - 1) == ',') {
	        str = str.substring(0, str.length() - 1);
	    }
	    return str;
	}
	
	@Override
	public int malesInAddressBook() {
		int count = 0;
		for(Person person : this.addressBook){
			if(person.getGender().equals("Male")){
				count++;
			}
		}
		return count;
	}

	@Override
	public Person theOldestPerson() {
		Date date = new Date();
		Person oldest = null;
		for(Person person : this.addressBook){
			if(person.getBirthDate().before(date)){
				oldest = person;
			}
		}
		return oldest;
	}

	@Override
	public int daysOlderByName(String name1, String name2) {
		Person p1 = null, p2 = null;
		
		for(Person person : this.addressBook){
			if(person.getName().equals(name1)){
				p1 = person;
			} else if(person.getName().equals(name2)){
				p2 = person;
			}
		}
		return Days.daysBetween(new DateTime(p1.getBirthDate()), new DateTime(p2.getBirthDate())).getDays();
	}

}
