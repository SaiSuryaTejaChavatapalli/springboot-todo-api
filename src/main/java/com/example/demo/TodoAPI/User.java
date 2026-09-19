package com.example.demo.TodoAPI;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="users")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE )
    @Column(nullable = false)
    private Long id;


    @Column(nullable = false)
    private  String name;

    @Column(nullable = false, unique = true)
    private String email;
}
