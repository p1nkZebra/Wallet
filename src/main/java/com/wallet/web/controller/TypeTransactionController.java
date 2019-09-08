package com.wallet.web.controller;

import com.wallet.domain.TypeTransaction;
import com.wallet.logic.service.TypeTransactionService;
import com.wallet.web.dto.TypeTransactionViewDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("wallet")
public class TypeTransactionController {

    @Autowired
    private TypeTransactionService typeTransactionService;

    @ResponseBody
    @GetMapping(value = "/get-typeTransaction-view")
    public ResponseEntity<List<TypeTransactionViewDto>> getTypeTransactionView() {
        log.info("Start get-typeTransaction-view.");

        List<TypeTransactionViewDto> typeTransactionViewDtos = typeTransactionService.getAllTypeTransactionViewDtos();

        return ResponseEntity.ok(typeTransactionViewDtos);
    }
}
