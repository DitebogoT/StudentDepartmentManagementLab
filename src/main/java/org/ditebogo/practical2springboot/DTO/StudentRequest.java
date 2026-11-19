package org.ditebogo.practical2springboot.DTO;

public record StudentRequest(
        String firstName,
        String lastName,
        String email,
        Long departmentId
) {}
