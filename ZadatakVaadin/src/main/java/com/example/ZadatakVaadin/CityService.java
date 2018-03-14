package com.example.ZadatakVaadin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<City> findAllCities() {
    	return jdbcTemplate.query(
    		"SELECT CityId, Name FROM city",
    			(rs2, rowNum) -> new City(rs2.getLong("CityId"),
    			rs2.getString("Name")));
    }
    
    //ovo će trebati kad su SELECT svi gradovi, ustvari može se izmjeniti za selectirani grad
    //SELECT employee.EmployeeId, employee.FirstName, employee.LastName, city.CityId, city.Name FROM employee LEFT JOIN city ON  employee.CityId=city.CityId
    
    /*public void update(City city) {
        jdbcTemplate.update(
            "UPDATE customers SET FirstName=?, LastName=? WHERE EmployeeId=?",
            employee.getFirstName(), employee.getLastName(), employee.getId());
    }*/

}