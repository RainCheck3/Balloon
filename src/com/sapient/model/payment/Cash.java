package com.sapient.model.payment;


class InValidAmountException extends Exception
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InValidAmountException(String message)
    {
        super(message);
    }
}



public class Cash extends Payment {
	private double cashTendered;

	public double getCashTendered() {
		return cashTendered;
	}

	public void setCashTendered(double amountPaid) throws Exception {
		
		this.cashTendered = amountPaid;

	}
	
	
}
