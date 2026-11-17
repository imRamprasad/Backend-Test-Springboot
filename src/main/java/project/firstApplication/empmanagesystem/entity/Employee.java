
package project.firstApplication.empmanagesystem.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import project.firstApplication.empmanagesystem.enums.EmployeeStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.UUID;

@Entity
@Table(name = "company_employee")
@Getter
@Setter
@JsonPropertyOrder({
        "id", "firstName", "lastName", "email", "dateOfBirth", "age",
        "salary", "employeeStatus", "joinDate", "createdAt", "updatedAt"
})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "salary", precision = 12, scale = 2)
    private BigDecimal salary;

    @Enumerated(EnumType.STRING)
    @Column(name = "employee_status", nullable = false, length = 20)
    private EmployeeStatus employeeStatus = EmployeeStatus.ACTIVE;

    @Column(name = "join_date", nullable = false)
    private LocalDate joinDate;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Transient
    public Integer getAge() {
        if (dateOfBirth == null) {
            return null;
        }

        return Period.between(
                dateOfBirth,
                LocalDate.now()
        ).getYears();
    }
}
