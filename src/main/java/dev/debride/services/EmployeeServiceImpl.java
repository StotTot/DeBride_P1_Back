package dev.debride.services;

import dev.debride.daos.EmployeeDAO;
import dev.debride.entities.Employee;

public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;
    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @Override
    public Employee getEmp(String uname) {
        return this.employeeDAO.getEmp(uname);
    }
}
