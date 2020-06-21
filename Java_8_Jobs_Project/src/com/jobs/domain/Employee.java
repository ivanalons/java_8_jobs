package com.jobs.domain;

public class Employee extends AbsStaffMember {

	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;	

	public Employee(String name, String address, String phone, double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone);		
		if(salaryPerMonth<0) throw new Exception("El SALARI MENSUAL de l'empleat ha de ser un valor positiu.");
		if(paymentRate==null) 
			throw new Exception("S'ha de crear un objecte que implementi la interficie IPaymentRate al parametre paymentRate del constructor Employee.");
				
		this.salaryPerMonth=salaryPerMonth;
		this.paymentRate=paymentRate;
		
		super.incrementId();
	}

	
	@Override
	public void pay() {
		totalPaid =paymentRate.pay(salaryPerMonth); //Només es guarda mensualitat
		//totalPaid += paymentRate.pay(salaryPerMonth); //usar en cas d'acumular varies mensualitats

	}
	
	public double getSalaryPerMonth() {
		return this.salaryPerMonth;
	}

}
