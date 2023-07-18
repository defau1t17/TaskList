package com.example.tasks_list_web_app.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "tasks")
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotEmpty
    @NotBlank
    private String taskName;


    @Enumerated(EnumType.STRING)
    private Priority priority;

    @NotNull
    @NotEmpty
    @NotBlank
    private String description;



}
