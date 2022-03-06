//package com.java.structural.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Manager implements Employee{
    private String name;
    private double salary;
    private Employee employee;


    public Manager(String name,double salary){
        this.name = name;
        this.salary = salary;

    }


    List <Employee> employees = new ArrayList <Employee>();

    public void add(Employee employee) {

        employees.add(employee);

    }


    public void remove(Employee employee) {

        employee.remove(employee);
    }

    public Employee getSubordinates(List <Employee> employees) {

        return employees.get(List <Employee> employees);

    }

    public String getName() {

        return name;

    }

    public double getSalary() {

        return salary;

    }

    public void print() {

        System.out.println("-------------");

        System.out.println("Name ="+getName());

        System.out.println("Salary ="+getSalary());

        System.out.println("-------------");



        Iterator<Employee> employeeIterator = employees.iterator();

        while(employeeIterator.hasNext()){

            Employee employee = employeeIterator.next();

            employee.print();

        }

    }




}