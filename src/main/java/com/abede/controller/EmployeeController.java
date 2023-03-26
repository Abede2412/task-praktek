package com.abede.controller;

import com.abede.service.EmployeeService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.Map;

@Path("employees")
public class EmployeeController {

    @Inject
    EmployeeService employeeService;


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> nomer1(@PathParam("id") Integer id) throws SQLException {
       return employeeService.nomer1(id);
    }

    @GET
    @Path("factorial")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<Integer, Integer> nomer2(@QueryParam("n") Integer n) throws SQLException {
        return employeeService.nomer2(n);
    }


}
