package com.bookproject.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Administrator on 2017/2/24.
 */
@Entity
@Table(name = "bh_classify")
public class Classify {
    private int id;
    private int BookCount; //书籍总数
    private String BookType;   //书籍类型
    private Set<Book> books;

    public Classify() {
    }

    public Classify(int bookCount, String bookType, Set<Book> books) {
        BookCount = bookCount;
        BookType = bookType;
        this.books = books;
    }

    public Classify(int id, int bookCount, String bookType, Set<Book> books) {
        this.id = id;
        BookCount = bookCount;
        BookType = bookType;
        this.books = books;
    }

    @Id
    @GenericGenerator(name = "native",strategy = "native")
    @GeneratedValue(generator = "native")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookCount() {
        return BookCount;
    }

    public void setBookCount(int bookCount) {
        BookCount = bookCount;
    }

    public String getBookType() {
        return BookType;
    }

    public void setBookType(String bookType) {
        BookType = bookType;
    }

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "classify_id")
    @OrderBy(value = "createDate desc")
    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "BookType{" +
                "id=" + id +
                ", BookCount=" + BookCount +
                ", BookType='" + BookType + '\'' +
                ", books=" + books +
                '}';
    }
}
