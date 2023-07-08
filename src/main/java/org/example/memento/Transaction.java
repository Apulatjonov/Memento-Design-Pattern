package org.example.memento;

import org.example.data.User;
import org.example.originator.Database;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by: Abdulaziz Pulatjonov
 * Date: 7/7/2023 10:17
 */

public class Transaction {
    private Database database;

    public Transaction(Database database) {
        this.database = database;
    }

    public void save(List<User> users){
        this.database.save(users);
    }

    public Optional<List<User>> read(){
        return this.database.read();
    }

}
