package com.example.lab15to17;

public class Student {
    private String rollNo;
    private  String name;
    private  String address;
    public Student(String rollNo, String name, String address){
        this.rollNo =  rollNo;
        this.name = name;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }
    @Override
    public String toString() {
        return "Roll No: " + rollNo + "\nName: " + name + "\nAddress: " + address;
    }
}
