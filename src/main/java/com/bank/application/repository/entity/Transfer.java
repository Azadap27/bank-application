package com.bank.application.repository.entity;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Transfer {
    private Long senderAccount;

    private Long receiverAccount;

    private Long amount;
}
