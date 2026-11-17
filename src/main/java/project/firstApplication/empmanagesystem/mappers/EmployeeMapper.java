package project.firstApplication.empmanagesystem.mappers;

import org.springframework.stereotype.Component;
import project.firstApplication.empmanagesystem.dtos.PatchReqDto;
import project.firstApplication.empmanagesystem.dtos.RequestDto;
import project.firstApplication.empmanagesystem.dtos.ResponseDto;
import project.firstApplication.empmanagesystem.entity.Employee;

import java.util.UUID;

@Component
public class EmployeeMapper {

    public Employee toEntity(RequestDto requestDto) {
        Employee employee = new Employee();
        employee.setFirstName(requestDto.firstName());
        employee.setLastName(requestDto.lastName());
        employee.setEmail(requestDto.email());
        employee.setDateOfBirth(requestDto.dateOfBirth());
        employee.setSalary(requestDto.salary());
        employee.setEmployeeStatus(requestDto.employeeStatus());
        employee.setJoinDate(requestDto.joinDate());
        return employee;
    }


    public ResponseDto toResponseDtoFull(Employee employee) {
       return new ResponseDto(
            employee.getId(),
            employee.getFirstName(),
               employee.getLastName(),
               employee.getEmail(),
               employee.getDateOfBirth(),
               employee.getAge(),
               employee.getSalary(),
               employee.getEmployeeStatus(),
               employee.getJoinDate(),
               employee.getCreatedAt(),
               employee.getUpdatedAt()
        );
    }



    public void fullUpdate(Employee employee, RequestDto requestDto) {
        employee.setFirstName(requestDto.firstName());
        employee.setLastName(requestDto.lastName());
        employee.setEmail(requestDto.email());
        employee.setDateOfBirth(requestDto.dateOfBirth());
        employee.setSalary(requestDto.salary());
        employee.setEmployeeStatus(requestDto.employeeStatus());
        employee.setJoinDate(requestDto.joinDate());

    }

    public void patchUpdate(Employee employee, PatchReqDto dto) {
        if(dto==null) {
            return;
        }
        if (dto.firstName() != null && !dto.firstName().isBlank()) {
            employee.setFirstName(dto.firstName());
        }
        if (dto.lastName() != null && !dto.lastName().isBlank()) {
            employee.setLastName(dto.lastName());
        }
        if (dto.email() != null && !dto.email().isBlank()) {
            employee.setEmail(dto.email());
        }
        if (dto.dateOfBirth() != null) {
            employee.setDateOfBirth(dto.dateOfBirth());
        }
        if (dto.salary() != null) {
            employee.setSalary(dto.salary());
        }
        if (dto.employeeStatus() != null) {
            employee.setEmployeeStatus(dto.employeeStatus());
        }
        if (dto.joinDate() != null) {
            employee.setJoinDate(dto.joinDate());
        }
    }
}
