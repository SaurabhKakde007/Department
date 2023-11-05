package com.department.department.Service;

import com.department.department.Payload.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    DepartmentDto createDepartment(DepartmentDto departmentDto);

    List<DepartmentDto> getAllDepartment();

    DepartmentDto updateDepartment(DepartmentDto departmentDto , long id);

    void deleteDepartmentById(long id);
}
