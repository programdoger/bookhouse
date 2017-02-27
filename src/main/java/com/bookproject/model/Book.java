package com.bookproject.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Administrator on 2017/2/24.
 */
@Entity
@Table(name = "bh_book")
public class Book {
    private int id;
    private int ClickCount; //总点击数
    private int Grade;      //评分
    private String BookName;    //书籍名称
    private String Author;      //作者
    private String NewDate;     //最后更新时间
    private String ChapterCount;    //章节总数
    private String BookINtro;   //书籍简介
    private String BookPath;    //书籍保存目录
    private Set<Comment> comments;    //书籍评论

    public Book() {
    }

    public Book(int clickCount, int grade, String bookName, String author, String newDate, String chapterCount, String bookINtro, String bookPath, Set<Comment> comments) {
        ClickCount = clickCount;
        Grade = grade;
        BookName = bookName;
        Author = author;
        NewDate = newDate;
        ChapterCount = chapterCount;
        BookINtro = bookINtro;
        BookPath = bookPath;
        this.comments = comments;
    }

    public Book(int id, int clickCount, int grade, String bookName, String author, String newDate, String chapterCount, String bookINtro, String bookPath, Set<Comment> comments) {
        this.id = id;
        ClickCount = clickCount;
        Grade = grade;
        BookName = bookName;
        Author = author;
        NewDate = newDate;
        ChapterCount = chapterCount;
        BookINtro = bookINtro;
        BookPath = bookPath;
        this.comments = comments;
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

    public int getClickCount() {
        return ClickCount;
    }

    public void setClickCount(int clickCount) {
        ClickCount = clickCount;
    }

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int grade) {
        Grade = grade;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getNewDate() {
        return NewDate;
    }

    public void setNewDate(String newDate) {
        NewDate = newDate;
    }

    public String getChapterCount() {
        return ChapterCount;
    }

    public void setChapterCount(String chapterCount) {
        ChapterCount = chapterCount;
    }

    public String getBookINtro() {
        return BookINtro;
    }

    public void setBookINtro(String bookINtro) {
        BookINtro = bookINtro;
    }

    public String getBookPath() {
        return BookPath;
    }

    public void setBookPath(String bookPath) {
        BookPath = bookPath;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    @OrderBy(value = "createDate desc")
    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", ClickCount=" + ClickCount +
                ", Grade=" + Grade +
                ", BookName='" + BookName + '\'' +
                ", Author='" + Author + '\'' +
                ", NewDate='" + NewDate + '\'' +
                ", ChapterCount='" + ChapterCount + '\'' +
                ", BookINtro='" + BookINtro + '\'' +
                ", comments=" + comments +
                '}';
    }
}
