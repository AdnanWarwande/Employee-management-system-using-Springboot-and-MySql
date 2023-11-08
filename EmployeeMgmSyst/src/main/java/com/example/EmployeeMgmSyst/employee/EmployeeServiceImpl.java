package com.example.EmployeeMgmSyst.employee;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Employees> getAllEmployees() {
        return jdbcTemplate.query("CALL get_all_employees()", new EmployeeRowMapper());
    }

    @Override
    public List<Employees> searchEmployees(String search) {
        String searchTerm = search;
        return jdbcTemplate.query("CALL search_employees(?)", new Object[]{searchTerm}, new EmployeeRowMapper());
    }

    @Override
    public Employees getEmployeeById(Long id) {
        return jdbcTemplate.queryForObject("CALL get_employee_by_id(?)", new Object[]{id}, new EmployeeRowMapper());
    }

    @Override
    public void createEmployee(Employees employee) {
        jdbcTemplate.update("CALL create_employee(?, ?, ?, ?, ?)",
                employee.getName(), employee.getContact(), employee.getJobTitle(),
                employee.getDepartment(), employee.getSalary());
    }

    @Override
    public void updateEmployee(Long id, Employees employee) {
        jdbcTemplate.update("CALL update_employee(?, ?, ?, ?, ?, ?)",
                id, employee.getName(), employee.getContact(), employee.getJobTitle(),
                employee.getDepartment(), employee.getSalary());
    }

    @Override
    public void deleteEmployee(Long id) {
        jdbcTemplate.update("CALL delete_employee(?)", id);
    }

    @Override
    public int getTotalEmployeeCount() {
        String sql = "SELECT getTotalEmployeeCount()";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
