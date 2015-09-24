package com.sapient.model.payment;


/**
 * 
 * @author spra26
 *
 */
public class Check extends Payment implements Authorization {

	
	private String name;
	private String bankID;
	
	/**
	 * This method gets bank name.
	 * @return name
	 */
	
	public String getName() {
		return name;
	}
	
	
	/**
	 * This method sets bank name.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * This method gets Bank ID.
	 * @return bankID
	 */
	public String getBankID() {
		return bankID;
	}
	/**
	 * This method sets BankID
	 * @param bankID
	 */
	public void setBankID(String bankID) {
		this.bankID = bankID;
	}
	
	/**
	 * This method authorize whether such bankID and bankName exist.
	 * This method overrides authorize() method from Authorization Interface in same Package.
	 */
	@Override
	public boolean authorized() {
		
		
		return false;
		
	}	
}
