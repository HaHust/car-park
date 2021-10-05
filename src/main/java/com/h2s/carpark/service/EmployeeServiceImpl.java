/*
 * @created 05/10/2021 - 12:39 AM
 * @author vanha
 */

package com.h2s.carpark.service;

import com.h2s.carpark.dto.payload.ApiResponse;
import com.h2s.carpark.dto.request.EmployeeRequest;
import com.h2s.carpark.dto.response.EmployeeResponse;
import com.h2s.carpark.entity.Employee;
import com.h2s.carpark.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeResponse> getAll(){
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponse> employeeResponse = new ArrayList<>();
        for (Employee it :
                employees) {
            employeeResponse.add(mapper.map(it, EmployeeResponse.class));
        }
        return employeeResponse;
    }

    public EmployeeResponse addEmployee(EmployeeRequest employeeRequest){
        Employee employee = mapper.map(employeeRequest,Employee.class);
        Employee employee1 = employeeRepository.save(employee);
        EmployeeResponse employeeResponse = mapper.map(employee1, EmployeeResponse.class);
        return employeeResponse;
    }

    @Override
    public List<EmployeeResponse> searchByAccount(String account) {
        List<Employee> employees = employeeRepository.searchByAccount(account);
        List<EmployeeResponse> employeeResponse = new ArrayList<>();
        for (Employee it :
                employees) {
            employeeResponse.add(mapper.map(it, EmployeeResponse.class));
        }
        return employeeResponse;
    }

    @Override
    public ApiResponse deleteEmployee(Long id) {
        try {
            employeeRepository.deleteById(id);
            return new ApiResponse(true,"delete employee Success");
        } catch (Exception ex){
            return new ApiResponse(false, ex.getMessage());
        }
    }

    @Override
    public ApiResponse updateEmployee(Long id, EmployeeRequest employeeRequest) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(!employee.isPresent())
            return new ApiResponse(false, "Employee can't find");
        Employee result = mapper.map(employeeRequest,Employee.class);
        Employee employeeResult = result;
        employeeResult.setEmployeeId(employee.get().getEmployeeId());
        employeeResult.setPassword(employee.get().getPassword());
        try {
            Employee employeeSave = employeeRepository.save(result);
            return new ApiResponse(true,employeeSave.toString());
        } catch (Exception ex){
            return new ApiResponse(false, ex.getMessage());
        }
    }
}
