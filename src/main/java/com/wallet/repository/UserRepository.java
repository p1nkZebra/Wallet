package com.wallet.repository;

import com.wallet.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface  UserRepository extends JpaRepository<User, Long> {

}