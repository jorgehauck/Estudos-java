package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.print("Solicite o caminho do arquivo: ");
		String path = sc.next();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			List<Employee> list = new ArrayList<>();
			String line = br.readLine();
			
			while(line != null) {
				String[] vect = line.split(",");
				list.add(new Employee(vect[0], vect[1], Double.parseDouble(vect[2])));
				line = br.readLine();
			}
			
			System.out.print("Enter salary: ");
			double salary = sc.nextDouble();
			System.out.println("Email of people whose salary is more than "+String.format("%.2f", salary)+": ");
			
			List<String> email = list.stream()
					.filter(e -> e.getSalary() > salary)
					.map(e -> e.getEmail()).sorted()
					.collect(Collectors.toList());
			
			email.forEach(System.out::println);
			
		    double salario = list.stream()
		    		.filter(s -> s.getName().charAt(0) == 'M')
		    		.map(s -> s.getSalary())
		    		.reduce(0.0, (x, y) -> x + y);
		    
		    System.out.print("Sum of salary of people whose name starts with 'M':"+ String.format("%.2f", salario));	
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		sc.close();
	}
}
