package com.test.praveen;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class EmployeeResp {
    private int id;
    private String name;
    private Integer salary;
    private Long deptId;
}
