package com.mycompany.studentrecordmanagement.model;

import java.sql.Date;

public class Student {
    private int studentId;
    private String fullName;
    private String email;
    private String address;
    private String phoneNumber;
    private Date dateOfBirth;
    private String gender;
    private String degreeProgram;
    private String batchNumber;
    private double gpa;
    private byte[] imageData;

    public Student() {}

    public Student(int studentId, String fullName, String email, String address, 
                   String phoneNumber, Date dateOfBirth, String gender, 
                   String degreeProgram, String batchNumber, double gpa, byte[] imageData) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.degreeProgram = degreeProgram;
        this.batchNumber = batchNumber;
        this.gpa = gpa;
        this.imageData = imageData;
    }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public Date getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getDegreeProgram() { return degreeProgram; }
    public void setDegreeProgram(String degreeProgram) { this.degreeProgram = degreeProgram; }

    public String getBatchNumber() { return batchNumber; }
    public void setBatchNumber(String batchNumber) { this.batchNumber = batchNumber; }

    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }

    public byte[] getImageData() { return imageData; }
    public void setImageData(byte[] imageData) { this.imageData = imageData; }
}