package com.department.department.Service.Impl;

import com.department.department.Entity.Department;
import com.department.department.Exception.ResourceNotFoundException;
import com.department.department.Payload.DepartmentDto;
import com.department.department.Repository.DepartmentRepository;
import com.department.department.Service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {

        Department department = mapToEntity(departmentDto);

        Department newDepartment = departmentRepository.save(department);

        DepartmentDto x = mapToDTO(newDepartment);
        return x;
    }

    @Override
    public List<DepartmentDto> getAllDepartment() {
            List<Department> all = departmentRepository.findAll();
            return all.stream().map(employee -> mapToDTO(employee)).collect(Collectors.toList());
        }

    @Override
    public DepartmentDto updateDepartment( DepartmentDto departmentDto , long id) {

        Department department = departmentRepository.findById(String.valueOf(id)).orElseThrow(() -> new ResourceNotFoundException("Department", "id",id));

        department.setDepartmentId(departmentDto.getDepartmentId());
        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setCreatedAt(departmentDto.getCreatedAt());
        department.setUpdatedAt(departmentDto.getUpdatedAt());

        Department update = departmentRepository.save(department);

        return mapToDTO(update);
    }

    @Override
    public void deleteDepartmentById(long id) {
        Department department = departmentRepository.findById(String.valueOf(id)).orElseThrow(() -> new ResourceNotFoundException("Department", "id", id));
        departmentRepository.delete(department);
    }


    private DepartmentDto mapToDTO(Department department){
        DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setDepartmentId(department.getDepartmentId());
        departmentDto.setDepartmentName(department.getDepartmentName());
        departmentDto.setCreatedAt(department.getCreatedAt());
        departmentDto.setUpdatedAt(department.getUpdatedAt());
        return departmentDto;
    }

    private Department mapToEntity(DepartmentDto departmentDto){
        Department department = new Department();

        department.setDepartmentId(departmentDto.getDepartmentId());
        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setCreatedAt(departmentDto.getCreatedAt());
        department.setUpdatedAt(departmentDto.getUpdatedAt());
        return department;
    }
}

