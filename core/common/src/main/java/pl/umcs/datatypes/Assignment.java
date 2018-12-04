package pl.umcs.datatypes;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Assignment {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private Integer taskId;

    private Integer manHours;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Long getId() {
        return id;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getManHours() {
        return manHours;
    }

    public void setManHours(Integer manHours) {
        this.manHours = manHours;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
