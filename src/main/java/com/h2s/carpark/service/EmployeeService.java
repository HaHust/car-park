/*
 * @created 05/10/2021 - 12:39 AM
 * @author vanha
 */

package com.h2s.carpark.service;

import com.h2s.carpark.dto.payload.ApiResponse;
import com.h2s.carpark.dto.request.EmployeeRequest;
import com.h2s.carpark.dto.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    public List<EmployeeResponse> getAll();

    public EmployeeResponse addEmployee(EmployeeRequest employeeRequest);

    public List<EmployeeResponse> searchByAccount(String account);

    public ApiResponse deleteEmployee(String id);

    ApiResponse updateEmployee(String id, EmployeeRequest employeeRequest);
}
