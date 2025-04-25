package org.tradingapp.services;
import org.tradingapp.datasources.AdminDataSource;
import org.tradingapp.entities.Admin;
import java.util.Scanner;

public class AdminLoginService {

    private AdminDataSource adminDataSource = new AdminDataSource();

    public AdminLoginService(){}

    public Boolean isUsernameExist(String username){
        Admin admin = adminDataSource.findByUsername(username);
        return admin != null;
    }

    public Admin login(String username, String password){
        Admin admin = adminDataSource.findByUsername(username);
        if(admin.getPassword().equals(password)) return admin;
        return null;
    }
}
