package pl.edu.wszib.library.db;

import pl.edu.wszib.library.user.User;

public class UserRepository {
    private final User[] users = new User[3];

    public UserRepository(){
        this.users[0] = new User("admin", "74d59448f47ef6411ea1e7d4d8154195");
        this.users[1] = new User("andrzej", "6be24e95ece41b2e3cc91196330c1d5c");
        this.users[2] = new User("maciek", "ec978f1a4d3531a3d55e93771993e02f");
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
