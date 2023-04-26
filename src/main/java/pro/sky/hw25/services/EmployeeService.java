package pro.sky.hw25.services;

import pro.sky.hw25.domain.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName,int department, int salary);

    Employee removeEmployee(String firstName, String lastName,int department, int salary);

    Employee findEmployee(String firstName, String lastName,int department, int salary);


    List<Employee> getAll();
}
