package com.wallet.web.controller;

import com.wallet.logic.service.UserService;
import com.wallet.web.dto.UserViewDto;
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
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping(value = "/get-user-view")
    public ResponseEntity<List<UserViewDto>> getUserView() {
        log.info("Start get-user-view.");

        List<UserViewDto> userViewDtos = userService.getAllUserViewDtos();

        return ResponseEntity.ok(userViewDtos);
    }
}
