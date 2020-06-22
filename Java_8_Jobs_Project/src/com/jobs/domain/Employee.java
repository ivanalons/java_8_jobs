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

	/**
	 * Paga a cada empleat una tasa de pagament segons la seva categoria
	 * Com que l'atribut "paymentRate" ja conté una implementació del mètode "pay" segons la categoria 
	 * de l'empleat (Boss, Manager o Employee) no cal sobreescriure el mètode a les subclasses de Employee
	 * perque aquest atribut ja encapsula el comportament del metode "pay" de l'objecte actual
	 * 
	 */
	@Override
	public void pay() {
		totalPaid =paymentRate.pay(salaryPerMonth); //Només es guarda mensualitat
		//totalPaid += paymentRate.pay(salaryPerMonth); //usar en cas d'acumular varies mensualitats

	}
	
	public double getSalaryPerMonth() {
		return this.salaryPerMonth;
	}

}
