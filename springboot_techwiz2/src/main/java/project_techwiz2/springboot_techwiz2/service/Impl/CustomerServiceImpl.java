package project_techwiz2.springboot_techwiz2.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project_techwiz2.springboot_techwiz2.model.Customer;
import project_techwiz2.springboot_techwiz2.repository.CustomerRepository;
import project_techwiz2.springboot_techwiz2.service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomer() {
        try{
            List<Customer> list = customerRepository.findAll();
            return list;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Customer getCustomerById(int id) {
        try{
            Customer customer = customerRepository.findById(id).get();
            return customer;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Page<Customer> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return this.customerRepository.findAll(pageable);
    }
}
