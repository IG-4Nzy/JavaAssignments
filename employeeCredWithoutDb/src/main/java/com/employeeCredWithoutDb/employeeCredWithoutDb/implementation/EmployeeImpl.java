package com.employeeCredWithoutDb.employeeCredWithoutDb.implementation;

import com.employeeCredWithoutDb.employeeCredWithoutDb.Dto.EmployeeDto;
import com.employeeCredWithoutDb.employeeCredWithoutDb.model.Employee;
import com.employeeCredWithoutDb.employeeCredWithoutDb.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class EmployeeImpl implements EmployeeService {

    private final List<Employee> employeeList = new ArrayList<>();
    private final AtomicInteger uniqueId = new AtomicInteger(1);

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setId(String.valueOf(uniqueId.getAndIncrement()));
        employee.setName(employeeDto.getName());
        employee.setSalary(employeeDto.getSalary());
        employeeList.add(employee);
        employeeDto.setId(employee.getId());
        return employeeDto;
    }

    @Override
    public EmployeeDto updateEmployee(String id, EmployeeDto employeeDto) {
        for(Employee e : employeeList){
            if(e.getId().equals(id)){
                e.setSalary(employeeDto.getSalary());
                e.setName(employeeDto.getName());
                employeeDto.setId(e.getId());
                return employeeDto;
            }
        }
        return null;
    }

    @Override
    public boolean deleteEmployee(String id) {
        return employeeList.removeIf(e -> e.getId().equals(id));
    }

    @Override
    public List<EmployeeDto> getEmployeeList() {
        List<EmployeeDto> employees = new ArrayList<>();
        for(Employee e : employeeList){
            EmployeeDto dto = new EmployeeDto();
            dto.setId(e.getId());
            dto.setName(e.getName());
            dto.setSalary(e.getSalary());
            employees.add(dto);
        }
        return employees;
    }

    @Override
    public EmployeeDto getEmployeeWithHighestSalary() {
        List<EmployeeDto> employees = new ArrayList<>();
        for(Employee e : employeeList){
            EmployeeDto dto = new EmployeeDto();
            dto.setId(e.getId());
            dto.setName(e.getName());
            dto.setSalary(e.getSalary());
            employees.add(dto);
        }
        return employees
                .stream()
                .max(Comparator.comparing(EmployeeDto::getSalary)).orElse(null);
    }
}
