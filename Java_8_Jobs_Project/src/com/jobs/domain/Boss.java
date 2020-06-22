package com.jobs.domain;

public class Boss extends Employee {

	public Boss(String name, String address, String phone, double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate);
	}
	
	/**
	 * El compotament del mètode "pay" de la classe "Boss" ja està implementat a la superclasse Employee 
	 */
}
