package pl.edu.wszib.library.db;

import pl.edu.wszib.library.App;
import pl.edu.wszib.library.book.Book;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
public class BookRepository {
    Scanner scanner = new Scanner(System.in);
    private final ArrayList<Book> books = new ArrayList<>();
    public BookRepository(){
        this.books.add(new Book("Dzieci z Bullerbyn",
                "Astrid Lindgren", 1234567890120L));
    }

    public ArrayList<Book> getBooks(){
        ArrayList<Book> result = new ArrayList<>();
        try{
            String sql = "SELECT * FROM tbook";
            PreparedStatement preparedStatement = App.connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setIsbn(rs.getLong("isbn"));
                book.setStartDate(rs.getDate("startDate") != null ?
                        rs.getDate("startDate").toLocalDate() : null);
                book.setEndDate(rs.getDate("endDate") != null ?
                        rs.getDate("endDate").toLocalDate() : null);
                book.setRent(rs.getBoolean("rent"));
                book.setfullName(rs.getString("fullname"));

                result.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean rent(long isbn){
        try{
            String sql = "SELECT * FROM tbook WHERE isbn = ?";
            PreparedStatement preparedStatement = App.connection.prepareStatement(sql);
            preparedStatement.setLong(1, isbn);

            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                boolean rent = rs.getBoolean("rent");
                if(!rent){
                    System.out.println("Enter your fullname");
                    String fullName = scanner.nextLine();
                    int id = rs.getInt("id");
                    String updateSql = "UPDATE tbook SET rent = ?, fullname = ?, startDate = ?, endDate = ? WHERE id = ?";
                    PreparedStatement updatePreparedStatement = App.connection.prepareStatement(updateSql);
                    updatePreparedStatement.setBoolean(1, true);
                    updatePreparedStatement.setString(2, fullName);
                    updatePreparedStatement.setDate(3, Date.valueOf(LocalDate.now()));
                    updatePreparedStatement.setDate(4, Date.valueOf(LocalDate.now().plusDays(14)));
                    updatePreparedStatement.setInt(5, id);

                    updatePreparedStatement.executeUpdate();
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean returnBook(long isbn){
        try{
            String sql = "SELECT * FROM tbook WHERE isbn = ?";
            PreparedStatement preparedStatement = App.connection.prepareStatement(sql);
            preparedStatement.setLong(1, isbn);

            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                boolean rent = rs.getBoolean("rent");
                if(rent){
                    int id = rs.getInt("id");
                    String updateSql = "UPDATE tbook SET rent = ?, fullname = ?, startDate = ?, endDate = ? WHERE id = ?";
                    PreparedStatement updatePreparedStatement = App.connection.prepareStatement(updateSql);
                    updatePreparedStatement.setBoolean(1, false);
                    updatePreparedStatement.setNull(2, Types.VARCHAR);
                    updatePreparedStatement.setNull(3, Types.DATE);
                    updatePreparedStatement.setNull(4, Types.DATE);
                    updatePreparedStatement.setInt(5, id);

                    updatePreparedStatement.executeUpdate();
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addBook(){
        System.out.println("Enter title: ");
        String title = scanner.nextLine();
        System.out.println("Enter author: ");
        String author = scanner.nextLine();
        System.out.println("Enter ISBN: ");
        long isbn = scanner.nextLong();
        scanner.nextLine();
        try {
            String sql = "INSERT INTO tbook (title, author, isbn, startDate, endDate, rent, fullname) VALUES (?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement = App.connection.prepareStatement(sql);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, author);
            preparedStatement.setLong(3, isbn);
            preparedStatement.setNull(4, Types.DATE);
            preparedStatement.setNull(5, Types.DATE);
            preparedStatement.setBoolean(6, false);
            preparedStatement.setNull(7, Types.VARCHAR);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void saveBook(Book book){
        try {
            String sql = "INSERT INTO tbook (title, author, isbn, startDate, endDate, rent, fullname) VALUES (?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement = App.connection.prepareStatement(sql);

            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setLong(3, book.getIsbn());
            if (book.getStartDate() != null) {
                preparedStatement.setDate(4, java.sql.Date.valueOf(book.getStartDate()));
            } else {
                preparedStatement.setNull(4, java.sql.Types.DATE);
            }
            if (book.getEndDate() != null) {
                preparedStatement.setDate(5, java.sql.Date.valueOf(book.getEndDate()));
            } else {
                preparedStatement.setNull(5, java.sql.Types.DATE);
            }
            preparedStatement.setBoolean(6, book.isRent());
            preparedStatement.setString(7, book.getfullName());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
