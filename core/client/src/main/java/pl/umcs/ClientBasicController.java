package pl.umcs;

import com.netflix.discovery.EurekaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.umcs.datatypes.Assignment;
import pl.umcs.datatypes.Employee;
import pl.umcs.datatypes.Holiday;
import pl.umcs.services.EmployeeService;

import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/service")
public class ClientBasicController
{
    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;

    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);
    private EmployeeService employeeService;

    @Autowired
    public ClientBasicController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String getHello() {
        return "Hello. This is the Client speaking.";
    }

    @GetMapping("/name")
    public String greeting() {
        return String.format("Hello from '%s'!",
                eurekaClient.getApplication(appName).getName());
    }
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Employee> getUsers() {
        List<Employee> employees = employeeService.findAll();

        log.info("Retrieve objects {}", employees);

        return employees;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public Employee save(@RequestBody Employee user) {
        Employee savedEmployee = employeeService.save(user);

        log.info("Add Employee {}", savedEmployee);

        return savedEmployee;
    }

    @GetMapping("/{id}")
    public Employee find(@PathVariable Long id) {
        return employeeService.find(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);

        log.info("Delete Employee with id {}", id);

        return new ResponseEntity(NO_CONTENT);
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public Employee update(@RequestBody Employee user) {
        Employee updatedEmployee = employeeService.update(user);

        log.info("Updated Employee {}", updatedEmployee);

        return updatedEmployee;
    }

    @PostMapping("/holiday")
    public String requestHoliday(@RequestBody Holiday request) {
        Employee requestingEmployee = employeeService.find(request.getEmployee().getId());
        if (null != requestingEmployee) {
            List<Holiday> holidays = requestingEmployee.getHolidayList();
            holidays.add(request);
            requestingEmployee.setHolidayList(holidays);
            log.info("Added holiday " + request.getId() + " to employee: " + requestingEmployee.getId());
            return "Holiday requested";
        }
        else
        {
            log.info("Bad request. Employee: " + request.getEmployee().getId() + "not found.");
        }
        return "Employee not found";
    }
    /*
    @PostMapping
    public String logWork(@RequestBody Assignment assignment) {
        Employee requestingEmployee = employeeService.find(assignment.getEmployee().getId());
        if (null != requestingEmployee) {
            List<Assignment> assignments = requestingEmployee.getAssignmentList();
            assignments.add(assignment);
            requestingEmployee.setAssignmentList(assignments);
            log.info("Added work log " + assignment.getId() + " to employee: " + requestingEmployee.getId());
            return "Added work log";
        }
        else
        {
            log.info("Bad request. Employee: " + assignment.getEmployee().getId() + "not found.");
        }
        return "Employee not found";
    }*/

    @GetMapping("/fill")
    public String fillWithData() {
        Employee Steve = new Employee();
        Steve.setFirstName("Steve");
        Steve.setLastName("Brodnicki");
        Steve.setAssignedDeskNumber(4);
        employeeService.save(Steve);

        Employee Joanna = new Employee();
        Joanna.setFirstName("Joanna");
        Joanna.setLastName("Stone");
        Joanna.setAssignedDeskNumber(7);
        employeeService.save(Joanna);
        return "Created some users.";
    }
}
