package pl.edu.wszib.library.authorization;

import org.apache.commons.codec.digest.DigestUtils;
import pl.edu.wszib.library.db.UserRepository;
import pl.edu.wszib.library.user.User;

public class Authenticator {

    private final String SEED = "G+sEZa6.VvKrXM.krA0S+3[v-TUVy-";
    private final UserRepository userRepository = new UserRepository();
    public boolean authenticate(String login, String password){
        User user = userRepository.getByLogin(login);
        return user != null && user.getPassword()
                .equals(DigestUtils.md5Hex((password)+SEED));
    }
}
