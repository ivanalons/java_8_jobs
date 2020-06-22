package com.jobs.domain;

public class Volunteer extends AbsStaffMember {
	
	String description;

	/**
	 * El membre Volunteer no necessita cap atribut IPaymentRate perquè no cobra cap remuneració
	 * a diferència dels objectes de tipus Employee
	 * 
	 * @param name
	 * @param address
	 * @param phone
	 * @param description
	 * @throws Exception
	 */
	public Volunteer(String name, String address, String phone, String description) throws Exception {
		super(name, address, phone);
		this.description = description;
		if(description.equals("")) throw new Exception("El camp amb la DESCRIPCIO de l'empleat voluntari no pot estar buit.");
		
		super.incrementId();
	}

	
	/**
	 * El total pagat al personal de tipus Volunteer sempre serà zero
	 */
	@Override
	public void pay() {
		
		totalPaid = 0;
		
	}


	public String getDescription() {
		return description;
	}
	
	

}
