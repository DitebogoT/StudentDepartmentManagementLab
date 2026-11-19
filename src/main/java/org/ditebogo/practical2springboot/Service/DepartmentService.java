package org.ditebogo.practical2springboot.Service;

import org.ditebogo.practical2springboot.DTO.DepartmentRequest;
import org.ditebogo.practical2springboot.DTO.DepartmentResponse;

import java.util.List;

public interface DepartmentService {

    DepartmentResponse create(DepartmentRequest request);

    List<DepartmentResponse> findAll();

    DepartmentResponse findById(Long id);
}
