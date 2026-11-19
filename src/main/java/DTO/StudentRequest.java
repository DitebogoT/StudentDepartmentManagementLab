package DTO;

public record StudentRequest(
        String firstName,
        String lastName,
        String email,
        Long departmentId
) {}
