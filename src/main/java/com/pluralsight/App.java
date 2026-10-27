package com.pluralsight;


import java.io.*;

public class App {

    public static void main(String[] args) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("employees.csv"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("payroll-sept-2023.csv"));

            bufferedReader.readLine();


            String line;
            System.out.println("-------------");
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split("\\|");

                Employee employee = new Employee(Integer.parseInt(values[0]), values[1], Double.parseDouble(values[2]), Double.parseDouble(values[3]));

                double hours = employee.getHoursWorked();
                double rate = employee.getPayRate();

                bufferedWriter.write(employee.toString() + "\n");

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
