package com.wallet.web.dto.controller;

import com.wallet.domain.Transaction;
import com.wallet.domain.TypeTransaction;
import com.wallet.domain.User;
import com.wallet.repository.TypeTransactionRepository;
import com.wallet.repository.UserRepository;
import com.wallet.web.dto.TransactionViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class TransactionDtoConverter {

    private static final String DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static final String DATE_FORMAT = "MM.dd.yyyy";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TypeTransactionRepository typeTransactionRepository;

    @NotNull
    public TransactionViewDto convertTransactionToTransactionViewDto(@NotNull Transaction transaction) {
        User user = userRepository.findById(transaction.getUser_id())
                .orElseThrow(() -> new RuntimeException("Error. User not found."));
        TypeTransaction typeTransaction = typeTransactionRepository.findById(transaction.getTransaction_id())
                .orElseThrow(() -> new RuntimeException("Error. TypeTransaction not found"));

        String transactionDateStringFormat = convertLocalDateToString(transaction.getDate_time());

        return TransactionViewDto.builder()
                .userName(user.getName())
                .typeTransactionName(typeTransaction.getName())
                .date(transactionDateStringFormat)
                .comment(transaction.getComment())
                .build();
    }
    private String convertLocalDateToString(LocalDate eventDate) {
        return eventDate != null ? eventDate.format(DateTimeFormatter.ofPattern(DATE_FORMAT)) : null;
    }
}
