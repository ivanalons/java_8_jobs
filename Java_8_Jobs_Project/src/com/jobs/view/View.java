package com.jobs.view;

import java.util.List;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.Volunteer;

public class View {

	private List<AbsStaffMember> members;
	
	public View(List<AbsStaffMember> members){
		this.members = members;
	}
	
	public String showAllMembers() {
		
		String output = "";
		
		for(AbsStaffMember member : this.members) {
		
			output += "["+member.getClass().getSimpleName().toUpperCase() +"]";
			output += "\n";
			output += " Nom: ["+ member.getName() + "],";
			output += " Adreça: ["+ member.getAddress()+"],";
			output += " Telèfon: [" + member.getPhone()+"]";
			output += "\n";
			
			if (member instanceof Volunteer) {
				Volunteer v = (Volunteer) member;
				output += " Descripcio: [" + v.getDescription() +"],";
			}
			
			if( member instanceof Employee) {
				Employee e = (Employee) member;
				output += " Salari_Mensual: ["+ e.getSalaryPerMonth() +"],";
				output += " Payment_Rate: ["+ (member.getTotalPaid()/e.getSalaryPerMonth()) +"],";
			}
			
			output += " Total_Pagat: [" + member.getTotalPaid() +"]";
			
			output += "\n\n";
		}
		
		return output;
		
	}
	
}
