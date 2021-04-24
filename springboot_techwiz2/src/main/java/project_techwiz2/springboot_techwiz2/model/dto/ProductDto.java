package project_techwiz2.springboot_techwiz2.model.dto;


import project_techwiz2.springboot_techwiz2.model.core.Category_detail;
import project_techwiz2.springboot_techwiz2.model.core.Order_detail;
import project_techwiz2.springboot_techwiz2.model.core.Product_menu_detail;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "product")
public class ProductDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int product_id;
    @NotEmpty(message = "Product name  must not empty")
    @Size(min = 3,max = 30)
    @Column(name = "product_name")
    private String product_name;
    @NotEmpty(message = "Price must not empty")
    @Column(name = "price")
    private double price;
    @Column(name = "discount")
    private int discount;
    @NotEmpty(message = "Description  must not empty")
    @Column(name = "descriptions")
    private String descriptions;
    @Column(name = "status")
    private int status;
    @NotEmpty(message = "priority must not empty")
    @Column(name = "priority")
    private int priority;
    @NotEmpty(message = "Image must not empty")
    @Column(name = "image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "cate_detail_id",referencedColumnName = "cate_detail_id")
    private Category_detail category_detail;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category_detail getCategory_detail() {
        return category_detail;
    }

    public void setCategory_detail(Category_detail category_detail) {
        this.category_detail = category_detail;
    }
}
