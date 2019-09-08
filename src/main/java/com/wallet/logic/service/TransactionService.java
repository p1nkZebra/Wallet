package com.wallet.logic.service;

import com.wallet.domain.Transaction;
import com.wallet.repository.TransactionRepository;
import com.wallet.repository.TypeTransactionRepository;
import com.wallet.repository.UserRepository;
import com.wallet.web.dto.TransactionViewDto;
import com.wallet.web.dto.controller.TransactionDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService{
        @Autowired
        private UserRepository userRepository;
        @Autowired
        private TypeTransactionRepository typeTransactionRepository;
        @Autowired
        private TransactionRepository transactionRepository;
    @Autowired
    private TransactionDtoConverter converter;

    @NotNull
    public List<TransactionViewDto> getAllEventViewDtos() {
        List<TransactionViewDto> resultList = new ArrayList<>();

        List<Transaction> transactionList = transactionRepository.findAll();
        for ( Transaction transaction : transactionList ) {
            resultList.add(converter.convertTransactionToTransactionViewDto(transaction));
        }

        return resultList;
    }
}
