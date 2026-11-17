package project.firstApplication.empmanagesystem.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.firstApplication.empmanagesystem.dtos.PatchReqDto;
import project.firstApplication.empmanagesystem.dtos.RequestDto;
import project.firstApplication.empmanagesystem.dtos.ResponseDto;
import project.firstApplication.empmanagesystem.service.EmployeeService;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/v1/employees") // Pluralized root path
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // URL: POST http://localhost:8081/api/v1/employees
    @PostMapping
    public ResponseEntity<ResponseDto> addEmployee(
            @Valid @RequestBody RequestDto requestDto) {
        ResponseDto responseDto = employeeService.addEmployee(requestDto);
        return ResponseEntity.created(URI.create("/api/v1/employees/" + responseDto.id())).body(responseDto);
    }

    // URL: GET http://localhost:8081/api/v1/employees
    @GetMapping
    public ResponseEntity<List<ResponseDto>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getEmployees());
    }

    // URL: GET http://localhost:8081/api/v1/employees/b9db36cc-310a-4feb-b562-3ebf27f2d180
    @GetMapping("{id}")
    public ResponseEntity<ResponseDto> getEmployee(
            @PathVariable("id") UUID uuid
    ){
        return ResponseEntity.ok(employeeService.getByid(uuid));
    }

    // URL: PUT http://localhost:8081/api/v1/employees/b9db36cc-310a-4feb-b562-3ebf27f2d180
    @PutMapping("{id}")
    public ResponseEntity<Void> updateEmployee(
            @PathVariable("id") UUID uuid,
            @Valid @RequestBody RequestDto requestDto
    ){
        employeeService.updateEmployee(uuid, requestDto);
        return ResponseEntity.ok().build();
    }

    // URL: PATCH http://localhost:8081/api/v1/employees/b9db36cc-310a-4feb-b562-3ebf27f2d180
    @PatchMapping("{id}")
    public ResponseEntity<Void> patchEmployee(
            @PathVariable("id") UUID uuid,
            @Valid @RequestBody PatchReqDto patchRequestDto
    ){
        employeeService.patchEmployee(uuid, patchRequestDto);
        return ResponseEntity.ok().build();
    }

    // URL: DELETE http://localhost:8081/api/v1/employees/b9db36cc-310a-4feb-b562-3ebf27f2d180
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteEmployee(
            @PathVariable("id") UUID uuid
    ){
        employeeService.deleteById(uuid);
        return ResponseEntity.noContent().build(); // Standard 204 response
    }
}
