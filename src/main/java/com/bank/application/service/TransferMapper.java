package com.bank.application.service;

import com.bank.application.repository.entity.Transfer;
import com.bank.model.TransferRequest;
import com.bank.model.TransferResponse;

import java.util.UUID;

public class TransferMapper {

    public static TransferResponse mapToTransferResponse(Transfer transfer, TransferResponse transferResponse){
        transferResponse.setSenderAccount(transfer.getSenderAccount());
        transferResponse.setReceiverAccount(transfer.getReceiverAccount());
        transferResponse.setAmount(transfer.getAmount());

        return transferResponse;
    }

    public static Transfer mapToTransferEntity(TransferRequest transferRequest, Transfer transfer){
        transfer.setSenderAccount(transferRequest.getSenderAccount());
        transfer.setReceiverAccount(transferRequest.getReceiverAccount());
        transfer.setAmount(transferRequest.getAmount());

        return transfer;
    }

    public static TransferResponse mapToTransferResponse11(TransferRequest transferRequest, TransferResponse transferResponse){
        transferResponse.setTransactionId(UUID.randomUUID().timestamp());
        transferResponse.setSenderAccount(transferRequest.getSenderAccount());
        transferResponse.setReceiverAccount(transferRequest.getReceiverAccount());
        transferResponse.setAmount(transferRequest.getAmount());

        return transferResponse;
    }
}
