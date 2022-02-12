package com.burrows.springSecurityTutorial.model;

import javax.persistence.*;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotNull
    @Column
    String username;

    @NotNull
    @Column
    String password;

    @NotNull
    @Column
    String email;

    @Column
    @NotNull
    String role;
}