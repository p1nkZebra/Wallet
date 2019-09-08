package com.wallet.web.dto.controller;

import com.wallet.domain.TypeTransaction;
import com.wallet.web.dto.TypeTransactionViewDto;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class TypeTransactionDtoConverter {
    @NotNull
    public TypeTransactionViewDto convertTypeTransactionToTypeTransactionViewDto(@NotNull TypeTransaction typeTransaction) {

        return TypeTransactionViewDto.builder()
                .name(typeTransaction.getName())
                .build();
    }
}
