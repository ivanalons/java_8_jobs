package com.jobs.domain;

public class Volunteer extends AbsStaffMember {
	
	String description;

	public Volunteer(String name, String address, String phone, String description) throws Exception {
		super(name, address, phone);
		this.description = description;
		if(description=="") throw new Exception();
	}

	
	@Override
	public void pay() {
		
		totalPaid = 0;
		
	}


	public String getDescription() {
		return description;
	}
	
	

}
