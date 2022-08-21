package CompanyRoster;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        List<Employee>employeeList = new ArrayList<>();



        while (num -- > 0){
            String[]tokens = scanner.nextLine().split("\\s+");

            Employee employee = new Employee();
            employee.name = tokens[0];
            employee.salary = Double.parseDouble(tokens[1]);
            employee.position = tokens[2];
            employee.department = tokens[3];

            switch (tokens.length){

                case 5:
                    if (tokens[4].contains("@")){
                        employee.email = tokens[4];
                    }
                    else {
                        employee.age = Integer.parseInt(tokens[4]);
                    }
                    break;
                case 6:
                    if (tokens[4].contains("@")){
                        employee.email = tokens[4];
                        employee.age = Integer.parseInt(tokens[5]);
                    }
                    else {
                        employee.age = Integer.parseInt(tokens[4]);
                        employee.email = tokens[5];
                    }
            }
            employeeList.add(employee);

        }
       List<String> departmentList = employeeList.stream()
                .map(Employee::getDepartment).distinct()
                .collect(Collectors.toList());

        List<Department>departments = new ArrayList<>();

        for (String department : departmentList) {
            departments.add(new Department(department,
                    employeeList.stream().filter(employee -> employee.getDepartment().equals(department))
                            .collect(Collectors.toList())));
        }

         departments.sort(Comparator.comparing(Department::getAverage).reversed());

         Department department = departments.get(0);

         department.getEmployees().sort(Comparator.comparing(Employee::getSalary).reversed());

            System.out.println("Highest Average Salary: " + department.getName());

            for (Employee employee : department.getEmployees()) {
                System.out.printf("%s %.2f %s %d%n",employee.name,employee.salary,employee.email,employee.age);
            }
        }
    }

