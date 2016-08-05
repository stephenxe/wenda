package com.nowcoder.model;

import java.util.Date;

/**
 * Created by Administrator on 2016/8/5.
 */
public class Question {

    private int id;
    private String title;
    private String content;
    private int userId;
    private Date createdDate;
    private int commentCount;

    public Question() {
    }

    public Question(String title, String content, int userId, Date createdDate, int commentCount) {
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.createdDate = createdDate;
        this.commentCount = commentCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", createdDate=" + createdDate +
                ", commentCount=" + commentCount +
                '}';
    }
}
