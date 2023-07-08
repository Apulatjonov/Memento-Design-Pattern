package org.example;

import org.example.caretaker.Connection;
import org.example.data.User;

/**
 * Created by: Abdulaziz Pulatjonov
 * Date: 7/7/2023 10:17
 */
public class Main {
    public static void main(String[] args) {

        Connection connection = new Connection();
        connection.write(new User.UserBuilder()
                        .setFirstName("user 1")
                        .setLastName("lastName")
                        .setUsername("userName")
                .build());
        connection.save();
        System.out.println("State 1");
        for (User user : connection.read().get()){
            System.out.println(user.toString());
        }
        connection.write(
                new User.UserBuilder()
                        .setFirstName("user 2")
                        .setLastName("lastName")
                        .setUsername("userName")
                        .build()
        );
        connection.rollback();
        System.out.println("State 2");
        for (User user : connection.read().get()){
            System.out.println(user.toString());
        }
        connection.save();
        connection.write(
                new User.UserBuilder()
                        .setFirstName("user 3")
                        .setLastName("lastName")
                        .setUsername("userName")
                        .build()
        );
        connection.write(
                new User.UserBuilder()
                        .setFirstName("user 4")
                        .setLastName("lastName")
                        .setUsername("userName")
                        .build()
        );
        connection.save();
        System.out.println("State 3");
        for (User user : connection.read().get()){
            System.out.println(user.toString());
        }
    }
}