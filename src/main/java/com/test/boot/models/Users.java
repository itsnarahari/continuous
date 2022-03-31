package com.test.boot.models;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter@Getter
public class Users {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
}