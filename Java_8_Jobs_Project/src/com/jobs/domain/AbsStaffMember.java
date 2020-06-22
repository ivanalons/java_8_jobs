package com.jobs.domain;

public abstract class AbsStaffMember {

	protected int id;
	protected String name;
	protected String address;
	protected String phone;
	protected double totalPaid=0;

	private static int COUNTER_MEMBERS = 1;

	public AbsStaffMember(String name, String address, String phone) throws Exception {
		if (name.equals(""))
			throw new Exception("El camp amb el NOM de l'empleat no pot estar buit.");
		if (address.equals(""))
			throw new Exception("El camp amb l'ADREÇA de l'empleat no pot estar buit.");
		if (phone.equals(""))
			throw new Exception("El camp amb el TELEFON de l'empleat no pot estar buit.");

		this.name = name;
		this.address = address;
		this.phone = phone;
		
	}

	public void incrementId() {
		id = COUNTER_MEMBERS;
		COUNTER_MEMBERS++;
	}
	
	/**
	 * Mètode abstracte que s'ha d'implementar a les subclasses (Employees o Volunteers)
	 */
	public abstract void pay();

	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public double getTotalPaid() {
		return totalPaid;
	}
	
	
}
