package com.test.boot.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
