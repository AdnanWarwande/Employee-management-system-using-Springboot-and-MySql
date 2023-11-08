package com.example.EmployeeMgmSyst.employee;

import java.util.List;

public interface EmployeeService {

    List<Employees> getAllEmployees();
    Employees getEmployeeById(Long id);
    void createEmployee(Employees employee);
    void updateEmployee(Long id, Employees employee);
    void deleteEmployee(Long id);
    List<Employees> searchEmployees(String search);
    int getTotalEmployeeCount();
}
