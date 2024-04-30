package org.bd.quantum.em_project;

import java.util.List;

public interface EmployeeService {

    String createEmployee(Employee employee);

    List<Employee> readEmployees();

    Employee readEmployeeById(Long id);

    boolean deleteEmployee(long id);

    String updateEmployee(long id, Employee employee);
}