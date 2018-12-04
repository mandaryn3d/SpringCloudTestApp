package pl.umcs.repositories;

import com.google.common.collect.Lists;
import pl.umcs.datatypes.Employee;

import java.util.List;

public class EmployeeFakeRepository {

    private List<Employee> list = Lists.newArrayList();


    public Employee save(Employee newEmployee){
        list.add(newEmployee);
        return newEmployee;
    }
    public List<Employee> findAll() {
        return list;
    }
    public Employee findById(Long id) {
        Employee found = list.stream()
                .filter(employee -> id.equals(employee.getId()))
                .findAny()
                .orElse(null);
        return found;
    }
    public void deleteById(Long id) {
        Employee found = list.stream()
                .filter(employee -> id.equals(employee.getId()))
                .findAny()
                .orElse(null);
        list.remove(found);
    }
}
