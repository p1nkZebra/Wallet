package com.wallet.logic.service;

import com.wallet.domain.User;
import com.wallet.repository.UserRepository;
import com.wallet.web.dto.UserViewDto;
import com.wallet.web.dto.controller.UserDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDtoConverter converter;

    @NotNull
    public List<UserViewDto> getAllUserViewDtos() {
        List<UserViewDto> resultList = new ArrayList<>();

        List<User> userList = userRepository.findAll();
        for ( User user : userList ) {
            resultList.add(converter.convertUserToUserViewDto(user));
        }

        return resultList;
    }

}
