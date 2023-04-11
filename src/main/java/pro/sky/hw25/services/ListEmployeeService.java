package pro.sky.hw25.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pro.sky.hw25.domain.Employee;
import pro.sky.hw25.exceptions.EmployeeAlreadyAddedException;
import pro.sky.hw25.exceptions.EmployeeNotFoundException;
import pro.sky.hw25.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class ListEmployeeService implements EmployeeService{

    private static final int CAPACITY=10;

    List<Employee> stuff = new ArrayList<>();

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee temp = new Employee(firstName,lastName);
        if (stuff.size() >= CAPACITY) {
            throw new EmployeeStorageIsFullException();
        }
        if (stuff.contains(temp)) {
            throw new EmployeeAlreadyAddedException();
        }
        stuff.add(temp);
        return temp;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        int index = stuff.indexOf(new Employee(firstName, lastName));
        if (index == -1) {
            throw new EmployeeNotFoundException();
        }
        return stuff.remove(index);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        int index = stuff.indexOf(new Employee(firstName, lastName));
        if (index == -1) {
            throw new EmployeeNotFoundException();
        }
        return stuff.get(index);
    }
}
