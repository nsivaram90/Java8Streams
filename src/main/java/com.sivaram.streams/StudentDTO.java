package com.sivaram.streams;

public class StudentDTO {
    String firstName;

    String lastName;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        return "StudentDTO(firstName=" + getFirstName() + ", lastName=" + getLastName() + ")";
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
}
