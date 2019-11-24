package blog.com.model;

import javax.persistence.*;

@Entity
@Table(name = "Blog")
public class Blog {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String  blogTitle;
    private String content;
    private String author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Blog() {
    }

    public Blog(Long id, String blogTitle, String content, String author) {
        this.id = id;
        this.blogTitle = blogTitle;
        this.content = content;
        this.author = author;
    }
}
