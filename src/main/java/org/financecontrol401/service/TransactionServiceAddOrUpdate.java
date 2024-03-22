package org.financecontrol401.service;

import org.financecontrol401.dto.ClientRequestTransaction;
import org.financecontrol401.dto.ClientResponse;
import org.financecontrol401.entity.Category;
import org.financecontrol401.entity.Transaction;
import org.financecontrol401.entity.TransactionType;
import org.financecontrol401.repository.InterfaceRepository;
import org.financecontrol401.repository.TransactionRepository;
import org.financecontrol401.service.validation.ValidationRequest;

import java.time.LocalDate;
///--------------------
public class TransactionServiceAddOrUpdate {
    private  TransactionRepository repository;
    private  ValidationRequest validationRequest;

    public TransactionServiceAddOrUpdate(TransactionRepository repository, ValidationRequest validationRequest) {
        this.repository = repository;
        this.validationRequest = validationRequest;
    }

    public ClientResponse<Transaction> add(ClientRequestTransaction request){

       // validationRequest.checkRequest(request);
        Transaction transactionForAdd = new Transaction(request.getType(),
                request.getCategory(),
                request.getAmount(), request.getDescription(),request.getDate());


        repository.add(transactionForAdd );

        if (transactionForAdd .getIdTransaction() > 0) {
            return new ClientResponse<>(200, transactionForAdd, "Добавление новой Транзакции прошло успешно");
        } else {
            return new ClientResponse<>(400,
                    new Transaction(), "Новая задача не добавлена!");

        }
    }




}
