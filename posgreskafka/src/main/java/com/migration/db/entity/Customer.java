package com.migration.db.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "customer")
@Entity
public class Customer {
    
    @Id
    private int pid;
    private String name;
    private String address;
    private String contact;

    public Customer() {}

    public Customer(int pid, String name, String address, String contact) {
        this.pid = pid;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "" + pid;
    }

    public int getPid() {
        return pid;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }
}