package org.bd.quantum.em_project;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

//    List<Employee> employees = new ArrayList<>();

    @Override
    public String createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);

        employeeRepository.save(employeeEntity);
//        employees.add(employee);
        return "Employee Saved Successfully";
    }

    @Override
    public List<Employee> readEmployees() {
        List<EmployeeEntity> employeeList= employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();

        for( EmployeeEntity employeeEntity : employeeList ){
            Employee emp = new Employee();
            emp.setId(employeeEntity.getId());
            emp.setName(employeeEntity.getName());
            emp.setPhone(employeeEntity.getPhone());
            emp.setEmail(employeeEntity.getEmail());

            employees.add(emp);
        }
        return employees;
    }

    @Override
    public Employee readEmployeeById(Long id) {
        EmployeeEntity employeeEntity=employeeRepository.findById(id).get();
        Employee employee=new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);

        return employee;
    }


    @Override
    public boolean deleteEmployee(long id) {
        EmployeeEntity emp = employeeRepository.findById(id).get();
        employeeRepository.delete(emp);

        return true;
    }

    @Override
    public String updateEmployee(long id, Employee employee) {
        EmployeeEntity existingEmployee = employeeRepository.findById(id).get();

        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setName(employee.getName());
        existingEmployee.setPhone(employee.getPhone());

        employeeRepository.save(existingEmployee);
        return "Employee Updated Successfully";
    }


}
