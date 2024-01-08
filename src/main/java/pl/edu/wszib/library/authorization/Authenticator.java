package pl.edu.wszib.library.authorization;

import pl.edu.wszib.library.db.UserRepository;
import pl.edu.wszib.library.user.User;

public class Authenticator {

    private final UserRepository userRepository = new UserRepository();
    public boolean authenticate(String login, String password){
        User user = userRepository.getByLogin(login);
        return user != null && user.getPassword().equals(password);
    }
}
