package pl.umcs.services;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.umcs.datatypes.Employee;
import pl.umcs.repositories.EmployeeFakeRepository;
import pl.umcs.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    //@Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);

        logMessage(savedEmployee.getId(), "Successfull employee Saved");

        return savedEmployee;
    }

    public List<Employee> findAll() {
        Iterable<Employee> employeesIterable = employeeRepository.findAll();
        List<Employee> employees = Lists.newArrayList(employeesIterable);

        return employees;
    }

    public Employee find(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }

    public Employee update(Employee employee) {
        Employee updatedEmployee = employeeRepository.save(employee);

        logMessage(updatedEmployee.getId(), "Successfull employee Update");

        return updatedEmployee;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);

        logMessage(id, "Successfull employee Delete");
    }

    private void logMessage( Long id, String message) {

        System.out.println("Id: " + id + " " + message);
    }
}
