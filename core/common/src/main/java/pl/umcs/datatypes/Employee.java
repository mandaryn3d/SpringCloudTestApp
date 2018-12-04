package pl.umcs.datatypes;

import com.google.common.collect.Lists;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;


@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private Integer assignedDeskNumber;

    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Holiday> holidayList = Lists.newArrayList();

    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Assignment> assignmentList = Lists.newArrayList();

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAssignedDeskNumber() {
        return assignedDeskNumber;
    }

    public void setAssignedDeskNumber(Integer assignedDeskNumber) {
        this.assignedDeskNumber = assignedDeskNumber;
    }

    public List<Holiday> getHolidayList() {
        return holidayList;
    }

    public void setHolidayList(List<Holiday> holidayList) {
        this.holidayList = holidayList;
    }

    public List<Assignment> getAssignmentList() {
        return assignmentList;
    }

    public void setAssignmentList(List<Assignment> assignmentList) {
        this.assignmentList = assignmentList;
    }
}
