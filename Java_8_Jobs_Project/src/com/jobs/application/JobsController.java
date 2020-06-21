package com.jobs.application;

import java.util.List;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Boss;
import com.jobs.domain.Employee;
import com.jobs.domain.Manager;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.StaffMemberRepository;

public class JobsController {

	private StaffMemberRepository repository;
	
	public JobsController(){
		this.repository = new StaffMemberRepository();
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Boss(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee employee = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(employee);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Employee manager = new Manager(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateManager());
		repository.addMember(manager);		
	}

	public void createVolunteer(String name, String address, String phone, String description) throws Exception{
		Volunteer volunteer = new Volunteer(name, address, phone,  description);
		repository.addMember(volunteer);		
	}
	
	public void payAllEmployees() {
		
		List<AbsStaffMember> membersList = this.repository.getAllMembers();
		
		for(AbsStaffMember a : membersList ) {
			a.pay();
		}
		
	}

	public List<AbsStaffMember> getAllMembers() {

		return this.repository.getAllMembers();
		
	}

	public void removeAllEmployees() {
		
		this.repository.removeAllMembers();
		
	}

	
	
	
}
