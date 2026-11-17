package project.firstApplication.empmanagesystem.dtos;

import jakarta.validation.constraints.*;
import project.firstApplication.empmanagesystem.enums.EmployeeStatus;
import java.math.BigDecimal;
import java.time.LocalDate;

public record PatchReqDto(
        @Size(max = 50, message = "First name must not exceed 50 characters")
        String firstName,

        @Size(max = 50, message = "Last name must not exceed 50 characters")
        String lastName,

        @Email(message = "Invalid email format")
        @Size(max = 100, message = "Email must not exceed 100 characters")
        String email,

        @Past(message = "Date of birth must be a past date")
        LocalDate dateOfBirth,

        @PositiveOrZero(message = "Salary must be zero or a positive value")
        BigDecimal salary,

        EmployeeStatus employeeStatus,

        LocalDate joinDate
) {
}
