package com.compubase.mhmd.alosboiya;
public class CommentsItem {
    private String commentdate;
    private String commentuser;
    private String commenttext;

    public CommentsItem(String commentdate, String commentuser, String commenttext) {
        this.commentdate = commentdate;
        this.commentuser = commentuser;
        this.commenttext = commenttext;
    }

    public String getCommentdate() {
        return commentdate;
    }

    public void setCommentdate(String commentdate) {
        this.commentdate = commentdate;
    }

    public String getCommentuser() {
        return commentuser;
    }

    public void setCommentuser(String commentuser) {
        this.commentuser = commentuser;
    }

    public String getCommenttext() {
        return commenttext;
    }

    public void setCommenttext(String commenttext) {
        this.commenttext = commenttext;
    }
}
