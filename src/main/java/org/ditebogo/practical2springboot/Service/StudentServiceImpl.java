package org.ditebogo.practical2springboot.Service;

import org.ditebogo.practical2springboot.DTO.StudentRequest;
import org.ditebogo.practical2springboot.DTO.StudentResponse;
import org.ditebogo.practical2springboot.Entity.Department;
import org.ditebogo.practical2springboot.Entity.Student;
import org.ditebogo.practical2springboot.Exceptions.ResourceNotFoundException;
import org.ditebogo.practical2springboot.Repository.DepartmentRepository;
import org.ditebogo.practical2springboot.Repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;

    public StudentServiceImpl(
            StudentRepository studentRepository,
            DepartmentRepository departmentRepository) {

        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    @Transactional
    public StudentResponse create(StudentRequest request) {

        Department department = departmentRepository
                .findById(request.departmentId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Department not found: "
                                        + request.departmentId()
                        ));

        Student student = new Student();

        student.setFirstName(request.firstName());
        student.setLastName(request.lastName());
        student.setEmail(request.email());
        student.setDepartment(department);

        Student saved = studentRepository.save(student);

        return mapToResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentResponse> findAll() {

        return studentRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public StudentResponse findById(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Student not found: " + id
                        ));

        return mapToResponse(student);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentResponse> findByDepartment(
            Long departmentId) {

        if (!departmentRepository.existsById(departmentId)) {
            throw new ResourceNotFoundException(
                    "Department not found: " + departmentId
            );
        }

        return studentRepository
                .findByDepartmentId(departmentId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private StudentResponse mapToResponse(Student student) {

        return new StudentResponse(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getDepartment().getId(),
                student.getDepartment().getName()
        );
    }
}