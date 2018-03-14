package com.example.ZadatakVaadin; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.ZadatakVaadin.EmployeeService;

import java.util.List;

@Component
public class EmployeeService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Employee> findAll() {
        return jdbcTemplate.query(
            "SELECT EmployeeId, FirstName, LastName FROM employee",
                (rs, rowNum) -> new Employee(rs.getLong("EmployeeId"),
                rs.getString("FirstName"), rs.getString("LastName")));
    }

    public void update(Employee employee) {
        jdbcTemplate.update(
            "UPDATE employee SET FirstName=?, LastName=? WHERE EmployeeId=?",
            employee.getFirstName(), employee.getLastName(), employee.getId());
    }
    /*
    public void searchEmployee (Employee employee) {
    	return jdbcTemplate.query(
    		"SELECT FirstName, LastName, EmployeeId FROM employee WHERE FirstName LIKE %",
    		(rs, rowNum) -> new Employee(rs.getLong("EmployeeId"),
            rs.getString("FirstName"), rs.getString("LastName")));
    }*/
}
