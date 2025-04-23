package org.tradingapp.entities;

public class Admin extends User {

    private String name;

    public Admin(String name, String username, String password) {
        super(username, password);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

