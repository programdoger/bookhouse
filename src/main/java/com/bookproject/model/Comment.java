package com.bookproject.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Administrator on 2017/2/24.
 */
@Entity
@Table(name = "bh_comment")
public class Comment {
    private int id;
    private int content; //评论内容
    private Date CreateDate; //评论时间


    public Comment() {
    }

    public Comment(int content, Date createDate) {
        this.content = content;
        CreateDate = createDate;
    }

    public Comment(int id, int content, Date createDate) {
        this.id = id;
        this.content = content;
        CreateDate = createDate;
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

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content=" + content +
                ", CreateDate=" + CreateDate +
                '}';
    }
}
