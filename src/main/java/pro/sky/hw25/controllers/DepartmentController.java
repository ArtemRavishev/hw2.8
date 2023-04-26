package pro.sky.hw25.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.hw25.domain.Employee;
import pro.sky.hw25.services.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee findEmployeeMaxSalaryFromDepartment(@RequestParam("departmentId")  int department) {
        return departmentService.findEmployeeWithMaxSalaryFromDepartment(department);
    }

    @GetMapping("/min-salary")
    public Employee findEmployeeMinSalaryFromDepartment(@RequestParam("departmentId")  int department) {
        return departmentService.findEmployeeWithMinSalaryFromDepartment(department);
    }

    @GetMapping(value = "/all",params = "departmentId")
    public List<Employee> printAllEmployeesFromDepartment(@RequestParam("departmentId")  int department) {
        return departmentService.printAllEmployeesFromDepartment(department);
    }
    @GetMapping("/all")
    public Map<Integer, List<Employee>> findEmployes()  {
        return departmentService.printEmployeeByDepartment();
    }
}
