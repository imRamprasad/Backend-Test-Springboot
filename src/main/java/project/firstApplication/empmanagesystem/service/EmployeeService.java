package project.firstApplication.empmanagesystem.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import project.firstApplication.empmanagesystem.dtos.PatchReqDto;
import project.firstApplication.empmanagesystem.dtos.RequestDto;
import project.firstApplication.empmanagesystem.dtos.ResponseDto;
import project.firstApplication.empmanagesystem.entity.Employee;
import project.firstApplication.empmanagesystem.exception.EmployeeNotFoundException;
import project.firstApplication.empmanagesystem.mappers.EmployeeMapper;
import project.firstApplication.empmanagesystem.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

   private final EmployeeRepository employeeRepository;
   private final EmployeeMapper  employeeMapper;
    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }
    public ResponseDto addEmployee(RequestDto requestDto) {
       Employee employee= employeeMapper.toEntity(requestDto);
        Employee savedEmployee = employeeRepository.save(employee);
       return employeeMapper.toResponseDtoFull(savedEmployee);
    }

    public List<ResponseDto> getEmployees() {
        List<ResponseDto> responseDtos = new ArrayList<>();
        for (Employee employee : employeeRepository.findAll()) {
            responseDtos.add(employeeMapper.toResponseDtoFull(employee));
        }
        return responseDtos;
    }


    public void updateEmployee(
             UUID uuid,
            RequestDto requestDto) {
        Employee employee = employeeRepository.findById(uuid).orElseThrow(
                ()-> new EmployeeNotFoundException("Employee not found with id "+uuid)
        );
            employeeMapper.fullUpdate(employee,requestDto);
            employeeRepository.save(employee);
    }

    public ResponseDto getByid(UUID uuid) {
        Employee employee = employeeRepository.findById(uuid).orElseThrow(
                ()-> new EmployeeNotFoundException("Employee not found with id "+uuid)
        );
        ResponseDto responseDto=employeeMapper.toResponseDtoFull(employee);
        return responseDto;
    }


    public void patchEmployee(UUID uuid, PatchReqDto patchDto){
        Employee employee = employeeRepository.findById(uuid).orElseThrow(
                ()-> new EmployeeNotFoundException("Employee not found with id "+uuid)
        );
        employeeMapper.patchUpdate(employee,patchDto);
        employeeRepository.save(employee);
    }

    public void deleteById(UUID uuid) {

        Employee employee = employeeRepository.findById(uuid).orElseThrow(
                ()-> new EmployeeNotFoundException("Employee not found with id "+uuid)
        );
        employeeRepository.delete(employee);
    }
}
