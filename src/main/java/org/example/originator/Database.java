package org.example.originator;

import org.example.data.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by: Abdulaziz Pulatjonov
 * Date: 7/7/2023 10:17
 */

public class Database {
    private List<User> users;

    public Database() {
        this.users = new ArrayList<>();
    }

    public void save(List<User> users) {
        this.users = users;
    }

    public Optional<List<User>> read(){
        return Optional.of(this.users);
    }
}
