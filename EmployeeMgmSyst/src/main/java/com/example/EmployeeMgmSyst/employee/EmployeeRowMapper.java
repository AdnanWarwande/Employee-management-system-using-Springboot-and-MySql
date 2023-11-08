package com.example.EmployeeMgmSyst.employee;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employees> {

    public Employees mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Employees employee = new Employees();
        employee.setId(resultSet.getLong("id"));
        employee.setName(resultSet.getString("name"));
        employee.setContact(resultSet.getString("contact"));
        employee.setJobTitle(resultSet.getString("job_title"));
        employee.setDepartment(resultSet.getString("department"));
        employee.setSalary(resultSet.getInt("salary"));
        return employee;
    }
}
