package com.sivaram.streams;

import java.util.function.Function;

public class StudentMapper implements Function<StudentEntity, StudentDTO> {
    public StudentDTO apply(StudentEntity studentEntity) {
        StudentDTO dto = new StudentDTO();
        dto.setFirstName(studentEntity.getFirstName());
        dto.setLastName(studentEntity.getLastName());
        return dto;
    }
}
