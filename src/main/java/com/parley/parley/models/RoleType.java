package com.parley.parley.models;



import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "roleTypes")
public class RoleType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique = true)
    private String role;



}
