package org.tradingapp.services;
import org.tradingapp.datasources.CustomerDataSource;
import org.tradingapp.entities.Customer;

public class CustomerLoginService {

    private CustomerDataSource customerDataSource = new CustomerDataSource();

    public CustomerLoginService() {}

    public Boolean isUsernameExist(String username) {
        Customer customer = customerDataSource.findByUsername(username);
        return customer != null;
    }

    public Customer login(String username, String password) {
        Customer customer = customerDataSource.findByUsername(username);
        if (customer != null && customer.getPassword().equals(password)) {
            return customer;
        }
        return null;
    }
}