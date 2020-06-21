package com.jobs.domain;

public class Volunteer extends AbsStaffMember {
	
	String description;

	public Volunteer(String name, String address, String phone, String description) throws Exception {
		super(name, address, phone);
		this.description = description;
		if(description.equals("")) throw new Exception("El camp amb la DESCRIPCIO de l'empleat voluntari no pot estar buit.");
		
		super.incrementId();
	}

	
	@Override
	public void pay() {
		
		totalPaid = 0;
		
	}


	public String getDescription() {
		return description;
	}
	
	

}
