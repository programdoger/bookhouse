package com.bookproject.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Administrator on 2017/2/24.
 */
@Entity
@Table(name = "bh_user")
public class User {
    private int id;
    private int AccessRight;   //访问权限
    private String uName;      //用户名
    private String uPassword;   //密码
    private String NickName;    //昵称
    private String Sex;         //性别
    private String email;       //邮箱
    private String Telephone;  //电话号码
    private Date CreateDate;    //注册时间
    private Set<Comment> comments; //评论

    public User() {
    }

    public User(int accessRight, String uName, String uPassword, String nickName, String sex, String email, String telephone, Date createDate, Set<Comment> comments) {
        AccessRight = accessRight;
        this.uName = uName;
        this.uPassword = uPassword;
        NickName = nickName;
        Sex = sex;
        this.email = email;
        Telephone = telephone;
        CreateDate = createDate;
        this.comments = comments;
    }

    public User(int id, int accessRight, String uName, String uPassword, String nickName, String sex, String email, String telephone, Date createDate, Set<Comment> comments) {
        this.id = id;
        AccessRight = accessRight;
        this.uName = uName;
        this.uPassword = uPassword;
        NickName = nickName;
        Sex = sex;
        this.email = email;
        Telephone = telephone;
        CreateDate = createDate;
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

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public int getAccessRight() {
        return AccessRight;
    }

    public void setAccessRight(int accessRight) {
        AccessRight = accessRight;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @OrderBy(value = "createDate desc")
    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", AccessRight=" + AccessRight +
                ", uName='" + uName + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", NickName='" + NickName + '\'' +
                ", Sex='" + Sex + '\'' +
                ", email='" + email + '\'' +
                ", Telephone='" + Telephone + '\'' +
                ", CreateDate=" + CreateDate +
                ", comments=" + comments +
                '}';
    }
}
