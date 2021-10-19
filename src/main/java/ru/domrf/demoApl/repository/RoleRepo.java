package ru.domrf.demoApl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.domrf.demoApl.model.Role;

/*
 *  Repository interface for {@llink Role} class.
 * */
public interface RoleRepo extends JpaRepository<Role,Integer> {
    Role findByName(String name);
}
