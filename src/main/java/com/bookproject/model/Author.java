package com.bookproject.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Administrator on 2017/2/24.
 */
@Entity
@Table(name = "bh_author")
public class Author {
    private int id;
    private String AuthorName; //作者姓名
    private Set<Book> books; //作者的书籍

    public Author() {
    }

    public Author(String authorName, Set<Book> books) {
        AuthorName = authorName;
        this.books = books;
    }

    public Author(int id, String authorName, Set<Book> books) {
        this.id = id;
        AuthorName = authorName;
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

    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String authorName) {
        AuthorName = authorName;
    }
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    @OrderBy(value = "createDate desc")
    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", AuthorName='" + AuthorName + '\'' +
                ", books=" + books +
                '}';
    }
}
