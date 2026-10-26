package com.pluralsight;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {

    public static void main(String[] args) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("employees.csv"));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split("\\|");

                Employee employee = new Employee(int.parseInt(values[0]), values[1], values[2], values [3])

            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
