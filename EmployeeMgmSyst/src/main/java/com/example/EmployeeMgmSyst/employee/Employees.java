package com.example.EmployeeMgmSyst.employee;

public class Employees {

    private Long id;
    private String name;
    private String contact;
    private String jobTitle;
    private String department;
    private int salary;

    public Employees() {

    }

    public Employees(Long id, String name, String contact, String jobTitle, String department, int salary) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.jobTitle = jobTitle;
        this.department = department;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
