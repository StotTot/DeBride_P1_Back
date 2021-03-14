package dev.debride.daos;

import dev.debride.entities.Employee;

import java.util.List;

public interface EmployeeDAO {

    // READ
    Employee getEmp(String uname);

}
