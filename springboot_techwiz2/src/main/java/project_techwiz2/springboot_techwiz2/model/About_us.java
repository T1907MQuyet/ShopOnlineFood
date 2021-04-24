package project_techwiz2.springboot_techwiz2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class About_us {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int news_id;

    @NotEmpty(message = "Please fill in News Name!")
    @Size(min = 3,max = 30,message = "News name size must be between 3 and 30 letters.")
    private String title;

    @NotEmpty(message = "Please fill in Description!")
    private String description;


    @NotEmpty(message = "Please fill in Content!")
    private String content;

    @NotEmpty(message = "Please fill in Image!")
    private String image;

    private Date created;
    private Date updated;
}
