package org.example.data;

/**
 * Created by: Abdulaziz Pulatjonov
 * Date: 7/7/2023 10:18
 */

public class User {
    private String firstName;
    private String lastName;
    private String username;

    private User(String firstName, String lastName, String username){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    /**
     * Builder Creational Design Pattern is used for convenience
     */
    public static class UserBuilder{
        private String firstName;
        private String lastName;
        private String username;

        public UserBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public User build(){
            return new User(this.firstName, this.lastName, this.username);
        }
    }

    @Override
    public String toString(){
        return "Firstname: " + this.firstName + "\nLastname: " + this.lastName + "\nUsername: " + this.username + "\n";
    }

}
