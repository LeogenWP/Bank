package ru.domrf.demoApl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.domrf.demoApl.model.User;

/*
*  Repository interface for {@llink User} class.
* */
public interface UserRepo extends JpaRepository<User,Integer> {

    User findByUsername(String username);
    User findByEmail(String email);
}
