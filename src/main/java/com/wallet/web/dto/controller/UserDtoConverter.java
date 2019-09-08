package com.wallet.web.dto.controller;

import com.wallet.domain.User;
import com.wallet.web.dto.UserViewDto;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class UserDtoConverter {
    @NotNull
    public UserViewDto convertUserToUserViewDto(@NotNull User user) {

        return UserViewDto.builder()
                .name(user.getName())
                .build();
    }
}
