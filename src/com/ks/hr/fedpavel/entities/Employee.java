package com.ks.hr.fedpavel.entities;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Pavel on 22.06.14.
 */
public class Employee {
    private Integer id;
    private String name;
    private Date birthday;
    private BigDecimal Salary;
    private String passportNumber;
    private Department department;
    private Position position;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public BigDecimal getSalary() {
        return Salary;
    }

    public void setSalary(BigDecimal salary) {
        Salary = salary;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Employee(String name, Date birthday, BigDecimal salary, String passportNumber) {
        this.name = name;
        this.birthday = birthday;
        Salary = salary;
        this.passportNumber = passportNumber;
    }

    public Employee(Integer id, String name, Date birthday, BigDecimal salary, String passportNumber) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        Salary = salary;
        this.passportNumber = passportNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", Salary=" + Salary +
                ", passportNumber='" + passportNumber + '\'' +
                ", department=" + department +
                ", position=" + position +
                '}';
    }
}
