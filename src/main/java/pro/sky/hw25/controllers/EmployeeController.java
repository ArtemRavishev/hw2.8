package pro.sky.hw25.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.hw25.domain.Employee;
import pro.sky.hw25.services.EmployeeService;
import pro.sky.hw25.exceptions.EmployeeAlreadyAddedException;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public String welcome() {
        return " Добро пожаловать в HR Application";
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String  lastName) {
        return service.addEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName) {
        return service.findEmployee(firstName, lastName);
    }
    @GetMapping("/remove")
    public Employee removeEmployee (@RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName) {
        return service. removeEmployee(firstName, lastName);
    }
}