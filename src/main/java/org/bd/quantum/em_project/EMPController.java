package org.bd.quantum.em_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EMPController {

//    EmployeeService employeeService = new EmployeeServiceImpl();
//    Dependency Injection

    private final EmployeeService employeeService;

    @Autowired
    public EMPController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("employees")
    public List<Employee> getAllEmployees(){
        return employeeService.readEmployees();
    }

    @GetMapping("employees/{id}")
    public Employee getEmployeeById (@PathVariable Long id ){
        return employeeService.readEmployeeById(id);
    }

    @PostMapping("employees")
    public String createEmployee (@RequestBody Employee employee ){
        return employeeService.createEmployee(employee);
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee (@PathVariable Long id ){

        if(employeeService.deleteEmployee(id)){
          return "Deleted Successfully";
      }

        return "Not Found";
    }

    @PutMapping("employees/{id}")
    public String updateEmployee (@PathVariable Long id, @RequestBody Employee employee ){
          return  employeeService.updateEmployee(id,employee);
      }

    }

