package com.tobeto.spring.workshop.b.service.concretes;

import com.tobeto.spring.workshop.b.module.Product;
import com.tobeto.spring.workshop.b.module.User;
import com.tobeto.spring.workshop.b.repository.abstracts.UserRepository;
import com.tobeto.spring.workshop.b.service.Rules.utilities.IUserBusinesRules;
import com.tobeto.spring.workshop.b.service.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserManager implements UserService {
  public final   UserRepository users;
  public final IUserBusinesRules iUserBusinesRules;
@Autowired
    public UserManager(UserRepository users, IUserBusinesRules iUserBusinesRules) {
        this.users = users;
        this.iUserBusinesRules = iUserBusinesRules;
    }

    @Override
    public List<User> getall() {
        return users.getall();
    }

    @Override
    public User getById(int id) {

    this.iUserBusinesRules.ifCheckUserId(id);
        return users.getById(id);
    }

    @Override
    public String add(User user) {
    this.iUserBusinesRules.ifCheckUserId(user.getId());
    this.iUserBusinesRules.ifCheckUserName(user.getName());
    this.iUserBusinesRules.ifCheckUserEmail(user.getEmail());
        return users.add(user);
    }

    @Override
    public String delete(int id) {

    this.iUserBusinesRules.ifCheckDeleteUser(id);
        return users.delete(id);
    }

    @Override
    public String updateProduct(int id, User updatedUser) {
    this.iUserBusinesRules.ifCheckDeleteUser(id);
    this.iUserBusinesRules.ifCheckUserEmail(updatedUser.getEmail());
        return users.updateUser(id,updatedUser);
    }
}
