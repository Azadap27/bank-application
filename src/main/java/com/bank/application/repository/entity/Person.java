package com.bank.application.repository.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "person")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Person {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "first_name")
        private String firstName;
        @Column(name = "last_name")
        private String lastName;
        private String email;
        private String password;
        @Column(name = "phone_number")
        private String phoneNumber;
}
