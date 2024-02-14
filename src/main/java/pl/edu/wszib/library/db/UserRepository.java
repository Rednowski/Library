package pl.edu.wszib.library.db;

import pl.edu.wszib.library.App;
import pl.edu.wszib.library.user.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

    public UserRepository(){
    }

    public User getByLogin(String login){
       try {
           String sql = "SELECT * FROM tuser WHERE login = ?";
           PreparedStatement preparedStatement = App.connection.prepareStatement(sql);

           preparedStatement.setString(1, login);

           ResultSet rs = preparedStatement.executeQuery();
           if(rs.next()){
               return new User(rs.getInt("id"),
                       rs.getString("login"),
                       rs.getString("password"),
                       rs.getString("role"));
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return null;
    }



}
