package project.firstApplication.empmanagesystem.dtos;

import project.firstApplication.empmanagesystem.enums.EmployeeStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record ResponseDto(

        UUID id,

        String firstName,

        String lastName,

        String email,

        LocalDate dateOfBirth,

        Integer age,

        BigDecimal salary,

        EmployeeStatus employeeStatus,

        LocalDate joinDate,

        LocalDateTime createdAt,

        LocalDateTime updatedAt
) {

}
