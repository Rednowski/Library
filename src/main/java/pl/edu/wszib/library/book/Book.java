package pl.edu.wszib.library.book;
import java.time.LocalDate;
public class Book {
    private String title;
    private String author;
    private long isbn;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean rent;
    private String fullName;

    public Book(String title, String author, long isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.rent = false;
    }
    public Book(String title, String author, long isbn, LocalDate startDate,
                LocalDate endDate, boolean rent, String fullName) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rent = rent;
        this.fullName = fullName;
    }

    public Book(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isRent() {
        return rent;
    }

    public void setRent(boolean rent) {
        this.rent = rent;
    }

    public String getfullName() {
        return fullName;
    }

    public void setfullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString(){
        return new StringBuilder().append("\"")
        .append(this.getTitle())
        .append("\", ")
        .append(this.getAuthor())
        .append(", ")
        .append("ISBN: ")
        .append(this.getIsbn())
        .append(" ")
        .append(this.getStartDate() == null ? "" : this.getStartDate())
        .append(" - ")
        .append(this.getEndDate() == null ? "" : this.getEndDate())
        .append(" ")
        .append(this.isRent() ? " is rented " : " is not rented ")
                .append(this.getfullName() == null ? "" : "by ")
                .append(this.getfullName() == null ? "" : this.getfullName())
        .toString();
    }

}
