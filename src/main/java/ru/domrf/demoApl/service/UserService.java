package ru.domrf.demoApl.service;

import ru.domrf.demoApl.model.Role;
import ru.domrf.demoApl.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username,String roleNAme);
    User getUser(String username);
    List<User> getUsers();
}
