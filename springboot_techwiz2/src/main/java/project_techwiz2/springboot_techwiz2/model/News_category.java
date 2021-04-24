package project_techwiz2.springboot_techwiz2.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
public class News_category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int news_cate_id;

    @NotEmpty(message = "News category name must not be empty")
    @Size(min = 5,max = 30)
    private String cate_name;

    private Date created;
    private Date updated;

    @OneToMany(mappedBy = "news_category")
    private Set<News> news(){
        return this.news();
    }

    public News_category() {
    }

    public News_category(@NotEmpty(message = "News category name must not be empty") @Size(min = 5, max = 30) String cate_name, Date created, Date updated) {
        this.cate_name = cate_name;
        this.created = created;
        this.updated = updated;
    }

    public int getNews_cate_id() {
        return news_cate_id;
    }

    public void setNews_cate_id(int news_cate_id) {
        this.news_cate_id = news_cate_id;
    }

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
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
}
