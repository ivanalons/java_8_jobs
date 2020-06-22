package com.jobs.application;

import com.jobs.domain.IPaymentRate;

public class PaymentFactory {

	/**
	 * 
	 * @return objecte que implementa el mètode pay de la interficie IPaymentRate per a un Boss
	 */
	public static IPaymentRate createPaymentRateBoss(){
		return new IPaymentRate() {	
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*1.5;
			}
		};
	}
	
	
	/**
	 * 
	 * @return objecte que implementa el mètode pay de la interficie IPaymentRate per a un Manager
	 */
	public static IPaymentRate createPaymentRateManager(){
		return new IPaymentRate() {	
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*1.1;
			}
		};
	}
	
	/**
	 * 
	 * @return objecte que implementa el mètode pay de la interficie IPaymentRate per a un Employee
	 */
	public static IPaymentRate createPaymentRateEmployee(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*0.85;
			}
		};
	}
}
