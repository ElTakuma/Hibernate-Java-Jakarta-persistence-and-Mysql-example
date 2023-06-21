package com.mycompany.app.model.repository;

import com.mycompany.app.model.entity.Employee;

public class EmployeeRepository extends CrudJpa<Employee>{
    public EmployeeRepository() {
        super(new Employee());
    }
}
