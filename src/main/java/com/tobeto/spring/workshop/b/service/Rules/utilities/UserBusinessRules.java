package com.tobeto.spring.workshop.b.service.Rules.utilities;

import com.tobeto.spring.workshop.b.module.User;
import com.tobeto.spring.workshop.b.repository.abstracts.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserBusinessRules implements IUserBusinesRules {

    public  final UserRepository USER_REPOSITORY;
    @Override
    public void ifCheckUserId(int identity) {

        Optional<User> user = this.USER_REPOSITORY.getall().stream().filter(u -> u.getId() == identity).findFirst();
            if (user.isPresent()) {
                throw new IllegalArgumentException("User already exists");
            }

    }

    @Override
    public void ifCheckUserName(String userName) {
        Optional<User> user = this.USER_REPOSITORY.getall().stream().filter(u -> u.getName().equals(userName)).findFirst();
        if (user.isPresent()) {
            throw new IllegalArgumentException("User already exists");
        }

    }

    @Override
    public void ifCheckUserEmail(String userEmail) {
        Optional<User> user = this.USER_REPOSITORY.getall().stream().filter(u -> u.getEmail().equals(userEmail)).findFirst();
        if (user.isPresent()) {
            throw new IllegalArgumentException("There are user with this mail.");
        }

    }

    @Override
    public void ifCheckDeleteUser(int identity) {
        Optional<User> user = this.USER_REPOSITORY.getall().stream().filter(u -> u.getId() == identity).findFirst();
        if (!user.isPresent()) {
            throw new IllegalArgumentException("User Not Found !");
        }

    }
}
