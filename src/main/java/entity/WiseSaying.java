package entity;

import java.io.Serializable;

public class WiseSaying implements Serializable {
    private String saying;
    private String author;
    private long id;

    public WiseSaying(String saying, String author, long id) {
        this.saying = saying;
        this.author = author;
        this.id = id;
    }

    public String getSaying() {
        return saying;
    }

    public void setSaying(String saying) {
        this.saying = saying;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
