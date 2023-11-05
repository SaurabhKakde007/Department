package com.department.department.Payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import java.sql.Timestamp;

@Data
public class DepartmentDto {

    private String departmentId;

    private String departmentName;

    private Timestamp createdAt;

    private Timestamp updatedAt;

}
