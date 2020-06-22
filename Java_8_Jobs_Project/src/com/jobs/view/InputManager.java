package com.jobs.view;

import java.util.Scanner;

import com.jobs.application.JobsController;

public class InputManager {

	Scanner input;
	InputCommons commons; // Encapsula les operacions bàsiques de gestió d'entrada de dades per part de l'usuari
	JobsController controller; // Es necessita per a crear un empleat quan l'usuari ho demani
	
	public InputManager(JobsController controller) {
		this.input = new Scanner(System.in);
		this.commons = new InputCommons(this.input);
		this.controller = controller;
		
	}
	
	public void close() {
		this.input.close();
	}
	
	/**
	 *  Mostra menu per pantalla i espera per consola la selecció d'opció per part de l'usuari
	 */
	public void showMenu() {
		
		boolean exit = false;
		int option = 0;
		
		while (exit==false) {
			
			System.out.println("-----------------------------------");
			System.out.println("	            MENU               ");		
			System.out.println("-----------------------------------");

			System.out.println("1. Enregistra nou empleat");
			System.out.println("2. Paga mensualitat i mostra tota la informació dels empleats");
			System.out.println("3. Esborra tots els empleats");
			System.out.println("4. Sortir del programa");

			
			System.out.println("-----------------------------------");
			
			
			option = commons.askOption(1, 4);
			
			switch(option) {
				case(1) : 
						this.createEmployee();
						break;
				case(2) :
						this.payAndShowAllEmployees();
						break;
				case(3) :
						this.removeAllEmployees();
						break;
				default :
						break;
			}
			exit = (option==4);
		}

		System.out.println("-----------------");
		System.out.println(" FI DEL PROGRAMA ");
		System.out.println("-----------------");
		
	}
	
	/**
	 * Crea un nou empleat o un nou voluntari amb les dades introduides per part de l'usuari
	 * Es crea els objectes mitjançant el controlador JobsController el qual ja encapsula el comportament
	 * d'afegir aquests nous objectes al repositori com.jobs.persistence.StaffMemberRepository
	 * 
	 */
	private void createEmployee() {
		
		System.out.println("------------------------");
		System.out.println(" REGISTRE DE NOU EMPLEAT");
		System.out.println("------------------------");
		
		System.out.println("1. Volunteer");
		System.out.println("2. Employee");
		System.out.println("3. Manager");
		System.out.println("4. Boss");

		System.out.println("------------------------");

		int option = commons.askInt("Selecciona la categoria de l'empleat [ 1 - 4 ]:",1,4);
		
		boolean correctFormat = false;
		
		while (correctFormat==false) {
				
			String name = commons.askString("Introdueix el NOM de l'empleat:");
			String address = commons.askString("Introdueix la ADREÇA de l'empleat:");
			String phone = commons.askString("Introdueix el TELEFON de l'empleat:");
	
			try {
				
				if (option == 2 || option == 3 || option == 4) {
					this.createEmployee(option,name,address,phone);
				}else if(option ==1) {
					this.createVolunteer(name,address,phone);
				}
				correctFormat = true;
				
			}catch(Exception e) {
				
				System.out.println(e.getMessage());
				System.out.println("Torna a introduir les dades de l'empleat de nou.");
				
			}
		}
		
		System.out.println("L'empleat s'ha enregistrar correctament.");
		commons.pause();
		
	}
	
	/**
	 *  Crea un objecte de tipus Employee i l'afegeix al repositori d'objectes AbsStaffMember
	 * @param option
	 * @param name
	 * @param address
	 * @param phone
	 * @throws Exception
	 */
	private void createEmployee(int option, String name,String address,String phone) throws Exception{
		
		double salaryPerMonth = commons.askDouble("Introdueix el SALARI MENSUAL de l'empleat:");
		
		if(option==2) {
			this.controller.createEmployee(name, address, phone, salaryPerMonth);
		}else if(option==3) {
			this.controller.createManagerEmployee(name, address, phone, salaryPerMonth);
		}else if(option==4) {
			this.controller.createBossEmployee(name, address, phone, salaryPerMonth);
		}
		
	}
	
	/**
	 *  Crea un objecte de tipus Volunteer i l'afegeix al repositori d'objectes AbsStaffMember
	 * @param name
	 * @param address
	 * @param phone
	 * @throws Exception
	 */
	private void createVolunteer(String name, String address, String phone) throws Exception{
		String description = commons.askString("Introdueix la DESCRIPCIÓ de l'empleat voluntari:");

		this.controller.createVolunteer(name, address, phone, description);
		
	}
	
	/**
	 * Calcula el total a pagar a partir del salari mensual (si en tenen) invocant el mètode pay() 
	 * de tots els empleats i/o voluntaris 
	 * A continuació es mostra per consola tot el llistat amb els empleats i tota la seva informació enregistrada
	 */
	private void payAndShowAllEmployees() {
		
		System.out.println("-------------------");
		System.out.println("LLISTAT DE EMPLEATS");
		System.out.println("-------------------");
		
		this.controller.payAllEmployees();
		
		View view = new View(this.controller.getAllMembers());
		System.out.println(view.showAllMembers());
		
		commons.pause();
	}
	
	/**
	 * Elimina tots les empleats(membres del personal) del repositori StaffMemberRepository
	 */
	private void removeAllEmployees() {
		
		this.controller.removeAllEmployees();
		
		System.out.println("Tots els empleats s'han eliminat correctament.");
		
		commons.pause();
		
	}
	
}
