package org.example.adapters.database;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRepositoryImpl implements UserRepository{
    @Override
    public void save(UserDB userDB) {
        System.out.println("User " + userDB + " has been saved!");
    }

    @Override
    public List<UserDB> findAll() {
        return List.of(new UserDB("Peter", "no1@Domain")
                ,new UserDB("Parker", "die@Domain")
                ,new UserDB("Karl", "please@Domain")
                );
    }
}
