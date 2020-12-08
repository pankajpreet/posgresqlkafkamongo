package com.migration.datamigration.mongo;

public class Customer {
    public String getId() {
        return pid;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;
  private String pid;
  private String name;
  private String address;
  private String contact;

  public Customer() {}

  public Customer(String id, String pid, String name, String address, String contact) {
      this.id = id;
    this.pid = pid;
    this.name = name;
    this.address = address;
    this.contact = contact;
  }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
        this.id = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}