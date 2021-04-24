package project_techwiz2.springboot_techwiz2.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class News_product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Please fill in News Name!")
    @Size(min = 3,max = 30,message = "News name size must be between 3 and 30 letters.")
    private String name;

    @NotEmpty(message = "Please fill in Title!")
    private String title;

    @NotEmpty(message = "Please fill in Description!")
    private String description;

    @NotEmpty(message = "Please fill in Image!")
    private String image;

    @NotEmpty(message = "Please fill in Content!")
    private String content;

    @NotEmpty(message = "Please fill in Author!")
    private String author;

    private int show;
    private Date created;
    private Date updated;

    @ManyToOne
    @JoinColumn(name = "cate_new_id",referencedColumnName = "news_cate_id")
    private News_category news_category;

    public News_product() {
    }

    public News_product(@NotEmpty(message = "Please fill in News Name!") @Size(min = 3, max = 30, message = "News name size must be between 3 and 30 letters.") String name, @NotEmpty(message = "Please fill in Title!") String title, @NotEmpty(message = "Please fill in Description!") String description, @NotEmpty(message = "Please fill in Image!") String image, @NotEmpty(message = "Please fill in Content!") String content, @NotEmpty(message = "Please fill in Author!") String author, int show, Date created, Date updated, News_category news_category) {
        this.name = name;
        this.title = title;
        this.description = description;
        this.image = image;
        this.content = content;
        this.author = author;
        this.show = show;
        this.created = created;
        this.updated = updated;
        this.news_category = news_category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public int getShow() {
        return show;
    }

    public void setShow(int show) {
        this.show = show;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public News_category getNews_category() {
        return news_category;
    }

    public void setNews_category(News_category news_category) {
        this.news_category = news_category;
    }
}
