package org.example.caretaker;

import org.example.data.User;
import org.example.memento.Transaction;
import org.example.originator.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by: Abdulaziz Pulatjonov
 * Date: 7/7/2023 10:18
 */

public class Connection {
    private Transaction transaction;
    private List<User> users;

    public Connection(){
        this.users = new ArrayList<>();
        this.transaction = new Transaction(new Database());
    }

    public void save() {
        this.transaction.save(new ArrayList<>(this.users));
    }

    public void rollback() {
        this.users = new ArrayList<>(this.transaction.read().get());
    }

    public void write(User user){
        this.users.add(new User.UserBuilder()
                        .setUsername(user.getUsername())
                        .setFirstName(user.getFirstName())
                        .setLastName(user.getLastName())
                        .build()
        );
    }

    public Optional<List<User>> read(){
        return this.transaction.read();
    }
}
