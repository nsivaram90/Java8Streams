package com.sivaram.streams;

public class StudentEntity {
    String firstName;

    String lastName;

    Integer age;

    String internalFields;

    String someOtherFields;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setInternalFields(String internalFields) {
        this.internalFields = internalFields;
    }

    public void setSomeOtherFields(String someOtherFields) {
        this.someOtherFields = someOtherFields;
    }

    public StudentEntity(String firstName, String lastName, Integer age, String internalFields, String someOtherFields) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.internalFields = internalFields;
        this.someOtherFields = someOtherFields;
    }

    public String toString() {
        return "StudentEntity(firstName=" + getFirstName() + ", lastName=" + getLastName() + ", age=" + getAge() + ", internalFields=" + getInternalFields() + ", someOtherFields=" + getSomeOtherFields() + ")";
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Integer getAge() {
        return this.age;
    }

    public String getInternalFields() {
        return this.internalFields;
    }

    public String getSomeOtherFields() {
        return this.someOtherFields;
    }
}
