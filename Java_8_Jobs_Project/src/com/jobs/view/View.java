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
	
	// Fa un recorregut de tots els membres (empleats o voluntaris) mostrant tota la seva informació:
	// Categoria de l'empleat, nom, adreça, telèfon i total pagat
	// Si el membre és de tipus employee mostra també el seu salari mensual i la tasa de pagament
	// Si el membre és de tipus volunteer mostra també la seva descripció
	// Es torna un String amb tota la informació formatejada per a ser mostrada esquemàticament per pantalla
	
	public String showAllMembers() {
		
		String output = "";
		
		for(AbsStaffMember member : this.members) {
			
			output += member.getId()+". ";
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
				String strPaymentRate = String.format("%.2f",(member.getTotalPaid()/e.getSalaryPerMonth()));
				
				output += " Salari_Mensual: ["+ e.getSalaryPerMonth() +"],";
				output += " Payment_Rate: ["+ strPaymentRate +"],";
			}
			
			String strTotalPaid = String.format("%.2f", member.getTotalPaid());

			output += " Total_Pagat: [" + strTotalPaid +"]";
			
			output += "\n\n";
		}
		
		if (output.equals("")) output="No hi ha cap empleat enregistrat.";
		
		return output;
		
	}
	
}
