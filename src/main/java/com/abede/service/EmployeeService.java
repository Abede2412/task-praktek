package com.abede.service;

import com.abede.model.Employee;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@ApplicationScoped
public class EmployeeService {

    private Connection connection = null;

    public Connection getConnection(){
        try{
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","031214");
            return connection;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public Map<String, Object> nomer1(Integer id) throws SQLException {

        Map<String, Object> result = new HashMap<>();
        List<Employee> employees = new ArrayList<>();

        String query = "with recursive employee_tree as " +
                "(select id, name, manager_id from employee where id = ? " +
                "union " +
                "select e.id, e.name, e.manager_id from employee e " +
                "inner join employee_tree et " +
                "on e.manager_id = et.id) " +
                "select et.id, et.name, et.manager_id, es.score " +
                "from employee_tree et inner join employee_score es " +
                "on et.id = es.id";

        PreparedStatement preparedStatement = getConnection().prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        Integer sumScore = 0;
        while (rs.next()){
            Employee employee = new Employee();
            employee.setId(rs.getInt("id"));
            employee.setName(rs.getString("name"));
            employee.setManager_id(rs.getInt("manager_id"));
            employee.setScore(rs.getInt("score"));
            employees.add(employee);
            sumScore += employee.getScore();
        }
        result.put("employee dengan manager_id "+id, employees);
        Double avgScore = sumScore.doubleValue()/employees.size();
        result.put("Avg Score", avgScore);

        return result;
    }

    public Map<Integer, Integer> nomer2(Integer n) throws SQLException {

        Map<Integer, Integer> result = new HashMap<>();

        String query = "with recursive n_factorial(n, factorial) as (select 0 as n, 1 as factorial union select n+1, factorial * (n+1) from n_factorial)select * from n_factorial limit ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(query);

        preparedStatement.setInt(1, n+1);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            Integer num = resultSet.getInt(1);
            Integer factorial = resultSet.getInt(2);
            result.put(num, factorial);
        }
        return result;
    }
}
