package com.pluralsight;


import java.io.*;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the name of the file to be read: ");
            String fileToRead = scanner.nextLine();

            System.out.println("Enter the name of the file to be created: ");
            String fileToWrite = scanner.nextLine();

            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileToRead));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileToWrite));

            bufferedReader.readLine();


            String line;
            System.out.println("-------------");
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split("\\|");

                Employee employee = new Employee(Integer.parseInt(values[0]), values[1], Double.parseDouble(values[2]), Double.parseDouble(values[3]));

                double hours = employee.getHoursWorked();
                double rate = employee.getPayRate();

                bufferedWriter.write(employee.toJson() + "\n");

//                System.out.printf("Paystub for %s\n", employee.getEmployeeName());
//                System.out.println("Employee ID: " + employee.getEmployeeId());
//                System.out.println("Hours Worked: " + hours);
//                System.out.printf("Pay Rate: $%.2f\n", rate);
//                System.out.printf("Gross Pay: $%.2f\n", employee.getGrossPay(hours, rate));
                System.out.println(employee.toString());
                System.out.println("-------------");
            }

            bufferedWriter.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
