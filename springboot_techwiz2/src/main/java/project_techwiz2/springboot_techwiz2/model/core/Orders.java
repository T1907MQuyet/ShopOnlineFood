package project_techwiz2.springboot_techwiz2.model.core;

import project_techwiz2.springboot_techwiz2.model.Customer;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Set;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @NotEmpty(message = "full name  must not empty")
    private String fullname;
    @NotEmpty(message = "Email  must not empty")
    private String order_email;
    @NotEmpty(message = "address must not empty")
    private String order_address;

    private String order_note;
    private int status;
    @NotEmpty(message = "Payment  must not empty")
    private String payment;
    private double total_price;

    private Date created;
    private Date updated;

    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "orders")
    private Set<Order_detail> order_details()
    {
        return this.order_details();
    }

    public Orders() {
    }

    public Orders(@NotEmpty(message = "full name  must not empty") String fullname, @NotEmpty(message = "Email  must not empty") String order_email, @NotEmpty(message = "address must not empty") String order_address, String order_note, int status, @NotEmpty(message = "Payment  must not empty") String payment, double total_price, Customer customer) {
        this.fullname = fullname;
        this.order_email = order_email;
        this.order_address = order_address;
        this.order_note = order_note;
        this.status = status;
        this.payment = payment;
        this.total_price = total_price;
        this.customer = customer;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getOrder_email() {
        return order_email;
    }

    public void setOrder_email(String order_email) {
        this.order_email = order_email;
    }

    public String getOrder_address() {
        return order_address;
    }

    public void setOrder_address(String order_address) {
        this.order_address = order_address;
    }

    public String getOrder_note() {
        return order_note;
    }

    public void setOrder_note(String order_note) {
        this.order_note = order_note;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
