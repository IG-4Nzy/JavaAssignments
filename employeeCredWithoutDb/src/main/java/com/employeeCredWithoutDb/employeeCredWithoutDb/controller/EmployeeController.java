package com.employeeCredWithoutDb.employeeCredWithoutDb.controller;

import com.employeeCredWithoutDb.employeeCredWithoutDb.Dto.EmployeeDto;
import com.employeeCredWithoutDb.employeeCredWithoutDb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody  EmployeeDto employeeDto){
        EmployeeDto response = service.createEmployee(employeeDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable String id,
                                                      @RequestBody EmployeeDto employeeDto){
        EmployeeDto response = service.updateEmployee(id,employeeDto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String id){
        boolean isDeleted = service.deleteEmployee(id);
        String message = isDeleted ? "Deleted" : "No Employee with this id";
        HttpStatus status = isDeleted ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(message,status);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getEmployeeList(){
        List<EmployeeDto> employees = service.getEmployeeList();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }

    @GetMapping("highest")
    public ResponseEntity<EmployeeDto> getEmployeeeWithHighestSalary(){
        EmployeeDto employees = service.getEmployeeWithHighestSalary();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }
}
