package org.tradingapp.datasources;
import org.tradingapp.entities.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerDataSource {
    private List<Customer> customers = new ArrayList<>();

    public CustomerDataSource() {
        customers.add(new Customer(
                "Aksa",
                "Aksara Mulia",
                "Aksa268"
        ));

        customers.add(new Customer(
                "Karin",
                "Bunga Karina",
                "Karin890"
        ));
    }

    public List<Customer> findAll() {
        return this.customers;
    }

    public Customer findByUsername(String username) {
        for (Customer customer : customers) {
            if (customer.getUsername().equals(username)) {
                return customer;
            }
        }
        return null;
    }
}