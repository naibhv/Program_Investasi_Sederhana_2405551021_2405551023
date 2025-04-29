package org.tradingapp.userinterfaces;
import org.tradingapp.entities.Admin;
import org.tradingapp.services.AdminLoginService;

import java.util.Scanner;

public class AdminLoginInterface {

    public AdminLoginInterface(){}

    public void display(){
        Scanner scanner = new Scanner(System.in);
        AdminLoginService adminLoginService = new AdminLoginService();

        while (true) {
            System.out.println("|============================================================|");
            System.out.print("     Enter admin username: ");
            String inputUsername = scanner.nextLine();
            if(!adminLoginService.isUsernameExist(inputUsername)){
                System.out.println("|------------------------------------------------------------|");
                System.out.println("|                      username Invalid.                     |");
                System.out.println("|------------------------------------------------------------|");
                continue;
            }

            System.out.print("     Enter password for " + inputUsername + ": ");
            String inputPassword = scanner.nextLine();

            Admin admin = adminLoginService.login(inputUsername , inputPassword);
            if (admin == null) {
                System.out.println("|------------------------------------------------------------|");
                System.out.println("|  Error: Incorrect password. Please enter username again.   |");
                System.out.println("|------------------------------------------------------------|");
                continue;
            }

            HomeAdminInterface homeAdminInterface = new HomeAdminInterface();
            homeAdminInterface.display(admin);
            break;
        }
    }
}