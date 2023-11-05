package com.department.department.Controller;

import com.department.department.Payload.DepartmentDto;
import com.department.department.Service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    //http://localhost:8081/api/departments
    @PostMapping
    public ResponseEntity<DepartmentDto>createDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto department = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    //http://localhost:8081/api/departments
    @GetMapping
    public List<DepartmentDto> getAllDepartment(){
        return departmentService.getAllDepartment();
    }

    //http://localhost:8081/api/departments/1
    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDto> updateEmployee(
            @RequestBody DepartmentDto departmentDto ,
            @PathVariable("id") long id
    ){
        DepartmentDto dto1 = departmentService.updateDepartment( departmentDto , id);

        return new ResponseEntity<>(dto1,HttpStatus.OK);
    }

    //http://localhost:8081/api/departments/1
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartmentById(@PathVariable("id") long id){
        departmentService.deleteDepartmentById(id);
        return new ResponseEntity<>("Employee entity deleted",HttpStatus.OK);
    }
    }

