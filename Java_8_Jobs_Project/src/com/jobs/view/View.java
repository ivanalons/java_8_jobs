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
	
	// Fa un recorregut de tots els membres (empleats o voluntaris) mostrant tota la seva informaci�:
	// Categoria de l'empleat, nom, adre�a, tel�fon i total pagat
	// Si el membre �s de tipus employee mostra tamb� el seu salari mensual i la tasa de pagament
	// Si el membre �s de tipus volunteer mostra tamb� la seva descripci�
	// Es torna un String amb tota la informaci� formatejada per a ser mostrada esquem�ticament per pantalla
	
	public String showAllMembers() {
		
		String output = "";
		
		for(AbsStaffMember member : this.members) {
			
			output += member.getId()+". ";
			output += "["+member.getClass().getSimpleName().toUpperCase() +"]";
			output += "\n";
			output += " Nom: ["+ member.getName() + "],";
			output += " Adre�a: ["+ member.getAddress()+"],";
			output += " Tel�fon: [" + member.getPhone()+"]";
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
