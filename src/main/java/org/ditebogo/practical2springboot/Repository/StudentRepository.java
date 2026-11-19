package org.ditebogo.practical2springboot.Repository;

import org.ditebogo.practical2springboot.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository
        extends JpaRepository<Student, Long> {

    List<Student> findByDepartmentId(Long departmentId);
}