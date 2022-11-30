package com.micronautdatapractice.model;

import io.micronaut.core.annotation.Introspected;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Introspected
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @NotBlank
    @Column
    private String name;
    @NotBlank
    @Column
    private String mobile;
    @NotBlank
    @Column
    private String email;
}
