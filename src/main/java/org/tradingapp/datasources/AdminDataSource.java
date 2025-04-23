package org.tradingapp.datasources;

import org.tradingapp.entities.Admin;

import java.util.ArrayList;
import java.util.List;

public class AdminDataSource {

    private List<Admin> admins = new ArrayList<>();

    public AdminDataSource(){
        admins.add(new Admin(
                "Budi",
                "Budi Santoso",
                "Budi123"
        ));

        admins.add(new Admin(
                "Erpan",
                "Erpan Gemink",
                "Erpan1472"
        ));
    }

    public List<Admin> findAll(){
        return this.admins;
    }

    public Admin findByUsername(String username){
        for(Admin admin : admins){
            if(admin.getUsername().equals(username)){
                return admin;
            }
        }

        return null;
    }
}
