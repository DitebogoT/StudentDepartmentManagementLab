package org.ditebogo.practical2springboot.Service;

import org.ditebogo.practical2springboot.DTO.StudentRequest;
import org.ditebogo.practical2springboot.DTO.StudentResponse;

import java.util.List;

public interface StudentService {

    StudentResponse create(StudentRequest request);

    List<StudentResponse> findAll();

    StudentResponse findById(Long id);

    List<StudentResponse> findByDepartment(Long departmentId);
}