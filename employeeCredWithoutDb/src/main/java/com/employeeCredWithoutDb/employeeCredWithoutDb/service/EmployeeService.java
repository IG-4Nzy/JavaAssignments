package com.employeeCredWithoutDb.employeeCredWithoutDb.service;

import com.employeeCredWithoutDb.employeeCredWithoutDb.Dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    public EmployeeDto createEmployee(EmployeeDto employeeDto);
    public EmployeeDto updateEmployee(String id,EmployeeDto employeeDto);
    public boolean deleteEmployee(String id);
    public List<EmployeeDto> getEmployeeList();
    public EmployeeDto getEmployeeWithHighestSalary();
}

