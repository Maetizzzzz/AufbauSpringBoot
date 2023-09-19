package org.example.adapters.database;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

    void save(UserDB userDB);

    List<UserDB> findAll();
}

