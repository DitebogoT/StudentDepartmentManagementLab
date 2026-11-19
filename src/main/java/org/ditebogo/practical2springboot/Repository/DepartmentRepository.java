package org.ditebogo.practical2springboot.Repository;

import org.ditebogo.practical2springboot.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository
        extends JpaRepository<Department, Long> {
}
