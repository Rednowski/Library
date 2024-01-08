package pl.edu.wszib.library.db;

import pl.edu.wszib.library.user.User;

public class UserRepository {
    private final User[] users = new User[3];

    public UserRepository(){
        this.users[0] = new User("admin", "0192023a7bbd73250516f069df18b500");
        this.users[1] = new User("andrzej", "24cd03e1752f1042c8c9a313da6a235d");
        this.users[2] = new User("maciek", "c91b49caa8e3eb9d25707dda954a4351");
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
