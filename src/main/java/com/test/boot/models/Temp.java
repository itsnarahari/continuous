package com.test.boot.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Temp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String temp;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
