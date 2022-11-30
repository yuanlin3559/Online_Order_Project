package com.example.onlineorder1.service;

import com.example.onlineorder1.dao.CustomerDao;
import com.example.onlineorder1.entity.Cart;
import com.example.onlineorder1.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerDao customerDao;

    @Autowired
    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public void signUp(Customer customer) {
        Cart cart = new Cart();
        customer.setCart(cart);

        customer.setEnabled(true);
        customerDao.signUp(customer);
    }

    public Customer getCustomer(String email) {
        return customerDao.getCustomer(email);
    }
}


