package com.jobs.domain;

public class Manager extends Employee {

	public Manager(String name, String address, String phone, double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate);
	}
	
	/**
	 * El compotament del m�tode "pay" de la classe "Manager" ja est� implementat a la superclasse Employee 
	 */
	
}
