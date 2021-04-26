package project_techwiz2.springboot_techwiz2.controller.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project_techwiz2.springboot_techwiz2.config.exeption.ErrorDetails;
import project_techwiz2.springboot_techwiz2.config.exeption.ResourceNotFoundException;
import project_techwiz2.springboot_techwiz2.model.ClImage;
import project_techwiz2.springboot_techwiz2.model.Customer;
import project_techwiz2.springboot_techwiz2.repository.CustomerRepository;
import project_techwiz2.springboot_techwiz2.service.CdService;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "api/customer")
public class CustomerApiController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private CdService cdService;
    @RequestMapping(path = "")
    public List<Customer> getCustomer()
    {
        List<Customer> list = customerRepository.findAll();
        return list;
    }

    @RequestMapping(path = "/register",method = RequestMethod.POST)
    public ResponseEntity<?> saveCustomer(@Valid @RequestBody Customer customer)throws IOException
    {
        boolean bl =checkEmail(customer);
        if (bl){
            customer.setPassword(passwordEncoder.encode(customer.getPassword()));
            customerRepository.save(customer);
            return new ResponseEntity<Customer>(customer, HttpStatus.OK);
        }
        else {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setTimestamp(new Date());
            errorDetails.setMessage("Email already exists");
            return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
        }

    }
    @RequestMapping(path = "/updateAvatar",method = RequestMethod.POST)
    public ResponseEntity<?> updateFileImg(@RequestParam("id")int id, @RequestParam("file_avatar") MultipartFile multipartFile)throws IOException
    {
        try{
            Customer custUpdate = customerRepository.findById(id).get();
            if (multipartFile.getSize()>0)
            {
                Map result = cdService.upload(multipartFile);
                ClImage clImage = new ClImage((String)result.get("secure_url"));
                custUpdate.setAvatar(clImage.getUrl());
            }
            customerRepository.save(custUpdate);
            return new ResponseEntity<Customer>(custUpdate,HttpStatus.OK);
        }catch (NoSuchElementException e)
        {

        }
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setTimestamp(new Date());
        errorDetails.setMessage("Update unsuccessful");
        return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "/updateCustomer",method = RequestMethod.POST)
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer)throws IOException
    {
        try{
            Customer custUpdate = customerRepository.findById(customer.getCustomer_id()).get();
            if (customer.getAddress()!="")
            {
                custUpdate.setAddress(customer.getAddress());
            }
            if (customer.getPhonenumber()!="")
            {
                custUpdate.setPhonenumber(customer.getPhonenumber());
            }
            customerRepository.save(custUpdate);
            return new ResponseEntity<Customer>(custUpdate,HttpStatus.OK);
        }catch (NoSuchElementException e){}
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setTimestamp(new Date());
        errorDetails.setMessage("Update unsuccessful");
        return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "/updatePassword",method = RequestMethod.POST)
    public ResponseEntity<?> updatePassword(@RequestParam("id")int id,@RequestParam("password_old")String pwd_old,@RequestParam("password_new")String pwd_new)
    {
        ErrorDetails errorDetails = new ErrorDetails();
        try{
            Customer customer = customerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found with id :"+id));
            boolean bl = passwordEncoder.matches(pwd_old,customer.getPassword());
            if (bl)
            {
                customer.setPassword(passwordEncoder.encode(pwd_new));
                customerRepository.save(customer);
                return new ResponseEntity<Customer>(customer,HttpStatus.OK);
            }else{
                errorDetails.setMessage("Password is incorrect");
            }

        }catch (NoSuchElementException e)
        {
            errorDetails.setMessage("Exception");
        }
        errorDetails.setTimestamp(new Date());

        return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "/login")
    public ResponseEntity<?> loginCustomer(@RequestParam("email")String email, @RequestParam("password")String pwd)
    {
        try{
            List<Customer> list = customerRepository.findAll();
            for (Customer cust: list) {
                if (cust.getEmail().equals(email))
                {
                    boolean bl = passwordEncoder.matches(pwd,cust.getPassword());
                    if (bl)
                    {
                        Customer customer = customerRepository.findById(cust.getCustomer_id()).get();
                        return new ResponseEntity<Customer>(customer,HttpStatus.OK);
                    }
                }
            }
        }catch (NoSuchElementException e){}
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setTimestamp(new Date());
        errorDetails.setMessage("Account password incorrect");
        return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "/{id}")
    public Customer getCustomerById(@PathVariable(value = "id")Integer id)
    {
        Customer customer = customerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found with id :"+id));
        return customer;
    }
    //check email
    public boolean checkEmail(Customer customer)
    {
        Customer bl = customerRepository.findByEmail(customer.getEmail());
        if (bl==null)
        {
            return true;
        }
        if (bl.getEmail().equals(customer.getEmail()))
        {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setTimestamp(new Date());
            errorDetails.setMessage("Email already exists");

        }
        return false;
    }

}
