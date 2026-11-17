package project.firstApplication.empmanagesystem.dtos;

import jakarta.validation.constraints.*;
import project.firstApplication.empmanagesystem.enums.EmployeeStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public record RequestDto(
        @NotBlank(message = "First name cannot be blank")
        @Size(max = 50, message = "First name must not exceed 50 characters")
        String firstName,

        @NotBlank(message = "Last name cannot be blank")
        @Size(max = 50, message = "Last name must not exceed 50 characters")
        String lastName,

        @NotBlank(message = "Email cannot be blank")
        @Email(message = "Invalid email format")
        @Size(max = 100, message = "Email must not exceed 100 characters")
        String email,

        @NotNull(message = "Date of birth is required")
        @Past(message = "Date of birth must be a past date")
        LocalDate dateOfBirth,

        @NotNull(message = "Salary is required")
        @PositiveOrZero(message = "Salary must be zero or a positive value")
        BigDecimal salary,

        @NotNull(message = "Employee status is required")
        EmployeeStatus employeeStatus,

        @NotNull(message = "Join date is required")
        LocalDate joinDate
) {
}
