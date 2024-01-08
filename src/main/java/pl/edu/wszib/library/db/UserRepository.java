package pl.edu.wszib.library.db;

import pl.edu.wszib.library.user.User;

public class UserRepository {
    private final User[] users = new User[3];

    public UserRepository(){
        this.users[0] = new User("admin", "admin123");
        this.users[1] = new User("andrzej", "andrzej123");
        this.users[2] = new User("maciek", "maciek123");
    }

    public User getByLogin(String login){
        for(User user : this.users){
            if(user.getLogin().equals(login)){
                return user;
            }
        }
        return null;
    }



}
