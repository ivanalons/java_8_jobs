package com.jobs.main;

import com.jobs.application.JobsController;
import com.jobs.view.InputManager;

public class Main {

	private static JobsController controller=new JobsController();
	
	public static void main(String[] args) throws Exception {
	
		/*
		
		//CODI SENSE ENTRADA DE DADES PER PART DE L'USUARI
		 
		controller.createBossEmployee("Pepe Boss", "Dirección molona", "666666666", 100.0);
		controller.createEmployee("Pedro Employee", "Dirección molona 2", "665266666", 40.0);
		controller.createEmployee("Laura Employee", "Dirección molona 3", "625266666", 45.0);
		controller.createVolunteer("Juan Volunteer", "Dirección molona 4", "614266666","Descripcion 1");
		controller.createManagerEmployee("Pedro Employee", "Dirección molona 2", "665226666", 80.0);
		
		controller.payAllEmployees();
		
		View view = new View(controller.getAllMembers());
		String allEmployees = view.showAllMembers();
		
		System.out.println(allEmployees);
		*/
		
		//CODI AMB ENTRADA DE DADES PER PART DE L'USUARI
		
		InputManager ui = new InputManager(controller);
		
		ui.showMenu();
		
		ui.close();
	}

}
