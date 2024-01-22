package com.accounting.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="users")
public class User extends BaseEntity{


    @Column(unique = true,nullable = false)
    private String username;

    private boolean enabled;
    private String firstname;
    private String lastname;
    @Column(nullable = false)
    private String password;
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;
    @ManyToOne(fetch = FetchType.LAZY)
    private Role role;



}
