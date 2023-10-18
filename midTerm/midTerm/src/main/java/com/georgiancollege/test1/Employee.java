package com.georgiancollege.test1;

import java.util.Arrays;
import java.util.List;

public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String province;
    private String phoneNo;

    private static final List<String> VALID_PROVINCES = Arrays.asList(
            "AB", "BC", "MB", "NB", "NL", "NS", "NT", "NU", "ON", "PE", "QC", "SK", "YT"
    );

    public Employee(int employeeId, String firstName, String lastName, String address, String city, String province, String phoneNo) {
        validateEmployeeId(employeeId);
        validateName(firstName, "First name");
        validateName(lastName, "Last name");
        validateAddress(address);
        validateCity(city);
        validateProvince(province);
        validatePhoneNo(phoneNo);

        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.province = province;
        this.phoneNo = phoneNo;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        validateEmployeeId(employeeId);
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        validateName(firstName, "First name");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        validateName(lastName, "Last name");
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        validateAddress(address);
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        validateCity(city);
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        validateProvince(province);
        this.province = province;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        validatePhoneNo(phoneNo);
        this.phoneNo = phoneNo;
    }

    private void validateEmployeeId(int employeeId) {
        if (employeeId <= 200465000) {
            throw new IllegalArgumentException("Employee ID should be greater than 200465000.");
        }
    }

    private void validateName(String name, String fieldName) {
        if (name.length() < 2) {
            throw new IllegalArgumentException(fieldName + " should be more than 1 character.");
        }
    }

    private void validateAddress(String address) {
        if (address.length() < 6) {
            throw new IllegalArgumentException("Address should be more than 5 characters.");
        }
    }

    private void validateCity(String city) {
        if (city.length() < 4) {
            throw new IllegalArgumentException("City should be more than 3 characters.");
        }
    }

    private void validateProvince(String province) {
        if (!VALID_PROVINCES.contains(province)) {
            throw new IllegalArgumentException("Invalid province. Province should be one of: AB, BC, MB, NB, NL, NS, NT, NU, ON, PE, QC, SK, YT");
        }
    }

    private void validatePhoneNo(String phoneNo) {
        // You can add phone number validation logic based on the North American dialing plan here.
        // For simplicity, I'm not implementing phone number validation in this example.
    }
}
