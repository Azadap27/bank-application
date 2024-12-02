package com.bank.application.repository.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "account")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Account {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @OneToOne
        private Person person;
        private Long balance;
}
