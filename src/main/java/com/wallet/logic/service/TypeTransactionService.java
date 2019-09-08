package com.wallet.logic.service;

import com.wallet.domain.TypeTransaction;
import com.wallet.repository.TypeTransactionRepository;
import com.wallet.web.dto.TypeTransactionViewDto;
import com.wallet.web.dto.controller.TypeTransactionDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Service
public class TypeTransactionService {

    @Autowired
    private TypeTransactionRepository typeTransactionRepository;

    @Autowired
    private TypeTransactionDtoConverter converter;

    @NotNull
    public List<TypeTransactionViewDto> getAllTypeTransactionViewDtos() {
        List<TypeTransactionViewDto> resultList = new ArrayList<>();

        List<TypeTransaction> typeTransactionList = typeTransactionRepository.findAll();
        for ( TypeTransaction typeTransaction : typeTransactionList ) {
            resultList.add(converter.convertTypeTransactionToTypeTransactionViewDto(typeTransaction));
        }
        return resultList;
    }
}
