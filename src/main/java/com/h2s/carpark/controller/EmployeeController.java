/*
 * @created 05/10/2021 - 12:47 AM
 * @author vanha
 */

package com.h2s.carpark.controller;

import com.h2s.carpark.dto.payload.ApiResponse;
import com.h2s.carpark.dto.request.EmployeeRequest;
import com.h2s.carpark.dto.response.EmployeeResponse;
import com.h2s.carpark.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public List<EmployeeResponse> getAll(){
        return employeeService.getAll();
    }

    @PostMapping("")
    public EmployeeResponse saveEmployee(@RequestBody EmployeeRequest employeeRequest){
        return employeeService.addEmployee(employeeRequest);
    }

    @PutMapping("{id}")
    public ApiResponse updateEmployee(@PathVariable("id") String id,@RequestBody EmployeeRequest employeeRequest){
        return employeeService.updateEmployee(id, employeeRequest);
    }

    @GetMapping("query")
    public List<EmployeeResponse> findByAccount(@RequestParam(value="account", required=true) String account) {
        return employeeService.searchByAccount(account);
    }

    @DeleteMapping("{id}")
    public ApiResponse deleteEmployee(  @PathVariable("id") String id){
        return employeeService.deleteEmployee(id);
    }

}
