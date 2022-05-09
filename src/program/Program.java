package program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Department dep = new Department();
		Worker worker;
		
		System.out.print("Enter with name of department: ");
		String department = sc.next();
		dep.setName(department);
		
		System.out.println("Enter with datas of worker.");
		System.out.print("Name: ");
		String name = sc.next();
		
		System.out.print("level (1-for JUNIOR, 2-for MID_LEVEL and 3-for SENIOR): ");
		int Qlevel = sc.nextInt();
		WorkerLevel level;
		if(Qlevel == 1) {
			level = WorkerLevel.JUNIOR;
		}else if(Qlevel == 2) {
			level = WorkerLevel.MID_LEVEL;
		}else{
			level = WorkerLevel.SENIOR;
		}
		
		System.out.print("Base Salary: ");
		double baseSalary = sc.nextDouble();
		
		//Aqui o funcionário já tem nome, level e base saraial
		worker = new Worker(name, level, baseSalary);
		worker.setDepartment(dep);
		
		System.out.print("How many contracts to this worker? ");
		int totalContracts = sc.nextInt();
		List<HourContract> contracts = new ArrayList<>();
		
		for(int i = 0; i<totalContracts; i++) {
			System.out.print("Date (dd/MM/yyyy): ");
			String dateString = sc.next();
			Date dateContract = sdf.parse(dateString);
			System.out.print("Value of Hour: ");
			double valueHour = sc.nextDouble();
			System.out.print("Total of Hours: ");
			int totalHours = sc.nextInt();
			System.out.print("----------");
			System.out.println();
			HourContract contract = new HourContract(dateContract, valueHour, totalHours);
			contracts.add(contract);
		}
		
		//Aqui o funcionario já tem todos os atributos
		worker.addContract(contracts);
		
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		sc.close();
	}

}
