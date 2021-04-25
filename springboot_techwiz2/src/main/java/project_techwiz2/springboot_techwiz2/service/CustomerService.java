package project_techwiz2.springboot_techwiz2.service;

import org.springframework.data.domain.Page;
import project_techwiz2.springboot_techwiz2.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomer();
    Customer getCustomerById(int id);
    Page<Customer> findPaginated(int pageNo,int pageSize);
}
